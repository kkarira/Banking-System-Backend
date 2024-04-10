package net.kunal.bankingApp.mapper;

import net.kunal.bankingApp.dto.AccountDto;
import net.kunal.bankingApp.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
        accountDto.getAccountHolderName(),
        accountDto.getBalance());

        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getAccountHolderName(),
                account.getId(),
                account.getBalance()
                );
    return accountDto;
    }
}
