package com.example.AOP.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println("Add new account in membershipDAO");
    }

    @Override
    public void addSomething() {
        System.out.println("Add something in membershipDAO");
    }
}
