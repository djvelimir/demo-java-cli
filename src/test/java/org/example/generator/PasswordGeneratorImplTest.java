package org.example.generator;

import org.example.shuffler.StringShuffler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PasswordGeneratorImplTest {
    @Mock
    private RandomCharacterGenerator randomCharacterGenerator;

    @Mock
    private StringShuffler stringShuffler;

    @InjectMocks
    private PasswordGeneratorImpl passwordGenerator;

    @Test
    public void shouldCallGenerateUppercaseCharacter() {
        passwordGenerator.generate();

        verify(randomCharacterGenerator, times(1)).generateUppercaseCharacter();
    }

    @Test
    public void shouldCallGenerateLowercaseCharacter() {
        passwordGenerator.generate();

        verify(randomCharacterGenerator, times(1)).generateLowercaseCharacter();
    }

    @Test
    public void shouldCallGenerateDigitCharacter() {
        passwordGenerator.generate();

        verify(randomCharacterGenerator, times(1)).generateDigitCharacter();
    }

    @Test
    public void shouldCallGenerateSpecialCharacter() {
        passwordGenerator.generate();

        verify(randomCharacterGenerator, times(1)).generateSpecialCharacter();
    }

    @Test
    public void shouldCallGenerateAllowedCharacter12Times() {
        passwordGenerator.generate();

        verify(randomCharacterGenerator, times(12)).generateAllowedCharacter();
    }

    @Test
    public void shouldCallShuffle() {
        passwordGenerator.generate();

        verify(stringShuffler, times(1)).shuffle(any());
    }
}
