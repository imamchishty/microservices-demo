package com.demo.manufacturer.rest.controller;

import com.demo.manufacturer.rest.feign.client.AccountClient;
import com.demo.manufacturer.exception.GlobalBusinessCodes;
import com.demo.manufacturer.rest.constant.ApiConstants;
import com.shedhack.exception.core.BusinessException;
import com.shedhack.thread.context.annotation.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * This is an example controller with a feign client.
 */
@RestController
public class PingController {

    @Value("${spring.application.name}")
    private String appName;

    /**
     * Used to provide tools a HTTP 200 OK when service is running.
     */
    @ThreadContext // writes to the xxx-audit.log
    @RequestMapping(path = ApiConstants.API_PING, method = RequestMethod.GET)
    public ResponseEntity<String> ping(){
        return new ResponseEntity<>(appName + " is running.....", HttpStatus.OK);
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    // ---------------------------------
    // Methods for demostration purposes
    // ---------------------------------

    @Autowired
    private AccountClient client;

    /**
     * THIS METHOD IS A FEIGN EXAMPLE, PLEASE SEE AccountClient
     * Remove when you're happy.
     */
    @ThreadContext
    @RequestMapping(value = "/api/accounts", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Integer>> getAllAccountBalances() {

        List<String> users = Arrays.asList("Batman", "Joker", "Superman", "Lex");
        Map<String, Integer> balances = new HashMap(users.size());

        for(String user : users) {
            balances.put(user, client.getBalance(1).getBody());
        }

        return new ResponseEntity<>(balances, HttpStatus.OK);
    }

    /**
     * THIS METHOD IS A FEIGN EXAMPLE, PLEASE SEE AccountClient.
     * Remove when you're happy.
     */
    @ThreadContext
    @RequestMapping(value = "/api/accounts/problem", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Integer>> getAllAccountBalancesThrowException() {

        List<String> users = Arrays.asList("Batman", "Joker", "Superman", "Lex");
        Map<String, Integer> balances = new HashMap(users.size());

        for(String user : users) {
            balances.put(user, client.getBalance(11).getBody());
        }

        return new ResponseEntity<>(balances, HttpStatus.OK);
    }

    /**
     * THIS METHOD IS A FEIGN EXAMPLE, PLEASE SEE AccountClient.
     * Remove when you're happy.
     */
    @ThreadContext
    @RequestMapping(value = "/api/accounts/{id}/balance", method = RequestMethod.GET)
    public ResponseEntity<Integer> getBalance(@PathVariable("id") long id) {

        // Lets throw an exception if the id > 10
        if(id > 10) {
            throw BusinessException.builder(new IllegalArgumentException("Invalid account number")).generateId()
                    .withBusinessCode(GlobalBusinessCodes.C001).withParam("id", id).build();
        }

        Random rn = new Random();
        int range = 1000000000 - 10 + 1;
        int randomNum =  rn.nextInt(range) + 10;

        return new ResponseEntity<>(randomNum, HttpStatus.OK);
    }

}