package io.sterritt.logging.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BasicTests {

    Logger log = LogManager.getLogger(BasicTests.class);

    @Test
    public void testX() {
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}
