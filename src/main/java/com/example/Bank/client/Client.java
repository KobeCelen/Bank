package com.example.Bank.client;

import jakarta.persistence.*;

@Entity
@Table
public class Client {

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence"
    )
    private Long clientId;
    private String name;
    private String surname;
    private Long accountNumber;


    public Client() {
    }

    public Client(Long clientId, String name, String surname, Long accountNumber) {
        this.clientId = clientId;
        this.name = name;
        this.surname = surname;
        this.accountNumber = accountNumber;
    }

    public Client(String name, String surname, Long accountNumber) {
        this.name = name;
        this.surname = surname;
        this.accountNumber = accountNumber;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
