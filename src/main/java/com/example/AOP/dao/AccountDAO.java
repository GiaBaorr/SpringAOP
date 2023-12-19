package com.example.AOP.dao;

import com.example.AOP.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts(boolean b);
    List<Account> findAccounts();

    void addAccount(int x);

    public String getName() ;

    public void setName(String name) ;

    public String getServiceCode() ;

    public void setServiceCode(String serviceCode);

}
