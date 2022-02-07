package com.org.bank.port.output;

import java.util.Optional;

import com.org.bank.core.domain.BankAccount;

public interface LoadAccountOutPut {
    Optional<BankAccount> load(Integer id);
}
