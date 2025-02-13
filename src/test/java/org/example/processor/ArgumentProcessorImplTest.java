package org.example.processor;

import org.example.display.Terminal;
import org.example.generator.PasswordGenerator;
import org.example.validator.ArgumentValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArgumentProcessorImplTest {
    @Mock
    private ArgumentValidator argumentValidator;

    @Mock
    private PasswordGenerator passwordGenerator;

    @Mock
    private Terminal terminal;

    @InjectMocks
    private ArgumentProcessorImpl argumentProcessor;

    @Test
    void checkProcessMethodForGeneratePassword() {
        String[] args = new String[]{"generate", "password"};
        when(argumentValidator.validate(args)).thenReturn(true);

        String sample = "A8!(,wV5YuI[Vr^>";
        when(passwordGenerator.generate()).thenReturn(sample);

        argumentProcessor.process(args);

        verify(passwordGenerator, times(1)).generate();
        verify(terminal, times(1)).show(sample);
    }

    @Test
    void checkProcessMethodForInvalidArguments() {
        String usage = "Usage:" + System.lineSeparator() +
                "java -jar ./demo-java-cli-[VERSION].jar generate password";

        String[] args = new String[]{};
        when(argumentValidator.validate(args)).thenReturn(false);

        argumentProcessor.process(args);

        verify(terminal, times(1)).show(usage);
    }
}
