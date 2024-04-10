package net.kunal.bankingApp.service.impl;

import net.kunal.bankingApp.dto.AccountDto;
import net.kunal.bankingApp.entity.Account;
import net.kunal.bankingApp.mapper.AccountMapper;
import net.kunal.bankingApp.repository.AccountRepository;
import net.kunal.bankingApp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl  implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account1 = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account1);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow( ()-> new RuntimeException(("Account does not exist")));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow( ()-> new RuntimeException(("Account does not exist")));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }



    @Override
    public AccountDto withdraw(Long id, double withDraw) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow( ()-> new RuntimeException(("Account does not exist")));

        if(account.getBalance() < withDraw){
            throw new RuntimeException("Insufficient funds");
        }

        double x = account.getBalance() - withDraw;
        account.setBalance(x);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account)-> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow( ()-> new RuntimeException(("Account does not exist")));

        accountRepository.deleteById(id);
    }
}
