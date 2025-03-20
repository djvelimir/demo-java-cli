package org.example.processor;

import org.example.configuration.Configuration;
import org.example.configuration.Parameter;
import org.example.display.Terminal;
import org.example.generator.PasswordGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Properties;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArgumentProcessorImplTest {
    @Mock
    Configuration configuration;

    @Mock
    private PasswordGenerator passwordGenerator;

    @Mock
    private Terminal terminal;

    @InjectMocks
    private ArgumentProcessorImpl argumentProcessor;

    @Test
    void checkProcessMethodForGeneratePassword() {
        String[] args = new String[]{String.format("--%s", Parameter.PASSWORD_LENGTH_PARAMETER_NAME), "16"};
        when(configuration.validate()).thenReturn(true);

        String sample = "A8!(,wV5YuI[Vr^>";
        when(passwordGenerator.generate()).thenReturn(sample);

        argumentProcessor.process(args);

        verify(configuration, times(1)).load(args);
        verify(passwordGenerator, times(1)).generate();
        verify(terminal, times(1)).show(sample);
    }

    @Test
    void checkProcessMethodForInvalidArguments() {
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

        String[] args = new String[]{String.format("--%s", Parameter.PASSWORD_LENGTH_PARAMETER_NAME), "1c6"};
        when(configuration.validate()).thenReturn(false);

        argumentProcessor.process(args);

        verify(configuration, times(1)).load(args);
        verify(terminal, times(1)).show(usage);
    }
}
