package net.kunal.bankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private String accountHolderName;
    private Long id;
    private double balance;
}
