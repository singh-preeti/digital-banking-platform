package com.example.bank.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bank.entity.*;
import com.example.bank.repository.*;

@Service
public class AccountService {

    private final AccountRepository accountRepo;
    private final TransactionRepository txRepo;

    public AccountService(AccountRepository a, TransactionRepository t) {
        this.accountRepo = a;
        this.txRepo = t;
    }

    public Account create(Account a) {
        return accountRepo.save(a);
    }

    public Account deposit(Long id, double amt) {
        Account a = accountRepo.findById(id).orElseThrow();
        a.setBalance(a.getBalance() + amt);
        accountRepo.save(a);
        saveTx(id, "DEPOSIT", amt, "Deposit");
        return a;
    }

    public Account withdraw(Long id, double amt) {
        Account a = accountRepo.findById(id).orElseThrow();
        if (a.getBalance() < amt) throw new RuntimeException("Insufficient balance");
        a.setBalance(a.getBalance() - amt);
        accountRepo.save(a);
        saveTx(id, "WITHDRAW", amt, "Withdraw");
        return a;
    }

    @Transactional
    public void transfer(Long from, Long to, double amt) {
        Account f = accountRepo.findById(from).orElseThrow();
        Account t = accountRepo.findById(to).orElseThrow();
        if (f.getBalance() < amt) throw new RuntimeException("Insufficient balance");

        f.setBalance(f.getBalance() - amt);
        t.setBalance(t.getBalance() + amt);

        accountRepo.save(f);
        accountRepo.save(t);

        saveTx(from, "TRANSFER", amt, "To " + to);
        saveTx(to, "TRANSFER", amt, "From " + from);
    }

    public List<Transaction> history(Long id) {
        return txRepo.findByAccountId(id);
    }

    private void saveTx(Long acc, String type, double amt, String remarks) {
        Transaction tx = new Transaction();
        tx.setAccountId(acc);
        tx.setType(type);
        tx.setAmount(amt);
        tx.setTransactionTime(LocalDateTime.now());
        tx.setRemarks(remarks);
        txRepo.save(tx);
    }
}
