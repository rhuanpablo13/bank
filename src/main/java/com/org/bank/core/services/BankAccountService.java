package com.org.bank.core.services;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

import com.org.bank.core.domain.BankAccount;
import com.org.bank.port.input.DepositInput;
import com.org.bank.port.input.TakeInput;
import com.org.bank.port.output.LoadAccountOutPut;
import com.org.bank.port.output.SaveAccountOutPut;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service
public class BankAccountService implements DepositInput, TakeInput {

    private Logger log = LoggerFactory.getLogger(BankAccountService.class);

    @Autowired
    private LoadAccountOutPut loadAccount;
    
    @Autowired
    private SaveAccountOutPut saveAccount;


    public BankAccountService(LoadAccountOutPut loadAccount, SaveAccountOutPut saveAccount) {
        this.loadAccount = loadAccount;
        this.saveAccount = saveAccount;
    }

    @Override
    public void deposit(Integer id, BigDecimal amount) {
        log.info("Depósito para a conta: {}, no valor de {}", id, amount);

        BankAccount account = loadAccount
        .load(id)
        .orElseThrow(NoSuchElementException::new);

        account.deposit(amount);

        saveAccount.save(account);
        log.info("Depósito de {}, realizado com sucesso para conta: {}", amount, id);
    }

    @Override
    public boolean take(Integer id, BigDecimal amount) {
        log.info("Saque da conta: {}, no valor de {}", id, amount);

        BankAccount account = loadAccount
        .load(id)
        .orElseThrow(NoSuchElementException::new);

        boolean hasWithdrawn = account.take(amount);

        if(hasWithdrawn) {
            saveAccount.save(account);
            log.info("Saque de {}, realizado com sucesso na conta: {}", amount, id);
        }
        return hasWithdrawn;
    }
    
}
