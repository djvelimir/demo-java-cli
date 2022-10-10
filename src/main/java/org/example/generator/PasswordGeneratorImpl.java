package org.example.generator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Concrete implementation of service for password generation
 */
public class PasswordGeneratorImpl implements PasswordGenerator {
    private static final int PASSWORD_LENGTH = 16;
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGIT_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
    private static final String UNION_OF_CHARACTERS = UPPERCASE_CHARACTERS
            .concat(LOWERCASE_CHARACTERS)
            .concat(DIGIT_CHARACTERS)
            .concat(SPECIAL_CHARACTERS);
    private static final Random RANDOM_OBJECT = new Random();

    /**
     * Generate random password
     * Generated password length is 16
     * Generated password contains at least one uppercase character
     * Generated password contains at least one lowercase character
     * Generated password contains at least one digit character
     * Generated password contains at least one special character
     *
     * @return generated password
     */
    @Override
    public String generatePassword() {
        var stringBuilder = new StringBuilder();

        // generate at least one uppercase character
        stringBuilder.append(getRandomCharacter(UPPERCASE_CHARACTERS));

        // generate at least one lowercase character
        stringBuilder.append(getRandomCharacter(LOWERCASE_CHARACTERS));

        // generate at least one digit character
        stringBuilder.append(getRandomCharacter(DIGIT_CHARACTERS));

        // generate at least one special character
        stringBuilder.append(getRandomCharacter(SPECIAL_CHARACTERS));

        // generate random character from allowed characters
        for (int i = 4; i < PASSWORD_LENGTH; i++) {
            stringBuilder.append(getRandomCharacter(UNION_OF_CHARACTERS));
        }

        // shuffle generated characters
        List<String> ch = Arrays.asList(stringBuilder.toString().split(""));
        Collections.shuffle(ch);

        // return generated password
        return String.join("", ch);
    }

    private char getRandomCharacter(String characters) {
        return characters.charAt(RANDOM_OBJECT.nextInt(characters.length()));
    }
}
