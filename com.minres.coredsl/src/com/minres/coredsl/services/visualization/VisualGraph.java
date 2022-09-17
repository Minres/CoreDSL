package com.minres.coredsl.services.visualization;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public class VisualGraph {
    public final VisualElement.VisualNode rootNode;
    public final List<VisualElement.VisualNode> visualNodes;
    public final Map<EObject, VisualElement.VisualNode> astToVisual;

    public VisualGraph(VisualElement.VisualNode root, List<VisualElement.VisualNode> visualNodes,
            Map<EObject, VisualElement.VisualNode> astToVisual) {
        this.rootNode = root;
        this.visualNodes = visualNodes;
        this.astToVisual = astToVisual;
    }
}
