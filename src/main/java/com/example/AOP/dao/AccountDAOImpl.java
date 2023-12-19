package com.example.AOP.dao;

import com.example.AOP.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": getServiceCode()");
        this.serviceCode = serviceCode;
    }
    @Override
    public List<Account> findAccounts() {
        return  findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire){
            throw new RuntimeException("No soup for you");
        }

        List<Account> myAccounts = new ArrayList<>();

        Account acc1 = new Account("Bao","Gold");
        Account acc2 = new Account("Zach","Silver");
        Account acc3 = new Account("Milk","Titan");

        myAccounts.add(acc1);
        myAccounts.add(acc2);
        myAccounts.add(acc3);

        return myAccounts;
    }

    @Override
    public void addAccount(int x) {
        System.out.println("X: " +x);
        System.out.println("Adding Account .....");
    }
}
