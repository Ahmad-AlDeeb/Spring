package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

public interface MembershipDAO {

    boolean addSillyMember();

    void goToSleep();
}

@Repository
class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addSillyMember() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");

        return true;
    }

    @Override
    public void goToSleep() {

        System.out.println(getClass() + ": I'm going to sleep now...");

    }
}