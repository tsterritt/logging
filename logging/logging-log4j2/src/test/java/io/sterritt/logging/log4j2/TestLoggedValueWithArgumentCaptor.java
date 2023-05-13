package io.sterritt.logging.log4j2;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.spi.LoggerContext;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Mock testing of the Log4j framework. Uses a rule for mocking so the runner can be whatever (in this case, JUnit4).
 * Need to have the config file that allows Mockito to mock final classes (see org.mockito.plugins.MockMaker). Using a spy of
 * the logger so the arguments are captured. 
 */
@RunWith(JUnit4.class)
public class TestLoggedValueWithArgumentCaptor {

    //io.sterritt is a logger configured in log4j.xml.
    @Spy
    private Logger logger = LogManager.getLogger("io.sterritt");

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Captor
    ArgumentCaptor<String> logMessageCaptor;

    @Test
    public void testLoggedMessageUsingSpyLogger() {
        logger.info("this is an info message");
        verify(logger).info(logMessageCaptor.capture());
        assertEquals("this is an info message", logMessageCaptor.getValue());
    }
}
