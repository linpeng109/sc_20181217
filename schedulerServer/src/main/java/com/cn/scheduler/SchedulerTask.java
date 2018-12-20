package com.cn.scheduler;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Configuration
@EnableScheduling
@Log4j2
@Component
public class SchedulerTask {
    private String currentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentDate = dateFormat.format(new Date());
        return currentDate;
    }

    @Scheduled(fixedRate = 5 * 1000)
    public void reportCurrentTimeByFixedRate() {
        log.debug("Fixed Rate mode. Per five seconds. Current Time is " + this.currentTime());
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void reportCurrentTimeByCron() {
        log.debug("Cron mode. Per minutes " + currentTime());
    }
}
