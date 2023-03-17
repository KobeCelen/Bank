package com.example.Bank.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT client FROM Client client WHERE client.accountNumber = ?1")
    Optional<Client> findClientByAccountNumber(Long accountnumber);

    @Query("SELECT balance FROM Client WHERE clientId = ?1")
    double findBalanceByClientId(Long clientId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Client SET balance = balance + ?2 WHERE clientId = ?1")
    void updateBalanceByClientId(Long cliendId, double amount);
}
