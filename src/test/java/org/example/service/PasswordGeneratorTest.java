package org.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class PasswordGeneratorTest {
    @InjectMocks
    private PasswordGeneratorImpl passwordGenerator;

    @Test
    public void shouldHave16Characters() {
        String generatedPassword = passwordGenerator.generate();

        assertEquals(16, generatedPassword.length());
    }

    @Test
    public void shouldContainLowercaseCharacter() {
        String generatedPassword = passwordGenerator.generate();

        Pattern inputRegex = Pattern.compile(".*[a-z].*");
        boolean inputMatches = inputRegex.matcher(generatedPassword).matches();

        if (!inputMatches) {
            fail();
        }
    }

    @Test
    public void shouldContainUppercaseCharacter() {
        String generatedPassword = passwordGenerator.generate();

        Pattern inputRegex = Pattern.compile(".*[A-Z].*");
        boolean inputMatches = inputRegex.matcher(generatedPassword).matches();

        if (!inputMatches) {
            fail();
        }
    }

    @Test
    public void shouldContainDigitCharacter() {
        String generatedPassword = passwordGenerator.generate();

        Pattern inputRegex = Pattern.compile(".*\\d.*");
        boolean inputMatches = inputRegex.matcher(generatedPassword).matches();

        if (!inputMatches) {
            fail();
        }
    }

    @Test
    public void shouldContainSpecialCharacter() {
        String generatedPassword = passwordGenerator.generate();

        Pattern inputRegex = Pattern.compile(".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*");
        boolean inputMatches = inputRegex.matcher(generatedPassword).matches();

        if (!inputMatches) {
            fail();
        }
    }
}
