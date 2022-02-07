package com.org.bank.port.input;

import java.math.BigDecimal;

public interface DepositInput {
    void deposit(Integer id, BigDecimal amount);
}
