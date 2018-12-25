package com.clickfarm.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * fixedRate:每隔5秒执行一次
     */
    //@Scheduled(fixedRate=5000) 
    public void reportCurrentTime1() {
        log.info("The time1 is now {}", dateFormat.format(new Date()));
    }
    
    /**
     * cron:每隔10秒执行一次
     * 详情：https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
     */
    //@Scheduled(cron="*/10 * * * * *") 
    public void reportCurrentTime2() {
        log.info("The time2 is now {}", dateFormat.format(new Date()));
    }
    
}