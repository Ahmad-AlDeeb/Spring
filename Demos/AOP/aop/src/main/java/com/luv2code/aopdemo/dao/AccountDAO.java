package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface AccountDAO {

    List<Account> getAllAccounts(boolean doException);

    void addAccount(Account theAccount);


    String getName();

    void setName(String name);

}

@Repository
class AccountDAOImpl implements AccountDAO {
    private String name;
    @Override
    public List<Account> getAllAccounts(boolean doException) {

        // for academic purposes ... simulate an exception
        if (doException) {
            throw new RuntimeException("Run-time exception from getAllAccounts()!!!");
        }

        // Create accounts list & add sample accounts
        System.out.println("Getting all accounts.....");
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("John"));
        accounts.add(new Account("Madhu"));
        accounts.add(new Account("Luca"));

        return accounts;
    }
    @Override
    public void addAccount(Account theAccount) {
        System.out.println("Adding account.....");
    }

    /** Getters/Setters **/
    public String getName() {
        System.out.println("Getting name.....");
        return name;
    }

    public void setName(String name) {
        System.out.println("Setting name.....");
        this.name = name;
    }
}
