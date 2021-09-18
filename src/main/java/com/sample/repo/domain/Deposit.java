package com.sample.repo.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/** Created for test purpose by a.buchkevich@gmail.com 09/2021
 *  Deposit class to represent entity Deposit */
@Entity    // нужно ли маркировать столько сущностей ??
@Table(name = "deposit")
public class Deposit implements Serializable {
    @Id
    @Column(name = "depositId")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //for MySQL
    private Integer depositId;
    @Column(name = "clientId")
    private Client clientId;
    @Column(name = "bankId")
    private Bank bankId;
    @Column(name = "depositOpen")
    private LocalDate depositOpen;
    @Column(name = "depositRate")
    private Double depositRate;
    @Column(name = "depositClose")
    private LocalDate depositClose;

    //@toString

    //arg-constructor to initialize fields
    public Deposit(Integer depositId, Client clientId, Bank bankId, LocalDate depositOpen, Double depositRate, LocalDate depositClose)
    {
        this.depositId = depositId;
        this.clientId = clientId;
        this.bankId = bankId;
        this.depositOpen = depositOpen;
        this.depositRate = depositRate;
        this.depositClose = depositClose;
    }

    //getter and setter methods

    public Integer getDepositId() { return depositId; }

    public void setDepositId(Integer depositId) {
        this.depositId = depositId;
    }

    public Client getClientId() { return clientId; }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Bank getBankId() { return bankId; }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public LocalDate getDepositOpen() { return depositOpen; }

    public void setDepositOpen(LocalDate depositOpen) {
        this.depositOpen = depositOpen;
    }

    public Double getDepositRate() { return depositRate; }

    public void setDepositRate(Double depositRate) {
        this.depositRate = depositRate;
    }

    public LocalDate getDepositClose() { return depositClose; }

    public void setDepositClose(LocalDate depositClose) {
        this.depositClose = depositClose;
    }
}
