package org.example.processor;

import com.google.inject.Inject;
import org.example.configuration.Configuration;
import org.example.display.Terminal;
import org.example.generator.PasswordGenerator;

import java.io.IOException;
import java.util.Properties;


public class ArgumentProcessorImpl implements ArgumentProcessor {
    private final Configuration configuration;
    private final PasswordGenerator passwordGenerator;
    private final Terminal terminal;

    @Inject
    public ArgumentProcessorImpl(Configuration configuration, PasswordGenerator passwordGenerator, Terminal terminal) {
        this.configuration = configuration;
        this.passwordGenerator = passwordGenerator;
        this.terminal = terminal;
    }

    @Override
    public void process(String[] args) {
        configuration.load(args);

        if (!configuration.validate()) {
            final Properties properties = new Properties();
            try {
                properties.load(this.getClass().getClassLoader().getResourceAsStream("project.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String usage = "Usage:" + System.lineSeparator() +
                    "java -jar ./" + properties.getProperty("artifactId") + "-" + properties.getProperty("version") + ".jar [OPTIONS]" + System.lineSeparator() +
                    System.lineSeparator() +
                    "Options:" + System.lineSeparator() +
                    "--password-length\tLength of the password, allowing values between 8 and 128 characters.";
            terminal.show(usage);
            return;
        }

        String password = passwordGenerator.generate();
        terminal.show(password);
    }
}
