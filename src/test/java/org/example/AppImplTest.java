package org.example;

import org.example.processor.ArgumentProcessorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AppImplTest {
    @Mock
    private ArgumentProcessorImpl argumentProcessor;

    @InjectMocks
    AppImpl app;

    @Test
    public void shouldCallProcessMethod() {
        String[] args = new String[]{};

        app.start(args);

        verify(argumentProcessor, times(1)).process(args);
    }
}
