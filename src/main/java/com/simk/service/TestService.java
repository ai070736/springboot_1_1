package com.simk.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Async
    public void input(){
        try {
            System.out.println(Thread.currentThread().getName()+":开始sleep:"+System.currentTimeMillis());
            Thread.sleep(3*1000);
            System.out.println(Thread.currentThread().getName()+":结束sleep"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static int i=1;
//    @Scheduled(cron = "*/3 * * * * 0-7")
    public void add(){
        System.out.println("add"+(i++));
    }
}
