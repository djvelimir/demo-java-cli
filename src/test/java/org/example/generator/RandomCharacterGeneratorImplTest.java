package org.example.generator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class RandomCharacterGeneratorImplTest {
    private final String uppercaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lowercaseCharacters = "abcdefghijklmnopqrstuvwxyz";
    private final String digitCharacters = "0123456789";
    private final String specialCharacters = "~`!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";
    private final String allowedCharacters = uppercaseCharacters
            .concat(lowercaseCharacters)
            .concat(digitCharacters)
            .concat(specialCharacters);

    @InjectMocks
    private RandomCharacterGeneratorImpl randomCharacterGenerator;

    @Test
    public void checkGenerateUppercaseCharacterMethod() {
        char actual = randomCharacterGenerator.generateUppercaseCharacter();

        assertTrue(uppercaseCharacters.contains(String.valueOf(actual)));
    }

    @Test
    public void checkGenerateLowercaseCharacterMethod() {
        char actual = randomCharacterGenerator.generateLowercaseCharacter();

        assertTrue(lowercaseCharacters.contains(String.valueOf(actual)));
    }

    @Test
    public void checkGenerateDigitCharacterMethod() {
        char actual = randomCharacterGenerator.generateDigitCharacter();

        assertTrue(digitCharacters.contains(String.valueOf(actual)));
    }

    @Test
    public void checkGenerateSpecialCharacterMethod() {
        char actual = randomCharacterGenerator.generateSpecialCharacter();

        assertTrue(specialCharacters.contains(String.valueOf(actual)));
    }

    @Test
    public void checkGenerateAllowedCharacterMethod() {
        char actual = randomCharacterGenerator.generateAllowedCharacter();

        assertTrue(allowedCharacters.contains(String.valueOf(actual)));
    }
}
