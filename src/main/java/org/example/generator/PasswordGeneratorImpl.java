package org.example.generator;

import com.google.inject.Inject;
import org.example.configuration.Configuration;
import org.example.configuration.Parameter;
import org.example.shuffler.StringShuffler;

public class PasswordGeneratorImpl implements PasswordGenerator {
    private final Configuration configuration;
    private final RandomCharacterGenerator randomCharacterGenerator;
    private final StringShuffler stringShuffler;

    @Inject
    public PasswordGeneratorImpl(RandomCharacterGenerator randomCharacterGenerator, StringShuffler stringShuffler, Configuration configuration) {
        this.configuration = configuration;
        this.randomCharacterGenerator = randomCharacterGenerator;
        this.stringShuffler = stringShuffler;
    }

    /**
     * Generate random password
     * Generated password length with a default value of 16, you can use a parameter for the desired length
     * Generated password contains at least one uppercase character
     * Generated password contains at least one lowercase character
     * Generated password contains at least one digit character
     * Generated password contains at least one special character
     *
     * @return generated password
     */
    @Override
    public String generate() {
        int passwordLength = configuration.getValueAsInt(Parameter.PASSWORD_LENGTH_PARAMETER_NAME);
        StringBuilder stringBuilder = new StringBuilder();

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
