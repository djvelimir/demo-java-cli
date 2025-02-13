package org.example.shuffler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StringShufflerImplTest {
    @InjectMocks
    private StringShufflerImpl stringShuffler;

    @Test
    void checkShuffleMethod() {
        String sample = "A8!(,wV5YuI[Vr^>";
        String actual = stringShuffler.shuffle(sample);

        assertNotEquals(sample, actual);
        assertEquals(sample.length(), actual.length());

        for (char item : sample.toCharArray()) {
            assertTrue(actual.contains(String.valueOf(item)));
        }
    }
}
