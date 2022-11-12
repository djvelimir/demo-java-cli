package org.example.validator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentValidatorImplTest {

    @InjectMocks
    private ArgumentValidatorImpl argumentValidator;

    @Test
    public void checkArgumentsForGeneratePassword() {
        boolean actual = argumentValidator.validate(new String[]{"generate", "password"});

        assertTrue(actual);
    }

    @Test
    public void checkInvalidArguments() {
        boolean actual = argumentValidator.validate(new String[]{});

        assertFalse(actual);
    }
}
