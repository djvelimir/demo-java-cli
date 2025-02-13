package org.example.generator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class RandomCharacterGeneratorImplTest {
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
    void checkGenerateUppercaseCharacterMethod() {
        char actual = randomCharacterGenerator.generateUppercaseCharacter();

        assertTrue(uppercaseCharacters.contains(String.valueOf(actual)));
    }

    @Test
    void checkGenerateLowercaseCharacterMethod() {
        char actual = randomCharacterGenerator.generateLowercaseCharacter();

        assertTrue(lowercaseCharacters.contains(String.valueOf(actual)));
    }

    @Test
    void checkGenerateDigitCharacterMethod() {
        char actual = randomCharacterGenerator.generateDigitCharacter();

        assertTrue(digitCharacters.contains(String.valueOf(actual)));
    }

    @Test
    void checkGenerateSpecialCharacterMethod() {
        char actual = randomCharacterGenerator.generateSpecialCharacter();

        assertTrue(specialCharacters.contains(String.valueOf(actual)));
    }

    @Test
    void checkGenerateAllowedCharacterMethod() {
        char actual = randomCharacterGenerator.generateAllowedCharacter();

        assertTrue(allowedCharacters.contains(String.valueOf(actual)));
    }
}
