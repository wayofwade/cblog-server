package com.cblog.service;

// import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// @Slf4j
@Service
public class TickService {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 60000) // 没60秒传给前端信息
    public void tick() {
        String currentTime = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
        // log.info("Message send to client: {}", currentTime);
        System.out.println("Message send to client: {} " + currentTime);
        template.convertAndSend("/global-message/tick", currentTime);
    }
}
