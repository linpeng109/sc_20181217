package com.cn.scheduler;

import com.cn.feign.UserBaseProxy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
@EnableScheduling
@Log4j2
@Component
public class SchedulerTask {
    @Autowired
    private UserBaseProxy userBaseProxy;

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
        log.debug(userBaseProxy.findAll(1, 1));
    }
}
