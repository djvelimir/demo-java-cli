package org.example;

import com.google.inject.AbstractModule;
import org.example.service.*;

public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ArgumentProcessor.class).to(ArgumentProcessorImpl.class);
        bind(ArgumentValidator.class).to(ArgumentValidatorImpl.class);
        bind(PasswordGenerator.class).to(PasswordGeneratorImpl.class);
        bind(Terminal.class).to(TerminalImpl.class);
        bind(App.class).to(AppImpl.class);
    }
}
