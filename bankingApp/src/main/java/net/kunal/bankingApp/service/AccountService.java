package net.kunal.bankingApp.service;

import net.kunal.bankingApp.dto.AccountDto;
import java.util.List;
import net.kunal.bankingApp.entity.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);


    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);



}
