package com.minres.coredsl.services.visualization;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EObject;

/**
 * - VisualElement<br>
 * . - VisualNode<br>
 * . . - SimpleNode (contains VisualNode output)<br>
 * . . - PortNode (contains List&lt;NodeElement&gt; children)<br>
 * . - Literal (leaf node)<br>
 * . . - DeclarationLiteral (potential target of a back edge)<br>
 * . . - ReferenceLiteral (source of a back edge)<br>
 * . - NodeElement<br>
 * . . - Port (contains VisualNode output)<br>
 * . . - PortGroup (contains List&lt;NodeElement&gt; children)<br>
 */
public abstract class VisualElement {
    public final String label;

    protected VisualElement(String label) {
        this.label = label;
    }

    /**
     * A visual node (derived by {@link SimpleNode}, {@link PortNode} and
     * {@link Literal})
     **/
    public static abstract class VisualNode extends VisualElement {
        protected VisualNode(String label) {
            super(label);
        }

        public abstract VisualNodeType type();
    }

    /** A simple node with at most one output **/
    public static final class SimpleNode extends VisualNode {
        public final VisualNode output;

        public SimpleNode(String label, VisualNode output) {
            super(label);
            this.output = output;
        }

        @Override
        public VisualNodeType type() {
            return VisualNodeType.simple;
        }
    }

    /** A node with multiple labeled outputs **/
    public static final class PortNode extends VisualNode {
        public final List<NodeElement> children;

        public PortNode(String label) {
            this(label, new ArrayList<>());
        }

        public PortNode(String label, List<NodeElement> children) {
            super(label);
            this.children = children;
        }

        @Override
        public VisualNodeType type() {
            return VisualNodeType.port;
        }
    }

    /**
     * An element that may be part of a {@link PortNode} (derived by {@link Port}
     * and {@link PortGroup})
     **/
    public static abstract class NodeElement extends VisualElement {
        protected NodeElement(String label) {
            super(label);
        }
    }

    /** Exit port of a {@link PortNode} **/
    public static final class Port extends NodeElement {
        public final VisualNode output;

        public Port(String label, VisualNode output) {
            super(label);
            this.output = output;
        }
    }

    /**
     * A group of {@link NodeElement}s, used to group multiple ports within a
     * {@link PortNode}
     **/
    public static final class PortGroup extends NodeElement {
        public final List<NodeElement> children;

        public PortGroup(String label, List<NodeElement> children) {
            super(label);
            this.children = children;
        }
    }

    /** A literal (leaf) node with no outgoing edges **/
    public static class Literal extends VisualNode {
        public Literal(String label) {
            super(label);
        }

        @Override
        public VisualNodeType type() {
            return VisualNodeType.literal;
        }
    }

    /** A literal node that can be referred to by a {@link ReferenceLiteral} **/
    public static final class DeclarationLiteral extends Literal {
        public DeclarationLiteral(String label) {
            super(label);
        }

        @Override
        public VisualNodeType type() {
            return VisualNodeType.declaration;
        }
    }

    /**
     * A literal node with a reference to a {@link DeclarationLiteral} (used in
     * decorated ASTs)
     **/
    public static final class ReferenceLiteral extends Literal {
        public final Supplier<EObject> resolver;
        public DeclarationLiteral declaration;

        public ReferenceLiteral(String label, Supplier<EObject> resolver) {
            super(label);
            this.resolver = resolver;
        }

        @Override
        public VisualNodeType type() {
            return VisualNodeType.reference;
        }
    }

    /**
     * Enumeration of different node types, so I can use a switch instead of chained
     * if instanceof checks
     **/
    public enum VisualNodeType {
        simple, port, literal, declaration, reference
    }
}
