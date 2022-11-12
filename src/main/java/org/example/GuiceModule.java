package org.example;

import com.google.inject.AbstractModule;
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
import org.example.validator.ArgumentValidator;
import org.example.validator.ArgumentValidatorImpl;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ArgumentProcessor.class).to(ArgumentProcessorImpl.class);
        bind(ArgumentValidator.class).to(ArgumentValidatorImpl.class);
        bind(PasswordGenerator.class).to(PasswordGeneratorImpl.class);
        bind(RandomCharacterGenerator.class).to(RandomCharacterGeneratorImpl.class);
        bind(StringShuffler.class).to(StringShufflerImpl.class);
        bind(Terminal.class).to(TerminalImpl.class);
        bind(App.class).to(AppImpl.class);
    }
}
