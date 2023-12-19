package com.example.AOP.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {
        if(true){
            throw new RuntimeException("demo exception");
        }

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException exception){
            throw new RuntimeException(exception);
        }
        return "Expect heavy traffic this morning.";
    }
}
