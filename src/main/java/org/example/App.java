package org.example;

import org.example.service.*;

/**
 * Main application class
 */
public class App {
    private ArgumentProcessor argumentProcessor;
    private Display display;

    public static void main(String[] args) {
        var app = new App(new ArgumentProcessorImpl(new PasswordGeneratorImpl(), new DisplayImpl()), new DisplayImpl());
        app.start(args);
    }

    private App(ArgumentProcessor argumentProcessor, Display display) {
        this.argumentProcessor = argumentProcessor;
        this.display = display;
    }

    private void start(String[] args) {
        if (!argumentProcessor.validate(args)) {
            display.showUsage();
            return;
        }

        argumentProcessor.process(args);
    }
}
