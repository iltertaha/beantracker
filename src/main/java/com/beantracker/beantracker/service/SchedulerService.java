package com.beantracker.beantracker.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {
    @Scheduled(fixedRate = 1 * 1000 * 60)
    public void reportCurrentTime(){
        System.out.println("heartbeat:  " + System.currentTimeMillis());
    }
}