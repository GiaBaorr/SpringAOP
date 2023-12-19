package com.example.AOP;

import com.example.AOP.dao.AccountDAO;
import com.example.AOP.dao.MembershipDAO;
import com.example.AOP.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
        return runner ->
                //demoTheBeforeAdvice(accountDAO, membershipDAO);

                //demoTheAfterReturningAdvice(accountDAO);
                //demoTheAfterThrowingAdvice(accountDAO);
                //demoTheAfterAdvice(accountDAO);

                demoTheAroundAdvice(trafficFortuneService);

    }

    private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
        System.out.println("Main program ___________");
        System.out.println("Calling getFortune()");

        String data = trafficFortuneService.getFortune();

        System.out.println("Data from method:" + data);
        System.out.println("Finished ____________");
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {
        List<Account> theAccounts = null;
        try {
            boolean tripWire = false;
            theAccounts = accountDAO.findAccounts(tripWire);
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }
    }

    private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
        List<Account> theAccounts = null;
        try {
            boolean tripWire = true;
            theAccounts = accountDAO.findAccounts(tripWire);
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }

    }

    private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
        List<Account> theAccounts = accountDAO.findAccounts();

        System.out.println(theAccounts);
    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {


        accountDAO.setName("Bao");
        System.out.println(accountDAO.getName());
        accountDAO.setServiceCode("S1");
        System.out.println(accountDAO.getServiceCode());

        accountDAO.addAccount(15);

    }
}
