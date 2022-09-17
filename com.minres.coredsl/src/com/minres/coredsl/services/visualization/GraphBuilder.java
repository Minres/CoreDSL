package com.minres.coredsl.services.visualization;

import java.io.PrintWriter;

public interface GraphBuilder {
    /**
     * Exports a {@link VisualGraph}.
     *
     * @param graph    The {@link VisualGraph} to be exported
     * @param out      A {@link PrintWriter} to write the output to
     * @param decorate Whether to print references (requires the graph to be
     *                 generated with decorate = true as well)
     */
    void buildGraph(VisualGraph graph, PrintWriter out, boolean decorate);
}
