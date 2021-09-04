package com.sample.domain;

import java.io.Serializable;
import javax.persistence.*;

/** Created for test purpose by a.buchkevich@gmail.com 09/2021
 *  Bank class to represent entity Bank */
@Entity
@Table(name = "bank")
public class Bank implements Serializable {
    @Id
    @Column(name = "bankId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bankId;
    @Column(name = "bankName")
    private String bankName;
    @Column(name = "bankIdCode")
    private Integer bankIdCode;

    //arg-constructor to initialize fields
    public Bank(Integer bankId, String bankName, Integer bankIdCode)
    {
        this.bankId = bankId; // сделать генератор исходя из заполнения autoincrement
        this.bankName = bankName;
        this.bankIdCode = bankIdCode;
    }

    //getter and setter methods
    public Integer getBankId() { return bankId; }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() { return bankName; }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getBankIdCode() { return bankIdCode; }

    public void setBankIdCode(Integer bankIdCode) {
        this.bankIdCode = bankIdCode;
    }
}



