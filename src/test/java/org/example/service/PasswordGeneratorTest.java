package org.example.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PasswordGeneratorTest {
    private PasswordGenerator testSubject = new PasswordGeneratorImpl();
    private String generatedPassword;

    @Before
    public void before() {
        generatedPassword = testSubject.generatePassword();
    }

    @After
    public void after() {
        generatedPassword = null;
    }

    @Test
    public void shouldHave16Characters() {
        assertEquals(16, generatedPassword.length());
    }

    @Test
    public void shouldContainLowercaseCharacter() {
        Pattern inputRegex = Pattern.compile(".*[a-z].*");
        boolean inputMatches = inputRegex.matcher(generatedPassword).matches();

        if (!inputMatches) {
            fail();
        }
    }

    @Test
    public void shouldContainUppercaseCharacter() {
        Pattern inputRegex = Pattern.compile(".*[A-Z].*");
        boolean inputMatches = inputRegex.matcher(generatedPassword).matches();

        if (!inputMatches) {
            fail();
        }
    }

    @Test
    public void shouldContainDigitCharacter() {
        Pattern inputRegex = Pattern.compile(".*\\d.*");
        boolean inputMatches = inputRegex.matcher(generatedPassword).matches();

        if (!inputMatches) {
            fail();
        }
    }

    @Test
    public void shouldContainSpecialCharacter() {
        Pattern inputRegex = Pattern.compile(".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*");
        boolean inputMatches = inputRegex.matcher(generatedPassword).matches();

        if (!inputMatches) {
            fail();
        }
    }
}
