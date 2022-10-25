package org.example.shuffler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringShufflerImpl implements StringShuffler {
    public String shuffle(String characters) {
        List<String> list = Arrays.asList(characters.split(""));
        Collections.shuffle(list);
        return String.join("", list);
    }
}
