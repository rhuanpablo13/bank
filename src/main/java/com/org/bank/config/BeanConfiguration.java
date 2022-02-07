package com.org.bank.config;

import com.org.bank.BankApplication;
import com.org.bank.adapters.BankAccountRepositoryAdapter;
import com.org.bank.core.services.BankAccountService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BankApplication.class)
public class BeanConfiguration {

    @Bean
    BankAccountService bankAccountService(BankAccountRepositoryAdapter repository) {
        return new BankAccountService(repository, repository);
    }
}
