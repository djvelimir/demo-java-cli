package org.example.generator;

import java.util.Random;

public class RandomCharacterGeneratorImpl implements RandomCharacterGenerator {
    private final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private final String DIGIT_CHARACTERS = "0123456789";
    private final String SPECIAL_CHARACTERS = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
    private final String ALLOWED_CHARACTERS = UPPERCASE_CHARACTERS
            .concat(LOWERCASE_CHARACTERS)
            .concat(DIGIT_CHARACTERS)
            .concat(SPECIAL_CHARACTERS);
    private final Random RANDOM_OBJECT = new Random();

    @Override
    public char generateUppercaseCharacter() {
        return UPPERCASE_CHARACTERS.charAt(RANDOM_OBJECT.nextInt(UPPERCASE_CHARACTERS.length()));
    }

    @Override
    public char generateLowercaseCharacter() {
        return LOWERCASE_CHARACTERS.charAt(RANDOM_OBJECT.nextInt(LOWERCASE_CHARACTERS.length()));
    }

    @Override
    public char generateDigitCharacter() {
        return DIGIT_CHARACTERS.charAt(RANDOM_OBJECT.nextInt(DIGIT_CHARACTERS.length()));
    }

    @Override
    public char generateSpecialCharacter() {
        return SPECIAL_CHARACTERS.charAt(RANDOM_OBJECT.nextInt(SPECIAL_CHARACTERS.length()));
    }

    @Override
    public char generateAllowedCharacter() {
        return ALLOWED_CHARACTERS.charAt(RANDOM_OBJECT.nextInt(ALLOWED_CHARACTERS.length()));
    }
}
