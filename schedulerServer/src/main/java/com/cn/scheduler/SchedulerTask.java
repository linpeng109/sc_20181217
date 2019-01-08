package com.cn.scheduler;

import com.cn.feign.AmqpProxy;
import com.cn.feign.UserBaseProxy;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Configuration
@EnableScheduling
@Log4j2
@Component
public class SchedulerTask {
    @Autowired
    protected UserBaseProxy userBaseProxy;

    @Autowired
    protected AmqpProxy amqpProxy;

    private String currentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(new Date());
    }

    @Scheduled(fixedRate = 5 * 1000)
    public void reportCurrentTimeByFixedRate() {
        log.debug("Fixed Rate mode. Per five seconds. Current Time is " + this.currentTime());
    }

    @Scheduled(fixedRate = 10 * 1000)
    public void reportAmqpByFixedRate() {
        UUID uuid = UUID.randomUUID();
        log.debug(amqpProxy.sendMsg(uuid.toString()));
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void reportCurrentTimeByCron() {
        log.debug("Cron mode. Per minutes " + currentTime());
        int page = new Random().nextInt(100);
        int size = new Random().nextInt(18);
        log.debug(userBaseProxy.findAll(page, size));
    }
}
