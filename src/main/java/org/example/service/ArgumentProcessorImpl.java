package org.example.service;

import javax.inject.Inject;

public class ArgumentProcessorImpl implements ArgumentProcessor {
    private ArgumentValidator argumentValidator;
    private PasswordGenerator passwordGenerator;
    private Terminal terminal;

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
                    "java -jar ./demo-java-cli.jar generate password";
            terminal.show(usage);
            return;
        }

        String password = passwordGenerator.generate();
        terminal.show(password);
    }
}
