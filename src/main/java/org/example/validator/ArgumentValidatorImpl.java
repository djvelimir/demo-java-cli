package org.example.validator;

public class ArgumentValidatorImpl implements ArgumentValidator {
    @Override
    public boolean validate(String[] args) {
        return args.length != 0 && args.length == 2 && args[0].equals("generate") && args[1].equals("password");
    }
}
