package org.example.generator;

import org.example.shuffler.StringShuffler;

import javax.inject.Inject;

public class PasswordGeneratorImpl implements PasswordGenerator {
    private final int passwordLength;
    private final RandomCharacterGenerator randomCharacterGenerator;
    private final StringShuffler stringShuffler;

    @Inject
    public PasswordGeneratorImpl(RandomCharacterGenerator randomCharacterGenerator, StringShuffler stringShuffler) {
        this.passwordLength = 16;
        this.randomCharacterGenerator = randomCharacterGenerator;
        this.stringShuffler = stringShuffler;
    }

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

        stringBuilder.append(randomCharacterGenerator.generateUppercaseCharacter());
        stringBuilder.append(randomCharacterGenerator.generateLowercaseCharacter());
        stringBuilder.append(randomCharacterGenerator.generateDigitCharacter());
        stringBuilder.append(randomCharacterGenerator.generateSpecialCharacter());

        for (int i = 0; i < passwordLength - 4; i++) {
            stringBuilder.append(randomCharacterGenerator.generateAllowedCharacter());
        }

        return stringShuffler.shuffle(stringBuilder.toString());
    }
}
