package org.example.display;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TerminalImplTest {

    @InjectMocks
    private TerminalImpl terminal;

    @Test
    void checkShowMethod() {
        String message = "Test Message";
        String expected = message + System.lineSeparator();

        final PrintStream standardOut = System.out;
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputStreamCaptor));
        terminal.show(message);
        System.setOut(standardOut);

        assertEquals(expected, outputStreamCaptor.toString());
    }
}
