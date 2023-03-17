package com.example.Bank.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // show a list of all clients in the database with all the information
    @GetMapping()
    public List<Client> getClients() {
        return clientService.getClients();
    }

    // create new client
    @PostMapping
    public void addClient(@RequestBody Client client) {
        clientService.addNewClient(client);
    }

    // delete client
    @DeleteMapping(path = "{clientId}")
    public void removeClient(@PathVariable("clientId") Long clientId) {
        clientService.removeClient(clientId);
    }

    // get the balance of the account
    @GetMapping(path = "{clientId}/balance")
    public double getBalance(@PathVariable("clientId") Long clientId) {
        return clientService.getBalance(clientId);
    }

    // deposit money on the account
    @PutMapping(path = "{clientId}/deposit/{amount}")
    public void depositMoney(@PathVariable Long clientId, @PathVariable double amount) {
        clientService.depositMoney(clientId, amount);
    }

    // withdraw money from the account
    @PutMapping(path = "{clientId}/withdraw/{amount}")
    public void withdrawMoney(@PathVariable Long clientId, @PathVariable double amount) {
        clientService.withdrawMoney(clientId, amount);
    }

    // transfer money from clientId to destId
    @PutMapping(path = "{clientId}/transfer/{destId}/{amount}")
    public void transferMoney(@PathVariable Long clientId, @PathVariable Long destId, @PathVariable double amount) {
        clientService.transferMoney(clientId, destId, amount);
    }
}
