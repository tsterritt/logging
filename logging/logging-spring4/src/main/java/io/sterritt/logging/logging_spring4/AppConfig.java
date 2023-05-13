package io.sterritt.logging.logging_spring4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class AppConfig {

    private static Logger log = LogManager.getLogger(AppConfig.class);

    @Bean
    public String getSampleBean() {
        log.debug("in getSampleBean: debug");
        log.info("in getSampleBean: info");
        log.warn("in getSampleBean: warn");
        log.error("in getSampleBean: error");
        return "hello";
    }
}
