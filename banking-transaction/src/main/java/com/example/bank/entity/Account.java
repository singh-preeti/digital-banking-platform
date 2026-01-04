package com.example.bank.entity;
import jakarta.persistence.*;
@Entity
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String accountHolderName;
private double balance;
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getAccountHolderName() { return accountHolderName; }
public void setAccountHolderName(String name) { this.accountHolderName = name; }
public double getBalance() { return balance; }
public void setBalance(double balance) { this.balance = balance; }
}