package org.example.generator;

public interface RandomCharacterGenerator {
    char generateUppercaseCharacter();

    char generateLowercaseCharacter();

    char generateDigitCharacter();

    char generateSpecialCharacter();

    char generateAllowedCharacter();
}
