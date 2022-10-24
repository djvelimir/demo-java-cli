package org.example.util;

import java.util.Random;

public class RandomCharacter {
    private static final Random RANDOM_OBJECT = new Random();

    public static char get(String characters) {
        return characters.charAt(RANDOM_OBJECT.nextInt(characters.length()));
    }
}
