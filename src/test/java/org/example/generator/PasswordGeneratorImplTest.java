package org.example.generator;

import org.example.shuffler.StringShuffler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PasswordGeneratorImplTest {
    @Mock
    private RandomCharacterGenerator randomCharacterGenerator;

    @Mock
    private StringShuffler stringShuffler;

    @InjectMocks
    private PasswordGeneratorImpl passwordGenerator;

    @Test
    void shouldCallGenerateUppercaseCharacter() {
        passwordGenerator.generate();

        verify(randomCharacterGenerator, times(1)).generateUppercaseCharacter();
    }

    @Test
    void shouldCallGenerateLowercaseCharacter() {
        passwordGenerator.generate();

        verify(randomCharacterGenerator, times(1)).generateLowercaseCharacter();
    }

    @Test
    void shouldCallGenerateDigitCharacter() {
        passwordGenerator.generate();

        verify(randomCharacterGenerator, times(1)).generateDigitCharacter();
    }

    @Test
    void shouldCallGenerateSpecialCharacter() {
        passwordGenerator.generate();

        verify(randomCharacterGenerator, times(1)).generateSpecialCharacter();
    }

    @Test
    void shouldCallGenerateAllowedCharacter12Times() {
        passwordGenerator.generate();

        verify(randomCharacterGenerator, times(12)).generateAllowedCharacter();
    }

    @Test
    void shouldCallShuffle() {
        passwordGenerator.generate();

        verify(stringShuffler, times(1)).shuffle(any());
    }
}
