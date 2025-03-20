package org.example.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConfigurationImplTest {
    @InjectMocks
    private ConfigurationImpl configuration;

    @Test
    void testLoadWithValidInput() {
        String[] args = new String[]{String.format("--%s", Parameter.PASSWORD_LENGTH_PARAMETER_NAME), "12"};
        configuration.load(args);
        assertEquals("12", configuration.getValue(Parameter.PASSWORD_LENGTH_PARAMETER_NAME));
    }

    @Test
    void testLoadWithNoInputShouldUseDefaultValue() {
        String[] args = new String[]{};
        configuration.load(args);
        assertEquals("16", configuration.getValue(Parameter.PASSWORD_LENGTH_PARAMETER_NAME));
    }

    @Test
    void testGetValueAsInt() {
        String[] args = new String[]{String.format("--%s", Parameter.PASSWORD_LENGTH_PARAMETER_NAME), "20"};
        configuration.load(args);
        assertEquals(20, configuration.getValueAsInt(Parameter.PASSWORD_LENGTH_PARAMETER_NAME));
    }

    @Test
    void testGetValue() {
        String[] args = new String[]{String.format("--%s", Parameter.PASSWORD_LENGTH_PARAMETER_NAME), "20"};
        configuration.load(args);
        assertEquals("20", configuration.getValue(Parameter.PASSWORD_LENGTH_PARAMETER_NAME));
    }

    @Test
    void testGetValueShouldReturnNullForMissingKey() {
        assertNull(configuration.getValue("missingKey"));
    }

    @Test
    void testGetValueAsIntShouldThrowExceptionForInvalidNumber() {
        String[] args = {String.format("--%s", Parameter.PASSWORD_LENGTH_PARAMETER_NAME), "notANumber"};
        configuration.load(args);
        assertThrows(NumberFormatException.class, () -> configuration.getValueAsInt(Parameter.PASSWORD_LENGTH_PARAMETER_NAME));
    }

    @Test
    void testValidatePasswordLengthWithValidValue() {
        String[] args = new String[]{String.format("--%s", Parameter.PASSWORD_LENGTH_PARAMETER_NAME), "16"};
        configuration.load(args);

        boolean actual = configuration.validate();

        assertTrue(actual);
    }

    @Test
    void testValidatePasswordLengthNotNumber() {
        String[] args = new String[]{String.format("--%s", Parameter.PASSWORD_LENGTH_PARAMETER_NAME), "1c6"};
        configuration.load(args);

        boolean actual = configuration.validate();

        assertFalse(actual);
    }

    @Test
    void testValidatePasswordLengthBellowMin() {
        String[] args = new String[]{String.format("--%s", Parameter.PASSWORD_LENGTH_PARAMETER_NAME), "7"};
        configuration.load(args);

        boolean actual = configuration.validate();

        assertFalse(actual);
    }

    @Test
    void testValidatePasswordLengthUpperMax() {
        String[] args = new String[]{String.format("--%s", Parameter.PASSWORD_LENGTH_PARAMETER_NAME), "129"};
        configuration.load(args);

        boolean actual = configuration.validate();

        assertFalse(actual);
    }

    @Test
    void testValidateWithNoArgs() {
        String[] args = new String[]{};
        configuration.load(args);

        boolean actual = configuration.validate();

        assertTrue(actual);
    }
}