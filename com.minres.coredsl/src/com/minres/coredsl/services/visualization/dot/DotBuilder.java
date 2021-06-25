package com.minres.coredsl.services.visualization.dot;

import com.minres.coredsl.services.visualization.GraphBuilder;
import com.minres.coredsl.services.visualization.VisualElement.*;
import com.minres.coredsl.services.visualization.VisualGraph;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DotBuilder implements GraphBuilder {
	
	private static final String dotPrologue = "digraph {\n" +
			"node [shape=Mrecord, style=filled, fillcolor=white, fontname=\"Calibri\"];\n" +
			"graph [ordering=out, nodesep=0.3, ranksep=1];\n\n";
	private static final String dotEpilogue = "}\n";
	
	/** {0} -> node name, {1} -> label **/
	private static final String simpleNodeFormat = "%s [label=\"%s\", tooltip=\"%s\"]\n";
	
	/** {0} -> node name, {1} -> label, {2} -> port list **/
	private static final String portNodeFormat = "%s [label=\"{%s|{%s}}\", tooltip=\"%s\"]\n";
	
	/** {0} -> node name, {1} -> label, {2} -> fill color **/
	private static final String literalNodeFormat = "%s [shape=box, label=\"%s\", fillcolor=\"%s\", tooltip=\"%s\"]\n";
	
	/** {0} -> source node, {1} -> target **/
	private static final String simpleEdgeFormat = "%s:s -> %s:n";
	
	/** {0} -> source node, {1} -> source port, {2} -> target **/
	private static final String portEdgeFormat = "%s:%s:s -> %s:n";
	
	/** {0} -> source, {1} -> target **/
	private static final String backEdgeFormat = "%s -> %s [style=dashed, constraint=false, color=\"%s\"]";
	
	@Override public void buildGraph(VisualGraph graph, PrintWriter out, boolean decorate) {
		Map<VisualNode, String> nodeNames = new HashMap<>();
		Map<Literal, ColorPair> nodeColors = new HashMap<>();
		
		for(VisualNode node : graph.visualNodes) {
			nodeNames.put(node, "node" + nodeNames.size());
		}
		
		out.print(dotPrologue);
		for(VisualNode node : graph.visualNodes) {
			buildNode(node, out, decorate, nodeNames, nodeColors);
		}
		out.print(dotEpilogue);
		out.flush();
	}
	
	private void buildNode(VisualNode node, PrintWriter out, boolean decorate, Map<VisualNode, String> nodeNames, Map<Literal, ColorPair> nodeColors) {
		out.println("# " + node.getClass().getSimpleName() + " " + node.label);
		String name = nodeNames.get(node);
		String label = node.label
				.replace("\"", "\\\"")
				.replace("<", "&lt;")
				.replace(">", "&gt;");
		
		// generate edges and port list
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		
		switch(node.type()) {
			case simple:
				VisualNode output = ((SimpleNode) node).output;
				if(output != null) {
					// add regular edge if the node's output is not null
					String targetName = nodeNames.get(output);
					out.println(String.format(simpleEdgeFormat, name, targetName));
				}
				out.println(String.format(simpleNodeFormat, name, label, label));
				break;
			
			case port:
				List<NodeElement> elements = ((PortNode) node).children;
				for(int i = 0; i < elements.size(); i++) {
					NodeElement child = elements.get(i);
					if(!first) sb.append('|');
					sb.append(buildNodeElement(child, name, "p" + i, out, nodeNames));
					first = false;
				}
				out.println(String.format(portNodeFormat, name, label, sb.toString(), label));
				break;
			
			case reference:
				if(decorate) {
					ReferenceLiteral reference = (ReferenceLiteral) node;
					DeclarationLiteral declaration = reference.declaration;
					// declaration might be null (e.g. for runtime functions)
					if(declaration != null) {
						ColorPair color = nodeColors.get(declaration);
						if(color == null) {
							color = getColor();
							nodeColors.put(declaration, color);
						}
						// add back edge
						String target = nodeNames.get(declaration);
						out.println(String.format(backEdgeFormat, name, target, color.strokeColor));
						out.println(String.format(literalNodeFormat, name, label, color.fillColor, label));
						break;
					}
				}
				out.println(String.format(literalNodeFormat, name, label, "#cccccc", label));
				break;
			
			case declaration:
				if(decorate) {
					DeclarationLiteral declaration = (DeclarationLiteral) node;
					ColorPair color = nodeColors.get(declaration);
					if(color == null) {
						color = getColor();
						nodeColors.put(declaration, color);
					}
					out.println(String.format(literalNodeFormat, name, label, color.fillColor, label));
					break;
				}
				out.println(String.format(literalNodeFormat, name, label, "#cccccc", label));
				break;
			
			case literal:
				out.println(String.format(literalNodeFormat, name, label, "#cccccc", label));
				break;
		}
	}
	
	private String buildNodeElement(NodeElement element, String node, String port, PrintWriter out, Map<VisualNode, String> nodeNames) {
		if(element instanceof Port) {
			VisualNode child = ((Port) element).output;
			assert child != null;
			
			// get name of the target node
			String targetName = nodeNames.get(child);
			assert targetName != null;
			
			// add regular edge
			out.println(String.format(portEdgeFormat, node, port, targetName));
			return "<" + port + ">" + element.label;
		}
		
		if(element instanceof PortGroup) {
			int id = 0;
			StringBuilder sb = new StringBuilder("{").append(element.label).append("|{");
			for(NodeElement child : ((PortGroup) element).children) {
				assert child instanceof Port || child instanceof PortGroup;
				if(id > 0) sb.append('|');
				String subPort = port + "_" + id++;
				sb.append(buildNodeElement(child, node, subPort, out, nodeNames));
			}
			return sb.append("}}").toString();
		}
		
		assert false;
		return null;
	}
	
	// colorStep and colors.size() must be coprime (no common factors)!
	// otherwise not all colors will be used.
	private static final int colorStep = 5;
	private static final List<ColorPair> colors = Arrays.asList(
			new ColorPair("#FFC6C6", "#FF0000"),
			new ColorPair("#FFE0C6", "#FF7400"),
			new ColorPair("#FFECC6", "#FFAA00"),
			new ColorPair("#FFF5C6", "#C5A300"),
			new ColorPair("#FFFFC6", "#C5C500"),
			new ColorPair("#EAFDC5", "#7BB800"),
			new ColorPair("#C2FAC2", "#00CC00"),
			new ColorPair("#BEF5F5", "#009999"),
			new ColorPair("#C6D4F7", "#1240AB"),
			new ColorPair("#D2C6F7", "#3914AF"),
			new ColorPair("#E4C3F7", "#7109AA"),
			new ColorPair("#FAC2E2", "#CD0074"));
	
	private int colorCount;
	
	private ColorPair getColor() {
		return colors.get(colorStep * colorCount++ % colors.size());
	}
	
	private static class ColorPair {
		public final String fillColor;
		public final String strokeColor;
		
		public ColorPair(String fillColor, String strokeColor) {
			this.fillColor = fillColor;
			this.strokeColor = strokeColor;
		}
	}
}
