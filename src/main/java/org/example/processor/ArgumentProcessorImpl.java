package org.example.processor;

import com.google.inject.Inject;
import org.example.display.Terminal;
import org.example.generator.PasswordGenerator;
import org.example.validator.ArgumentValidator;


public class ArgumentProcessorImpl implements ArgumentProcessor {
    private final ArgumentValidator argumentValidator;
    private final PasswordGenerator passwordGenerator;
    private final Terminal terminal;

    @Inject
    public ArgumentProcessorImpl(ArgumentValidator argumentValidator, PasswordGenerator passwordGenerator, Terminal terminal) {
        this.argumentValidator = argumentValidator;
        this.passwordGenerator = passwordGenerator;
        this.terminal = terminal;
    }

    @Override
    public void process(String[] args) {
        if (!argumentValidator.validate(args)) {
            String usage = "Usage:" + System.lineSeparator() +
                    "java -jar ./demo-java-cli-[VERSION].jar generate password";
            terminal.show(usage);
            return;
        }

        String password = passwordGenerator.generate();
        terminal.show(password);
    }
}
