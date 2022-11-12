package org.example.shuffler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StringShufflerImplTest {
    @InjectMocks
    private StringShufflerImpl stringShuffler;

    @Test
    public void checkShuffleMethod() {
        String sample = "A8!(,wV5YuI[Vr^>";
        String actual = stringShuffler.shuffle(sample);

        assertNotEquals(sample, actual);
        assertEquals(sample.length(), actual.length());

        for (char item : sample.toCharArray()) {
            assertTrue(actual.contains(String.valueOf(item)));
        }
    }
}
