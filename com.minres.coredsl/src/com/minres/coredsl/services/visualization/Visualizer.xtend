package com.minres.coredsl.services.visualization

import com.minres.coredsl.coreDsl.AbstractDeclarator
import com.minres.coredsl.coreDsl.Assignment
import com.minres.coredsl.coreDsl.AssignmentExpression
import com.minres.coredsl.coreDsl.Attribute
import com.minres.coredsl.coreDsl.BitField
import com.minres.coredsl.coreDsl.BitSizeSpecifier
import com.minres.coredsl.coreDsl.BitValue
import com.minres.coredsl.coreDsl.BlockItem
import com.minres.coredsl.coreDsl.BoolConstant
import com.minres.coredsl.coreDsl.CastExpression
import com.minres.coredsl.coreDsl.CharacterConstant
import com.minres.coredsl.coreDsl.CompositeType
import com.minres.coredsl.coreDsl.CompoundStatement
import com.minres.coredsl.coreDsl.ConditionalExpression
import com.minres.coredsl.coreDsl.Constant
import com.minres.coredsl.coreDsl.CoreDef
import com.minres.coredsl.coreDsl.Declaration
import com.minres.coredsl.coreDsl.DeclarationSpecifier
import com.minres.coredsl.coreDsl.DescriptionContent
import com.minres.coredsl.coreDsl.DesignatedInitializer
import com.minres.coredsl.coreDsl.Designator
import com.minres.coredsl.coreDsl.DirectAbstractDeclarator
import com.minres.coredsl.coreDsl.Encoding
import com.minres.coredsl.coreDsl.EnumType
import com.minres.coredsl.coreDsl.Enumerator
import com.minres.coredsl.coreDsl.EnumeratorList
import com.minres.coredsl.coreDsl.Expression
import com.minres.coredsl.coreDsl.ExpressionStatement
import com.minres.coredsl.coreDsl.Field
import com.minres.coredsl.coreDsl.FloatingConstant
import com.minres.coredsl.coreDsl.ForCondition
import com.minres.coredsl.coreDsl.FunctionDefinition
import com.minres.coredsl.coreDsl.ISA
import com.minres.coredsl.coreDsl.IfStatement
import com.minres.coredsl.coreDsl.Import
import com.minres.coredsl.coreDsl.InfixExpression
import com.minres.coredsl.coreDsl.InitDeclarator
import com.minres.coredsl.coreDsl.Initializer
import com.minres.coredsl.coreDsl.InitializerList
import com.minres.coredsl.coreDsl.Instruction
import com.minres.coredsl.coreDsl.InstructionSet
import com.minres.coredsl.coreDsl.IntegerConstant
import com.minres.coredsl.coreDsl.IterationStatement
import com.minres.coredsl.coreDsl.JumpStatement
import com.minres.coredsl.coreDsl.LabeledStatement
import com.minres.coredsl.coreDsl.ParameterDeclaration
import com.minres.coredsl.coreDsl.ParameterList
import com.minres.coredsl.coreDsl.Postfix
import com.minres.coredsl.coreDsl.PostfixExpression
import com.minres.coredsl.coreDsl.PrefixExpression
import com.minres.coredsl.coreDsl.PrimaryExpression
import com.minres.coredsl.coreDsl.PrimitiveType
import com.minres.coredsl.coreDsl.SelectionStatement
import com.minres.coredsl.coreDsl.SpawnStatement
import com.minres.coredsl.coreDsl.Statement
import com.minres.coredsl.coreDsl.StringLiteral
import com.minres.coredsl.coreDsl.StructDeclaration
import com.minres.coredsl.coreDsl.StructDeclarationSpecifier
import com.minres.coredsl.coreDsl.SwitchStatement
import com.minres.coredsl.coreDsl.TypeSpecifier
import com.minres.coredsl.coreDsl.UnaryOperator
import com.minres.coredsl.coreDsl.Variable
import com.minres.coredsl.services.visualization.VisualElement.DeclarationLiteral
import com.minres.coredsl.services.visualization.VisualElement.Literal
import com.minres.coredsl.services.visualization.VisualElement.NodeElement
import com.minres.coredsl.services.visualization.VisualElement.Port
import com.minres.coredsl.services.visualization.VisualElement.PortGroup
import com.minres.coredsl.services.visualization.VisualElement.PortNode
import com.minres.coredsl.services.visualization.VisualElement.ReferenceLiteral
import com.minres.coredsl.services.visualization.VisualElement.SimpleNode
import com.minres.coredsl.services.visualization.VisualElement.VisualNode
import java.util.ArrayList
import java.util.Arrays
import java.util.List
import java.util.Map
import java.util.function.Supplier
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import java.util.IdentityHashMap

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
		System.out.println();
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
		var VisualNode node = new PortNode(label, new ArrayList(Arrays.asList(children)));
		registerNode(node, astNode);
		return node;
	}
	
	private def VisualNode makeNode(EObject astNode, String label, List<? extends EObject> children) {
		var List<NodeElement> elements = new ArrayList(children.size());
		for(var int i = 0; i < children.size(); i++) {
			elements.add(makeChild(Integer.toString(i + 1), children.get(i)));
		}
		var VisualNode node = new PortNode(label, elements);
		registerNode(node, astNode);
		return node;
	}
	
	private def VisualNode makeImmediateLiteral(String content) {
		var Literal literal = new Literal(content);
		registerNode(literal, null);
		return literal;
	}
	
	private def NodeElement makeNamedLiteral(String label, String content) {
		var Literal literal = new Literal(content);
		registerNode(literal, null);
		return new Port(label, literal);
	}
	
	private def NodeElement makeDeclaration(String label, String content, EObject owner) {
		var DeclarationLiteral literal = new DeclarationLiteral(content);
		registerNode(literal, null);
		declarationLiterals.put(owner, literal);
		return new Port(label, literal);
	}
	
	private def NodeElement makeReference(String label, String content, Supplier<EObject> referenceResolver) {
		var ReferenceLiteral literal = new ReferenceLiteral(content, referenceResolver);
		registerNode(literal, null);
		return new Port(label, literal);
	}
	
	private def NodeElement makeChild(String label, EObject node) {
		if(node !== null)
			return new Port(label, visit(node));
		return new Port(label, makeImmediateLiteral("<null>"));
	}
	
	private def NodeElement makeGroup(String label, List<? extends EObject> children) {
		var List<NodeElement> elements = new ArrayList(children.size());
		for(var int i = 0; i < children.size(); i++) {
			elements.add(makeChild(Integer.toString(i + 1), children.get(i)));
		}
		return new PortGroup(label, elements);
	}
	
	/* *****************
	 * Visitor methods *
	 ***************** */
	
	private def dispatch VisualNode genNode(EObject node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(AbstractDeclarator node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Assignment node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(AssignmentExpression node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Attribute node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(BitField node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(BitSizeSpecifier node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(BitValue node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(BlockItem node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(BoolConstant node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(CastExpression node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(CharacterConstant node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(CompositeType node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(CompoundStatement node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(ConditionalExpression node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Constant node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(CoreDef node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Declaration node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(DeclarationSpecifier node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(DescriptionContent node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(DesignatedInitializer node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Designator node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(DirectAbstractDeclarator node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Encoding node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Enumerator node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(EnumeratorList node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(EnumType node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Expression node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(ExpressionStatement node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Field node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(FloatingConstant node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(ForCondition node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(FunctionDefinition node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(IfStatement node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Import node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(InfixExpression node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(InitDeclarator node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Initializer node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(InitializerList node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Instruction node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(InstructionSet node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(IntegerConstant node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(ISA node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(IterationStatement node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(JumpStatement node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(LabeledStatement node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(ParameterDeclaration node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(ParameterList node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Postfix node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(PostfixExpression node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(PrefixExpression node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(PrimaryExpression node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(PrimitiveType node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(SelectionStatement node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(SpawnStatement node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Statement node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(StringLiteral node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(StructDeclaration node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(StructDeclarationSpecifier node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(SwitchStatement node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(TypeSpecifier node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(UnaryOperator node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
	
	private def dispatch VisualNode genNode(Variable node) {
		throw new RuntimeException("generator for type " + node.getClass().getSimpleName() + " not implemented");
	}
}
