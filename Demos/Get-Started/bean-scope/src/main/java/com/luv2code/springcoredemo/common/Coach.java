package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public interface Coach {

}


@Component
// Change default scope from singleton to prototype
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class CricketCoach implements Coach {

}