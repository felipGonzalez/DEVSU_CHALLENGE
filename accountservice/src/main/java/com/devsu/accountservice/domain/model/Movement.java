package com.devsu.accountservice.domain.model;

import com.devsu.accountservice.domain.DomainException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movement {
    public static final String AMERICA_BOGOTA = "America/Bogota";
    private Long id;
    private String accountId;
    private LocalDateTime date;
    private BigDecimal amount;

    private MovementType movementType;

    private Account account;

    private BigDecimal balance;

    public void addMovementType(String type){
        this.movementType = MovementType.fromValue(type);
    }


    public boolean getStatusAccount(){
        return account.isStatus();
    }

    public String getTypeAccountValue(){
        if(account == null) {
            return null;
        }
        return account.getType().getValue();
    }

    public String getTypeMovementValue(){
        if(movementType == null) {
            return null;
        }
        return movementType.getValue();
    }

    public void addMovement(Account account){
        if (amount.compareTo(BigDecimal.ZERO) < 0  &&
                account.getBalance().add(amount).compareTo(BigDecimal.ZERO) < 0) {
            throw new DomainException("Saldo no disponible");
        }
        account.setBalance(account.getBalance().add(amount));
        this.account = account;
        date = LocalDateTime.now(ZoneId.of(AMERICA_BOGOTA));
        balance = account.getBalance();
        movementType = MovementType.getTypeFromAmount(amount);
    }

    public BigDecimal getInitialBalance(){
        return balance.add(amount.multiply(BigDecimal.valueOf(-1)));
    }

}