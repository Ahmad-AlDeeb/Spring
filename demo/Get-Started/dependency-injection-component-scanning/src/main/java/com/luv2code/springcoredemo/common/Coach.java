package com.luv2code.springcoredemo.common;
import org.springframework.stereotype.Component;

public interface Coach {

    String getDailyWorkout();
}

@Component
class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
