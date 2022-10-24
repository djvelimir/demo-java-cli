package org.example.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringShuffler {
    public static String shuffle(String stringToShuffle) {
        List<String> list = Arrays.asList(stringToShuffle.split(""));
        Collections.shuffle(list);
        return String.join("", list);
    }
}
