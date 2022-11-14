package org.example.display;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TerminalImplTest {

    @InjectMocks
    private TerminalImpl terminal;

    @Test
    public void checkShowMethod() {
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
