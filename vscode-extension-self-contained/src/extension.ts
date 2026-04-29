'use strict';

import * as path from 'path';
import * as os from 'os';

import { workspace, ExtensionContext } from 'vscode';
import { LanguageClient, LanguageClientOptions, ServerOptions, Trace } from 'vscode-languageclient/node';

let languageClient: LanguageClient | undefined;

export function activate(context: ExtensionContext) {
    // The server is a locally installed in src/coredsl
    const launcher = os.platform() === 'win32' ? 'com.minres.coredsl.ide.bat' : 'com.minres.coredsl.ide';
    const script = context.asAbsolutePath(path.join('src', 'coredsl', 'bin', launcher));

    const serverOptions: ServerOptions = {
        run : { command: script },
        debug: { command: script, args: [], options: { env: createDebugEnv() } }
    };
    
    const clientOptions: LanguageClientOptions = {
        documentSelector: [{ language: 'coredsl' }],
        synchronize: {
            fileEvents: workspace.createFileSystemWatcher('**/*.*')
        }
    };
    // Create the language client and start the client.
    languageClient = new LanguageClient('coredslLanguageServer', 'CoreDSL Language Server', serverOptions, clientOptions);
    // enable tracing (.Off, .Messages, Verbose)
    void languageClient.setTrace(Trace.Verbose);
    void languageClient.start();
}
export function deactivate() {
    return languageClient?.stop();
}
function createDebugEnv() {
    return Object.assign({
        JAVA_OPTS:"-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n,quiet=y"
    }, process.env)
}
