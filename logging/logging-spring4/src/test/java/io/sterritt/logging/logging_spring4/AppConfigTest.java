package io.sterritt.logging.logging_spring4;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppConfigTest  {

    @Autowired
    String sampleBean;

    @Test
    public void testX() {
        assertEquals("hello",sampleBean);
    }

}