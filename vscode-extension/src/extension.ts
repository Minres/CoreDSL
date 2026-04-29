'use strict';

import * as net from 'net';

import { workspace, ExtensionContext } from 'vscode';
import { LanguageClient, LanguageClientOptions, StreamInfo, Trace } from 'vscode-languageclient/node';

let languageClient: LanguageClient | undefined;

export function activate(context: ExtensionContext) {
    // The server is a started as a separate app and listens on port 5007
    const connectionInfo = {
        port: 5007
    };
    const serverOptions = () => {
        // Connect to language server via socket
        const socket = net.connect(connectionInfo);
        const result: StreamInfo = {
            writer: socket,
            reader: socket
        };
        return Promise.resolve(result);
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
