package io.sterritt.logging.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.junit.Before;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


/**
 * Add a mock appender to the logging configuration. Can be used when logging through a framework and can't mock or spy the
 * actually Logger that is going to be used.
 *
 * Note that the Logger class is actually the *log4j.core.Logger class, which isn't really part of the public API. It still
 * work but isn't something the Log4j people are necessary cool with.
 */
@RunWith(JUnit4.class)
public class TestAddingMockAppenderToLogger {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    protected Appender mockAppender;

    @Captor
    protected ArgumentCaptor<LogEvent> captor;

    protected Logger logger;

    @Before
    public void addMockLoggerToLoggerConfig() {
        //getName and isStarted need to be set for the appender to be used by Log4j.
        when(mockAppender.getName()).thenReturn("MockAppender");
        when(mockAppender.isStarted()).thenReturn(true);
        logger = (Logger) LogManager.getRootLogger();
        logger.addAppender(mockAppender);
    }

    @Test
    public void testLogAMessage() {
        logger.setLevel(Level.INFO);
        logger.info("Logging an info message");
        verify(mockAppender, times(1)).append(captor.capture());
        LogEvent event = captor.getValue();

        assertEquals("Logging an info message",event.getMessage().getFormattedMessage());
    }


}
