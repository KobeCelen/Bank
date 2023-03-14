package com.example.Bank.client;

import org.springframework.stereotype.Service;

import java.util.List;

@Service  // kan ook @Component gebruiken maar Service is specifieker
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }
}
