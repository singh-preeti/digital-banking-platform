package com.example.bank.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.bank.entity.*;
import com.example.bank.service.AccountService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService s) {
        this.service = s;
    }

    @PostMapping
    public Account create(@RequestBody Account a) {
        return service.create(a);
    }

    @PostMapping("/{id}/deposit/{amt}")
    public Account deposit(@PathVariable Long id, @PathVariable double amt) {
        return service.deposit(id, amt);
    }

    @PostMapping("/{id}/withdraw/{amt}")
    public Account withdraw(@PathVariable Long id, @PathVariable double amt) {
        return service.withdraw(id, amt);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long from,
                           @RequestParam Long to,
                           @RequestParam double amt) {
        service.transfer(from, to, amt);
        return "Transfer successful";
    }

    @GetMapping("/{id}/transactions")
    public List<Transaction> history(@PathVariable Long id) {
        return service.history(id);
    }
}
