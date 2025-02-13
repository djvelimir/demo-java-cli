package org.example.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ArgumentValidatorImplTest {

    @InjectMocks
    private ArgumentValidatorImpl argumentValidator;

    @Test
    void checkArgumentsForGeneratePassword() {
        boolean actual = argumentValidator.validate(new String[]{"generate", "password"});

        assertTrue(actual);
    }

    @Test
    void checkInvalidArguments() {
        boolean actual = argumentValidator.validate(new String[]{});

        assertFalse(actual);
    }
}
