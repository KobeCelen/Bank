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

    @GetMapping()
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @PostMapping
    public void addClient(@RequestBody Client client) {
        clientService.addNewClient(client);
    }

    @DeleteMapping(path = "{clientId}")
    public void removeClient(@PathVariable("clientId") Long clientId) {
        clientService.removeClient(clientId);
    }

    @GetMapping(path = "{clientId}/balance")
    public double getBalance(@PathVariable("clientId") Long clientId) {
        return clientService.getBalance(clientId);
    }

    @PutMapping(path = "{clientId}/deposit/{amount}")
    public void depositMoney(@PathVariable Long clientId, @PathVariable double amount) {
        clientService.depositMoney(clientId, amount);
    }
}
