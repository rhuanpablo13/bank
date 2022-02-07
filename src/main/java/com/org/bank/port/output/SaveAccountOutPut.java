package com.org.bank.port.output;

import com.org.bank.core.domain.BankAccount;

public interface SaveAccountOutPut {
    void save(BankAccount account);
}
