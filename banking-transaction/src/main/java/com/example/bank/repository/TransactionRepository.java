package com.example.bank.repository;

//TransactionRepository.java


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
 List<Transaction> findByAccountId(Long accountId);
}
