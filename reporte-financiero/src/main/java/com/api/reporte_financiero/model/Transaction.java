package com.api.reporte_financiero.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor

public class Transaction {
    private String accountFrom;
    private String accountTo;
    private Double amount;
    private LocalDate date;

    public Transaction(String accountFrom, String accountTo, Double amount, LocalDate date) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.date = date;
    }

    // Getters y setters
    public String getAccountFrom() { return accountFrom; }
    public void setAccountFrom(String accountFrom) { this.accountFrom = accountFrom; }

    public String getAccountTo() { return accountTo; }
    public void setAccountTo(String accountTo) { this.accountTo = accountTo; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    @Override
    public String toString() {
        return "Transaction{" +
                "from='" + accountFrom + '\'' +
                ", to='" + accountTo + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
