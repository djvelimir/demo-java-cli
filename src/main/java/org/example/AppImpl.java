package org.example;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.example.processor.ArgumentProcessor;

/**
 * Main application class
 */
public class AppImpl implements App {
    private final ArgumentProcessor argumentProcessor;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GuiceModule());
        App app = injector.getInstance(App.class);

        app.start(args);
    }

    @Inject
    public AppImpl(ArgumentProcessor argumentProcessor) {
        this.argumentProcessor = argumentProcessor;
    }

    @Override
    public void start(String[] args) {
        argumentProcessor.process(args);
    }
}
