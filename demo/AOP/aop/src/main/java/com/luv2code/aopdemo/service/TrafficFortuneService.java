package com.luv2code.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

public interface TrafficFortuneService {
    void getFortune(boolean doException);
}


@Service
class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public void getFortune(boolean doException) {

        // for academic purposes ... simulate an exception
        if (doException) {
            throw new RuntimeException("Runtime Exception from getFortune() !");
        }
        System.out.println("Getting fortune.....");
    }
}