package org.example;

import org.example.configuration.Configuration;
import org.example.configuration.ConfigurationImpl;
import org.example.display.Terminal;
import org.example.display.TerminalImpl;
import org.example.generator.PasswordGenerator;
import org.example.generator.PasswordGeneratorImpl;
import org.example.generator.RandomCharacterGenerator;
import org.example.generator.RandomCharacterGeneratorImpl;
import org.example.processor.ArgumentProcessor;
import org.example.processor.ArgumentProcessorImpl;
import org.example.shuffler.StringShuffler;
import org.example.shuffler.StringShufflerImpl;

/**
 * Main application class
 */
public class AppImpl implements App {
    private final ArgumentProcessor argumentProcessor;

    public AppImpl(ArgumentProcessor argumentProcessor) {
        this.argumentProcessor = argumentProcessor;
    }

    public static void main(String[] args) {
        Configuration configuration = new ConfigurationImpl();
        StringShuffler stringShuffler = new StringShufflerImpl();
        RandomCharacterGenerator randomCharacterGenerator = new RandomCharacterGeneratorImpl();
        PasswordGenerator passwordGenerator = new PasswordGeneratorImpl(randomCharacterGenerator, stringShuffler, configuration);
        Terminal terminal = new TerminalImpl();
        ArgumentProcessor argumentProcessor = new ArgumentProcessorImpl(configuration, passwordGenerator, terminal);
        App app = new AppImpl(argumentProcessor);
        app.start(args);
    }

    @Override
    public void start(String[] args) {
        argumentProcessor.process(args);
    }
}
