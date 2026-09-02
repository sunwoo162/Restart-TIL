package kr.gsm.minibank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// 계좌 : [번호(PK), 계좌번호, 소유자(고객이름), 잔액, 생성날짜]
public class Account {
    private Long id;
    private String accountNumber;
    private String ownerName; // Customer
    private BigDecimal balance;
    private LocalDateTime openedAt;

    public Account(Long id) {
        this.id = id;
    }

    public Account(Long id, String accountNumber, String ownerName, BigDecimal balance, LocalDateTime openedAt) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.openedAt = openedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance=" + balance +
                ", openedAt=" + openedAt +
                '}';
    }
}
