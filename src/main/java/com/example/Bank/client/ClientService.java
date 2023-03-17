package com.example.Bank.client;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // you can use @Component but the @Service is more specific
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
        Optional<Client> clientOptional = clientRepository.findClientByAccountNumber(client.getAccountNumber());
        if (clientOptional.isPresent()) {
            throw new IllegalStateException("accountnumber taken");
        }
        clientRepository.save(client);

    }

    public void removeClient(Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            throw new IllegalStateException("client with id " + clientId + " does not exists");
        }
        clientRepository.deleteById(clientId);
    }

    public double getBalance(Long clientId) {
        return clientRepository.findBalanceByClientId(clientId);
    }

    public void depositMoney(Long clientId, double amount) {
        if (amount <= 0.0) {
            throw new IllegalStateException("amount has to be greater than 0");
        }
        clientRepository.addMoneyByClientId(clientId,amount);
    }

    public void withdrawMoney(Long clientId, double amount) {
        if (amount <= 0.0) {
            throw new IllegalStateException("amount has to be greater than 0");
        }
        if (clientRepository.findBalanceByClientId(clientId) < amount) {
            throw new IllegalStateException("Not enough money in the account");
        }
        clientRepository.withdrawMoneyByClientId(clientId,amount);
    }

    public void transferMoney(Long clientId, Long destId, double amount) {
        if (amount <= 0.0) {
            throw new IllegalStateException("amount has to be greater than 0");
        }
        if (clientRepository.findBalanceByClientId(clientId) < amount) {
            throw new IllegalStateException("Not enough money in the account");
        }
        if (!clientRepository.existsById(destId)) {
            throw new IllegalStateException("destination clientId doesn't exist");
        }
        clientRepository.withdrawMoneyByClientId(clientId,amount);
        clientRepository.addMoneyByClientId(destId,amount);
    }
}
