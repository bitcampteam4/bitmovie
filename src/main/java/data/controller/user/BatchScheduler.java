package data.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BatchScheduler {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    //10초마다 실행
    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
    public void testSchedule() {
        logger.info("[MYTEST] test batch {}", LocalDateTime.now());
    }
}