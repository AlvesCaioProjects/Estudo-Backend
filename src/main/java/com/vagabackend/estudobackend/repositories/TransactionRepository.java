package com.vagabackend.estudobackend.repositories;

import com.vagabackend.estudobackend.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
