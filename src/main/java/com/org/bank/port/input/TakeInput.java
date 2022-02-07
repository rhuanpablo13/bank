package com.org.bank.port.input;

import java.math.BigDecimal;

public interface TakeInput {
    boolean take(Integer id, BigDecimal amount);
}
