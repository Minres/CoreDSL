package com.minres.coredsl.services.visualization

import com.minres.coredsl.coreDsl.Assignment
import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.Attribute
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BitValue
import com.minres.coredsl.coreDsl.BoolConstant
import com.minres.coredsl.coreDsl.CompoundStatement
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.DesignatedInitializer
import com.minres.coredsl.coreDsl.Designator
import com.minres.coredsl.coreDsl.Declarator
import com.minres.coredsl.coreDsl.Encoding
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.FloatConstant
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.IfStatement
import com.minres.coredsl.coreDsl.Import
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.InitDeclarator
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.IterationStatement
import com.minres.coredsl.coreDsl.JumpStatement
import com.minres.coredsl.coreDsl.LabeledStatement
import com.minres.coredsl.coreDsl.ParameterDeclaration
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.SpawnStatement
import com.minres.coredsl.coreDsl.StringLiteral
import com.minres.coredsl.coreDsl.StructDeclaration
import com.minres.coredsl.coreDsl.StructDeclarationSpecifier
import com.minres.coredsl.coreDsl.StructOrUnion
import com.minres.coredsl.coreDsl.SwitchStatement
import com.minres.coredsl.services.visualization.VisualElement.DeclarationLiteral
import com.minres.coredsl.services.visualization.VisualElement.Literal
import com.minres.coredsl.services.visualization.VisualElement.NodeElement
import com.minres.coredsl.services.visualization.VisualElement.Port
import com.minres.coredsl.services.visualization.VisualElement.PortGroup
import com.minres.coredsl.services.visualization.VisualElement.PortNode
import com.minres.coredsl.services.visualization.VisualElement.ReferenceLiteral
import com.minres.coredsl.services.visualization.VisualElement.VisualNode
import java.util.ArrayList
import java.util.IdentityHashMap
import java.util.List
import java.util.Map
import java.util.function.Supplier
import org.eclipse.emf.ecore.EObject
import com.minres.coredsl.coreDsl.FunctionCallExpression
import com.minres.coredsl.coreDsl.ArrayAccessExpression
import com.minres.coredsl.coreDsl.MemberAccessExpression
import com.minres.coredsl.coreDsl.CompositeTypeSpecifier
import com.minres.coredsl.coreDsl.EnumTypeSpecifier
import com.minres.coredsl.coreDsl.BoolTypeSpecifier
import com.minres.coredsl.coreDsl.VoidTypeSpecifier
import com.minres.coredsl.coreDsl.FloatTypeSpecifier
import com.minres.coredsl.coreDsl.IntegerTypeSpecifier
import com.minres.coredsl.coreDsl.CharacterConstant
import com.minres.coredsl.coreDsl.StringConstant
import com.minres.coredsl.coreDsl.ParenthesisExpression
import com.minres.coredsl.coreDsl.ExpressionInitializer
import com.minres.coredsl.coreDsl.ListInitializer
import com.minres.coredsl.coreDsl.EntityReference

class Visualizer {
	
	List<VisualNode> visualNodes;
	Map<EObject, VisualNode> astToVisual;
	Map<EObject, DeclarationLiteral> declarationLiterals;

	synchronized def VisualGraph buildVisualGraph(EObject rootNode, boolean decorate) {
		visualNodes = new ArrayList();
		astToVisual = new IdentityHashMap();
		declarationLiterals = new IdentityHashMap();
		var VisualNode root = visit(rootNode);
		if(decorate) decorate();
		var VisualGraph graph = new VisualGraph(root, visualNodes, astToVisual);
		visualNodes = null;
		astToVisual = null;
		declarationLiterals = null;
		return graph;
	}
	
	private def void decorate() {
		for(VisualNode visual : visualNodes) {
			if(visual instanceof ReferenceLiteral) {
				var ReferenceLiteral reference = visual as ReferenceLiteral;
				// only resolve references in decorate() to avoid errors if executed before context analysis
				var EObject targetNode = reference.resolver.get();
				reference.declaration = declarationLiterals.get(targetNode);
			}
		}
	}
	
	private def VisualNode visit(EObject node) {
		return genNode(node);
	}
	
	/* ******************
	 * Helper functions *
	 ****************** */
	
	private def void registerNode(VisualNode visual, EObject ast) {
		visualNodes.add(visual);
		if(ast !== null) astToVisual.put(ast, visual);
	}
	
	private def VisualNode makeNode(EObject astNode, String label, NodeElement... children) {
		if(astNode === null) return null;
		var list = new ArrayList(children.length);
		for (child : children) {
			if(child !== null)
				list.add(child);
		}
		var VisualNode node = new PortNode(label, list);
		registerNode(node, astNode);
		return node;
	}
	
	private def VisualNode makeNode(EObject astNode, String label, List<? extends EObject> children) {
		if(astNode === null) return null;
		var List<NodeElement> elements = new ArrayList(children.size());
		for(var int i = 0; i < children.size(); i++) {
			var child = children.get(i);
			if(child !== null)
				elements.add(makeChild(Integer.toString(i + 1), child));
		}
		var node = new PortNode(label, elements);
		registerNode(node, astNode);
		return node;
	}
	
	private def VisualNode makeImmediateLiteral(String content) {
		var Literal literal = new Literal(content);
		registerNode(literal, null);
		return literal;
	}
	
	private def NodeElement makeNamedLiteral(String label, String content) {
		if(content === null) return null;
		var Literal literal = new Literal(content);
		registerNode(literal, null);
		return new Port(label, literal);
	}
	
	private def NodeElement makeDeclaration(String label, String content, EObject owner) {
		if(content === null) return null;
		var DeclarationLiteral literal = new DeclarationLiteral(content);
		registerNode(literal, null);
		declarationLiterals.put(owner, literal);
		return new Port(label, literal);
	}
	
	private def NodeElement makeReference(String label, String content, Supplier<EObject> referenceResolver) {
		if(content === null) return null;
		var ReferenceLiteral literal = new ReferenceLiteral(content, referenceResolver);
		registerNode(literal, null);
		return new Port(label, literal);
	}
	
	private def NodeElement makeChild(String label, EObject node) {
		if(node === null) return null;
		return new Port(label, visit(node));
	}
	
	private def NodeElement makeGroup(String label, List<? extends EObject> children) {
		if(children === null || children.size == 0) return null;
		var List<NodeElement> elements = new ArrayList(children.size());
		for(var int i = 0; i < children.size(); i++) {
			var child = children.get(i);
			if(child !== null)
				elements.add(makeChild(Integer.toString(i + 1), child));
		}
		return new PortGroup(label, elements);
	}
	
	private def NodeElement makePortGroup(String label, List<? extends VisualNode> children) {
		if(children === null || children.size == 0) return null;
		var List<NodeElement> elements = new ArrayList(children.size());
		for(var int i = 0; i < children.size(); i++) {
			var child = children.get(i);
			if(child !== null)
				elements.add(new Port(Integer.toString(i + 1), child));
		}
		return new PortGroup(label, elements);
	}
	
	/* *****************
	 * Visitor methods *
	 ***************** */
	
	private def dispatch VisualNode genNode(EObject node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	// module
	
	private def dispatch VisualNode genNode(DescriptionContent node) {
		return makeNode(node, "Core Description",
			makeGroup("Imports", node.imports),
			makeGroup("Definitions", node.definitions)
		)
	}
	
	private def dispatch VisualNode genNode(Import node) {
		return makeNode(node, "Import",
			makeNamedLiteral("URI", node.importURI)
		);
	}
	
	private def dispatch VisualNode genNode(InstructionSet node) {
		return makeNode(node, "Instruction Set",
			makeNamedLiteral("Name", node.name),
			makeNamedLiteral("Super Type", node.superType?.name),
			makeGroup("Declarations", node.declarations),
			makeGroup("Functions", node.functions),
			makeGroup("Attributes", node.commonInstructionAttributes),
			makeGroup("Instructions", node.instructions)
		);
	}
	
	private def dispatch VisualNode genNode(CoreDef node) {
		return makeNode(node, "Instruction Set",
			makeNamedLiteral("Name", node.name),
			makeGroup("Contributing Type", node.contributingType),
			makeGroup("Declarations", node.declarations),
			makeGroup("Functions", node.functions),
			makeGroup("Attributes", node.commonInstructionAttributes),
			makeGroup("Instructions", node.instructions)
		)
	}
	
	private def dispatch VisualNode genNode(Instruction node) {
		return makeNode(node, "Instruction", 
			makeNamedLiteral("Name", node.name),
			makeChild("Encoding", node.encoding),
			makeNamedLiteral("Assembly Format", node.assembly),
			makeChild("Behavior", node.behavior)
		);
	}
	
	private def dispatch VisualNode genNode(Encoding node) {
		return makeNode(node, "Encoding", node.fields);
	}
	
	private def dispatch VisualNode genNode(BitField node) {
		return makeNode(node, "Bit Field",
			makeNamedLiteral("Name", node.name),
			makeChild("Left", node.left),
			makeChild("Right", node.right)
		)
	}
	
	private def dispatch VisualNode genNode(BitValue node) {
		return makeNode(node, "Bit Value",
			makeNamedLiteral("Value", node.value.toString)
		)
	}
	
	private def dispatch VisualNode genNode(FunctionDefinition node) {
		return node.extern
		? makeNode(node, "Function (extern)",
			makeChild("Return Type", node.type),
			makeNamedLiteral("Name", node.name),
			makeGroup("Parameters", node.parameters),
			makeGroup("Attributes", node.attributes)
		)
		: makeNode(node, "Function",
			makeChild("Return Type", node.type),
			makeNamedLiteral("Name", node.name),
			makeGroup("Parameters", node.parameters),
			makeChild("Body", node.statement),
			makeGroup("Attributes", node.attributes)
		);
	}
	
	private def dispatch VisualNode genNode(ParameterDeclaration node) {
		return makeNode(node, "Parameter",
			makeChild("Type", node.type),
			makeChild("Declarator", node.declarator)
		);
	}
	
	// statements
	
	private def dispatch VisualNode genNode(LabeledStatement node) {
		return makeNode(node, node.constExpr !== null ? "Case" : "Default", node.items);
	}
	
	private def dispatch VisualNode genNode(CompoundStatement node) {
		return makeNode(node, "Compound Statement", node.items);
	}
	
	private def dispatch VisualNode genNode(ExpressionStatement node) {
		return makeNode(node, "Expression Statement", 
			makeChild("Expression", node.expr)
		);
	}
	
	private def dispatch VisualNode genNode(IfStatement node) {
		return makeNode(node, "If Statement", 
			makeChild("Condition", node.cond),
			makeChild("Then Branch", node.thenStmt),
			makeChild("Else Branch", node.elseStmt)
		);
	}
	
	private def dispatch VisualNode genNode(SwitchStatement node) {
		return makeNode(node, "Switch Statement", 
			makeChild("Condition", node.cond),
			makeGroup("Branches", node.items)
		);
	}
	
	private def dispatch VisualNode genNode(IterationStatement node) {
		return makeNode(node, "Loop (" + node.type + ")",
			makeChild("Condition", node.cond),
			makeChild("Start Declaration", node.startDecl),
			makeChild("Start Assignment", node.startExpr),
			makeChild("Condition", node.endExpr),
			makeGroup("Loop Assignments", node.loopExprs),
			makeChild("Body", node.stmt)
		);
	}
	
	private def dispatch VisualNode genNode(JumpStatement node) {
		return makeNode(node, "Jump (" + node.type + ")",
			makeChild("Return Value", node.expr)
		);
	}
	
	private def dispatch VisualNode genNode(SpawnStatement node) {
		return makeNode(node, "Spawn Statement",
			makeChild("Body", node.stmt)
		);
	}
	
	// declarations
	
	private def dispatch VisualNode genNode(Declaration node) {
		return makeNode(node, "Declaration",
			makePortGroup("Storage", node.storage.map[specifier | makeImmediateLiteral(specifier.toString)]),
			makePortGroup("Qualifiers", node.qualifiers.map[qualifier | makeImmediateLiteral(qualifier.toString)]),
			makeGroup("Attributes", node.attributes),
			makeChild("Type", node.type),
			makeGroup("Declarators", node.declarators)
		);
	}
	
	private def dispatch VisualNode genNode(Attribute node) {
		return makeNode(node, "Attribute",
			makeNamedLiteral("Type", node.type.toString),
			makeGroup("Params", node.params)
		);
	}
	
	private def dispatch VisualNode genNode(VoidTypeSpecifier node) {
		return makeNode(node, "Void Type");
	}
	
	private def dispatch VisualNode genNode(BoolTypeSpecifier node) {
		return makeNode(node, "Bool Type");
	}
	
	private def dispatch VisualNode genNode(FloatTypeSpecifier node) {
		return makeNode(node, "Float Type",
			makeNamedLiteral("Shorthand", node.shorthand?.literal)
		);
	}
	
	private def dispatch VisualNode genNode(IntegerTypeSpecifier node) {
		return makeNode(node, "Integer Type",
			makeNamedLiteral("Signedness", node.signedness?.literal),
			makeNamedLiteral("Shorthand", node.shorthand?.literal),
			makeChild("Bit Size", node.size)
		);
	}
	
	private def dispatch VisualNode genNode(CompositeTypeSpecifier node) {
		return makeNode(node, node.composeType == StructOrUnion.STRUCT ? "Struct Type" : "Union Type",
			makeNamedLiteral("Name", node.name),
			makeGroup("Declarations", node.declaration)
		)
	}
	
	private def dispatch VisualNode genNode(EnumTypeSpecifier node) {
		return makeNode(node, "Enum Type",
			makeNamedLiteral("Name", node.name),
			makeGroup("Members", node.enumerators)
		)
	}
	
	private def dispatch VisualNode genNode(StructDeclaration node) {
		return makeNode(node, "Struct Declaration",
			makeChild("Specifier", node.specifier),
			makeGroup("Declarators", node.declarator)
		)
	}
	
	private def dispatch VisualNode genNode(StructDeclarationSpecifier node) {
		return makeNode(node, "Struct Declaration Specifier",
			makeChild("Type", node.type),
			makePortGroup("Qualifiers", node.qualifiers.map[qualifier | makeImmediateLiteral(qualifier.toString)])
		)
	}
	
	private def dispatch VisualNode genNode(InitDeclarator node) {
		return makeNode(node, "Init Declarator",
			makeChild("Declarator", node.declarator),
			makeChild("Initializer", node.initializer)
		)
	}
	
	private def dispatch VisualNode genNode(Declarator node) {
		return makeNode(node, node.isAlias ? "Declarator (alias)" : "Declarator",
			makeDeclaration("Name", node.name, node),
			makeGroup("Dimensions", node.dimensions),
			makeGroup("Attributes", node.attributes)
		);
	}
	
	private def dispatch VisualNode genNode(ExpressionInitializer node) {
		return visit(node.expr);
	}
	
	private def dispatch VisualNode genNode(ListInitializer node) {
		return makeNode(node, "List Initializer",
			makeGroup("", node.initializers)
		);
	}
	
	private def dispatch VisualNode genNode(DesignatedInitializer node) {
		return makeNode(node, "Designated Initializer",
			makeGroup("Designators", node.designators),
			makeChild("Initializer", node.initializer)
		);
	}
	
	private def dispatch VisualNode genNode(Designator node) {
		return makeNode(node, "Designator",
			makeChild("Index", node.idx),
			makeNamedLiteral("Property", node.prop)
		);
	}
	
	// expressions
	
	private def dispatch VisualNode genNode(IntegerConstant node) {
		return makeImmediateLiteral(node.value.toString)
	}
	
	private def dispatch VisualNode genNode(FloatConstant node) {
		return makeImmediateLiteral(node.value.toString)
	}
	
	private def dispatch VisualNode genNode(BoolConstant node) {
		return makeImmediateLiteral(node.value.toString)
	}
	
	private def dispatch VisualNode genNode(CharacterConstant node) {
		return makeImmediateLiteral(node.value)
	}
	
	private def dispatch VisualNode genNode(StringConstant node) {
		if(node.literals.size == 1) {
			return visit(node.literals.get(0));
		}
		
		return makeNode(node, "Compound String Constant",
			makeGroup("Literals", node.literals)
		);
	}
	
	private def dispatch VisualNode genNode(StringLiteral node) {
		return makeImmediateLiteral(node.value)
	}
	
	private def dispatch VisualNode genNode(InfixExpression node) {
		return makeNode(node, "Infix Expression (" + node.op + ")",
			makeChild("Left", node.left),
			makeChild("Right", node.right)
		);
	}
	
	private def dispatch VisualNode genNode(PrefixExpression node) {
		return makeNode(node, "Prefix Expression (" + node.op + ")",
			makeChild("Operand", node.left)
		);
	}
	
	private def dispatch VisualNode genNode(PostfixExpression node) {
		return makeNode(node, "Postfix Expression",
			makeChild("Operand", node.left),
			makeNamedLiteral("Operator", node.op)
		);
	}
	
	private def dispatch VisualNode genNode(FunctionCallExpression node) {
		return makeNode(node, "Function Call",
			makeChild("Target", node.left),
			makeGroup("Arguments", node.arguments)
		);
	}
	
	private def dispatch VisualNode genNode(ArrayAccessExpression node) {
		return makeNode(node, "Array Access",
			makeChild("Target", node.left),
			makeChild("Index", node.index)
		);
	}
	
	private def dispatch VisualNode genNode(MemberAccessExpression node) {
		return makeNode(node, "Member Access (" + node.op + ")",
			makeChild("Target", node.left),
			makeReference("Member", node.declarator?.name, [node.declarator])
		);
	}
	
	private def dispatch VisualNode genNode(ParenthesisExpression node) {
		return makeNode(node, "Parenthesis Expression",
			makeChild("Inner", node.inner)
		);
	}
	
	private def dispatch VisualNode genNode(EntityReference node) {
		if(node.target instanceof FunctionDefinition)
			return makeNode(node, "Function Reference", makeReference("Function", (node.target as FunctionDefinition).name, [node.target]));
			
		if(node.target instanceof Declarator)
			return makeNode(node, "Declarator Reference", makeReference("Declarator", (node.target as Declarator).name, [node.target]));
			
		if(node.target instanceof BitField)
			return makeNode(node, "Field Reference", makeReference("Field", (node.target as BitField).name, [node.target]));
	}
	
	private def dispatch VisualNode genNode(Expression node) {
		if(node.expressions.size != 1)
			throw new RuntimeException("Expected exactly one expression");
		return visit(node.expressions.get(0));
	}
	
	private def dispatch VisualNode genNode(AssignmentExpression node) {
		return makeNode(node, "Assignment Expression", node.assignments);
	}
	
	private def dispatch VisualNode genNode(Assignment node) {
		return makeNode(node, "Assignment (" + node.type + ")",
			makeChild("Value", node.right)
		);
	}
}
