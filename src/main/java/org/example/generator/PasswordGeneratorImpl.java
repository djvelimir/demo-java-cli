package org.example.generator;

import org.example.util.RandomCharacter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PasswordGeneratorImpl implements PasswordGenerator {
    private static final int PASSWORD_LENGTH = 16;
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGIT_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
    private static final String UNION_OF_ALLOWED_CHARACTERS = UPPERCASE_CHARACTERS
            .concat(LOWERCASE_CHARACTERS)
            .concat(DIGIT_CHARACTERS)
            .concat(SPECIAL_CHARACTERS);

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
    public String generate() {
        var stringBuilder = new StringBuilder();

        // generate at least one uppercase character
        stringBuilder.append(RandomCharacter.get(UPPERCASE_CHARACTERS));

        // generate at least one lowercase character
        stringBuilder.append(RandomCharacter.get(LOWERCASE_CHARACTERS));

        // generate at least one digit character
        stringBuilder.append(RandomCharacter.get(DIGIT_CHARACTERS));

        // generate at least one special character
        stringBuilder.append(RandomCharacter.get(SPECIAL_CHARACTERS));

        for (int i = 4; i < PASSWORD_LENGTH; i++) {
            // generate random character from union of allowed characters
            stringBuilder.append(RandomCharacter.get(UNION_OF_ALLOWED_CHARACTERS));
        }

        // shuffle generated characters
        List<String> ch = Arrays.asList(stringBuilder.toString().split(""));
        Collections.shuffle(ch);

        // return generated password
        return String.join("", ch);
    }
}
