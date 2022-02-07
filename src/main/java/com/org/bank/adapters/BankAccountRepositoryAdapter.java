package com.org.bank.adapters;

import java.util.Optional;

import com.org.bank.core.domain.BankAccount;
import com.org.bank.port.output.LoadAccountOutPut;
import com.org.bank.port.output.SaveAccountOutPut;
import com.org.bank.repository.BankAccountRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankAccountRepositoryAdapter implements LoadAccountOutPut, SaveAccountOutPut {

    private Logger log = LoggerFactory.getLogger(BankAccountRepositoryAdapter.class);

    @Autowired
    private BankAccountRepository bankAccountRepository;


    @Override
    public void save(BankAccount account) {
        log.info("Salvando conta: {}", account);
        bankAccountRepository.save(account);
    }

    @Override
    public Optional<BankAccount> load(Integer id) {
        log.info("Carregando conta: {}", id);
        return bankAccountRepository.findById(id);
    }
    
}
