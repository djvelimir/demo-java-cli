package org.example;

import org.example.processor.ArgumentProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AppImplTest {
    @Mock
    private ArgumentProcessor argumentProcessor;

    @InjectMocks
    private AppImpl app;

    @Test
    void shouldCallProcessMethod() {
        String[] args = new String[]{};

        app.start(args);

        verify(argumentProcessor, times(1)).process(args);
    }
}
