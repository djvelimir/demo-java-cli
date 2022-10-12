package org.example;

import org.example.generator.PasswordGenerator;
import org.example.generator.PasswordGeneratorImpl;

/**
 * Main application class
 */
public class App {
    private PasswordGenerator passwordGenerator;

    public static void main(String[] args) {
        var app = new App(new PasswordGeneratorImpl());
        app.start(args);
    }

    private App(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    private void start(String[] args) {
        if (!isValid(args)) {
            showUsage();
            return;
        }

        process(args);
    }

    private boolean isValid(String[] args) {
        return args.length != 0 && args.length == 2 && args[0].equals("generate") && args[1].equals("password");
    }

    private void process(String[] args) {
        switch (args[0]) {
            case "generate":
                switch (args[1]) {
                    case "password":
                        var generatedPassword = passwordGenerator.generatePassword();
                        showGeneratedPassword(generatedPassword);
                        break;
                }
                break;
        }
    }

    private void showUsage() {
        System.out.println("Usage:");
        System.out.println("java -jar ./demo-java-cli.jar generate password");
    }

    private void showGeneratedPassword(String generatedPassword) {
        System.out.println("Generated password is: " + generatedPassword);
    }
}
