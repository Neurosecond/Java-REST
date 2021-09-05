package com.sample.domain;

import java.io.Serializable;
import javax.persistence.*;

/** Created for test purpose by a.buchkevich@gmail.com 09/2021
 *  Client class to represent entity Client */
@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @Column(name = "clientId")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //указать auto-increment in MySQL
    private Integer clientId;
    @Column(name = "clientName")
    private String clientName;
    @Column(name = "clientTitle")
    private String clientTitle;
    @Column(name = "clientAddress")
    private String clientAddress;
    @Column(name = "formId")
    private Form formId;

    //@toString

    //arg-constructor to initialize fields
    public Client(Integer clientId, String clientName, String clientTitle, String clientAddress, Form formId)
    {
        this.clientId = clientId; // с учетом генератора
        this.clientName = clientName;
        this.clientTitle = clientTitle;
        this.clientAddress =clientAddress;
        this.formId = formId;
    }

    //getter and setter methods

    public Integer getClientId() { return clientId; }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientTitle() { return clientTitle; }

    public void setClientTitle(String clientTitle) {
        this.clientTitle = clientTitle;
    }

    public String getClientAddress() { return clientAddress; }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Form getFormId() { return formId; }

    public void setFormId(Form formId) {
        this.formId = formId;
    }
}
