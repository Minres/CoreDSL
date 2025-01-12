package com.minres.coredsl.services.visualization;

import com.google.inject.Inject
import com.google.inject.Provider
import com.minres.coredsl.CoreDslStandaloneSetup
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import java.nio.file.Paths
import java.io.ByteArrayOutputStream
import java.io.PrintWriter
import com.minres.coredsl.services.visualization.dot.DotBuilder
import org.eclipse.xtext.diagnostics.Severity

class VisualizerMain {
    def static main(String[] args) {
        val injector = new CoreDslStandaloneSetup().createInjectorAndDoEMFRegistration
        val main = injector.getInstance(VisualizerMain)
        main.run(args)
    }

    @Inject Provider<ResourceSet> resourceSetProvider

    @Inject IResourceValidator validator

    @Inject JavaIoFileSystemAccess fileAccess

    def private static String changeExtension(String path, String ext) {
        val full = Paths.get(path)
        var name = full.fileName.toString()
        val pos = name.lastIndexOf(".")
        if (pos > 0) {
            name = name.substring(0, pos)
        }
        if (ext !== null && ext.length > 0) {
            val char period = '.'
            if (ext.charAt(0) == period) {
                name += ext
            } else {
                name += '.' + ext
            }
        }
        return full.resolveSibling(name).toString();
    }

    def protected run(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.err.println("Usage: visualizer in-path [out-path]")
            return;
        }

        val inPath = args.get(0)
        val outPath = Paths.get(args.length > 1 ? args.get(1) : changeExtension(inPath, ".dot"))

        val set = resourceSetProvider.get()
        val resource = set.getResource(URI.createFileURI(inPath), true)

        val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
        if (!issues.empty) {
            issues.forEach[System.err.println(it)]
            val errors = issues.filter[it.severity== Severity.ERROR].toList
            if(errors.size>0)
            	return
        }

        if (resource.contents.size != 1)
            throw new RuntimeException("Expected exactly one root node")

        val out = new ByteArrayOutputStream()
        val VisualGraph graph = new Visualizer().buildVisualGraph(resource.contents.get(0), true)
        new DotBuilder().buildGraph(graph, new PrintWriter(out), true)
        val dotCode = out.toString()

        fileAccess.outputPath = outPath.parent.toString()
        fileAccess.generateFile(outPath.fileName.toString(), dotCode);

        println("Done.")
    }
}
