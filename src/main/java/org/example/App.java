package org.example;

import org.example.service.*;

/**
 * Main application class
 */
public class App {
    private ArgumentProcessor argumentProcessor;

    public static void main(String[] args) {
        var app = new App(new ArgumentProcessorImpl(new ArgumentValidatorImpl(), new PasswordGeneratorImpl(), new TerminalImpl()));
        app.start(args);
    }

    private App(ArgumentProcessor argumentProcessor) {
        this.argumentProcessor = argumentProcessor;
    }

    private void start(String[] args) {
        argumentProcessor.process(args);
    }
}
