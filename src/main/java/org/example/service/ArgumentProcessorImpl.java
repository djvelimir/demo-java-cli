package org.example.service;

public class ArgumentProcessorImpl implements ArgumentProcessor {
    private PasswordGenerator passwordGenerator;
    private Display display;

    public ArgumentProcessorImpl(PasswordGenerator passwordGenerator, Display display) {
        this.passwordGenerator = passwordGenerator;
        this.display = display;
    }

    public boolean validate(String[] args) {
        return args.length != 0 && args.length == 2 && args[0].equals("generate") && args[1].equals("password");
    }

    public void process(String[] args) {
        switch (args[0]) {
            default:
            case "generate":
                switch (args[1]) {
                    default:
                    case "password":
                        var generatedPassword = passwordGenerator.generatePassword();
                        display.showGeneratedPassword(generatedPassword);
                        break;
                }
                break;
        }
    }
}
