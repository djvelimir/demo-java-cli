package org.example.generator;

import java.security.SecureRandom;

public class RandomCharacterGeneratorImpl implements RandomCharacterGenerator {
    private final String uppercaseCharacters;
    private final String lowercaseCharacters;
    private final String digitCharacters;
    private final String specialCharacters;
    private final String allowedCharacters;
    private final SecureRandom random = new SecureRandom();

    public RandomCharacterGeneratorImpl() {
        uppercaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowercaseCharacters = "abcdefghijklmnopqrstuvwxyz";
        digitCharacters = "0123456789";
        specialCharacters = "~`!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";
        allowedCharacters = uppercaseCharacters
                .concat(lowercaseCharacters)
                .concat(digitCharacters)
                .concat(specialCharacters);
    }

    @Override
    public char generateUppercaseCharacter() {
        return uppercaseCharacters.charAt(random.nextInt(uppercaseCharacters.length()));
    }

    @Override
    public char generateLowercaseCharacter() {
        return lowercaseCharacters.charAt(random.nextInt(lowercaseCharacters.length()));
    }

    @Override
    public char generateDigitCharacter() {
        return digitCharacters.charAt(random.nextInt(digitCharacters.length()));
    }

    @Override
    public char generateSpecialCharacter() {
        return specialCharacters.charAt(random.nextInt(specialCharacters.length()));
    }

    @Override
    public char generateAllowedCharacter() {
        return allowedCharacters.charAt(random.nextInt(allowedCharacters.length()));
    }
}
