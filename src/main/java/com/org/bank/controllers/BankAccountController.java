package com.org.bank.controllers;

import java.math.BigDecimal;

import com.org.bank.port.input.DepositInput;
import com.org.bank.port.input.TakeInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class BankAccountController {

    @Autowired
    private DepositInput depositInput;
    
    @Autowired
    private TakeInput takeInput;


    @PostMapping(value = "/{id}/deposit/{amount}")
    public void deposit(@PathVariable Integer id, @PathVariable BigDecimal amount) {
        depositInput.deposit(id, amount);
    }

    @PostMapping(value = "/{id}/take/{amount}")
    public void withdraw(@PathVariable Integer id, @PathVariable BigDecimal amount) {
        takeInput.take(id, amount);
    }

}
