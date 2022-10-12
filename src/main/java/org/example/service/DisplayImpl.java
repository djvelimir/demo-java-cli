package org.example.service;

public class DisplayImpl implements Display {
    public void showUsage() {
        System.out.println("Usage:");
        System.out.println("java -jar ./demo-java-cli.jar generate password");
    }

    public void showGeneratedPassword(String generatedPassword) {
        System.out.println("Generated password is: " + generatedPassword);
    }
}
