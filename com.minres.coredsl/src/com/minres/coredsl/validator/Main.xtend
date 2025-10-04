package com.minres.coredsl.validator

import java.io.File
import java.util.concurrent.Callable
import org.apache.log4j.Logger
import picocli.CommandLine.Parameters
import picocli.CommandLine.Option
import picocli.CommandLine
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.generator.GeneratorDelegate
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.emf.mwe.utils.ProjectMapping
import org.eclipse.emf.mwe.utils.StandaloneSetup
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.parser.ParseException
import org.eclipse.xtext.generator.GeneratorContext
import org.eclipse.xtext.generator.IFileSystemAccess
import java.lang.reflect.MalformedParametersException
import org.apache.log4j.Level
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.Resource.Diagnostic
import com.minres.coredsl.CoreDslStandaloneSetup
import java.util.ArrayList

class Main implements Callable<Integer> {

    @Parameters(paramLabel="input_file", arity="1..*", description="one ore more files to process")
    public File[] files;

    @Option(names=#["-r", "--repository"], description="one ore more repository directories")
    public String[] repositories;

    @Option(names=#["-v", "--verbose"], description="verbose output")
    public Boolean verbose = false;

    def static main(String[] args) {
        val ret = new CommandLine(new Main()).execute(args);
        System.exit(ret)
    }

    override Integer call() throws Exception {
        Logger.rootLogger.level = verbose ? Level.DEBUG : Level.INFO
        val injector = new CoreDslValidatorSetup().createInjectorAndDoEMFRegistration
        injector.getInstance(ValidatorMain).run(this)
        return 0;
    }
}

class ValidatorMain {

    static val logger = Logger.getLogger(typeof(ValidatorMain));

    @Inject Provider<ResourceSet> resourceSetProvider

    @Inject IResourceValidator validator

    def run(Main params) {
        params.repositories.forEach[repository, idx|
            val projectMapping = new ProjectMapping
            projectMapping.projectName = "Repository:"+idx
            projectMapping.path = repository
            new StandaloneSetup().addProjectMapping(projectMapping)
        ]
        try {
            for (file : params.files) {
                // Load the resource
                val resourceSet = resourceSetProvider.get as XtextResourceSet
                resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
                val resource = resourceSet.getResource(URI.createFileURI(file.absolutePath), true)
                // Validate the resource
                val issues = new ArrayList<Issue>
                for (Diagnostic diag : resource.getErrors()) {
                    val issue = new Issue.IssueImpl();
                    issue.setSeverity(Severity.ERROR);
                    issue.setMessage(diag.getMessage());
                    issue.setLineNumber(diag.getLine());
                    issue.setUriToProblem(resource.getURI());
                    issues.add(issue);
                }
                if (issues.isEmpty())
                    issues += validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);

                if (!issues.empty) {
                    val errors = issues.filter[it.severity == Severity.ERROR]
                    val warnings = issues.filter[it.severity == Severity.WARNING]
                    if (!errors.empty) {
                        logger.error("Error validating " + resource.URI)
                        issues.forEach[logger.error(it)]
                        throw new ParseException("error validating " + resource.URI)
                    } else if (!warnings.empty) {
                        logger.warn("There are warnings validating " + resource.URI)
                        issues.forEach[logger.warn(it)]
                    }
                }
                logger.info('Code validation for ' + file + ' finished')
            }
        } catch (MalformedParametersException | IllegalArgumentException | ParseException e) {
            logger.error("Command line error " + e.message, e)
            return -1
        }
        return 0
    }
}
