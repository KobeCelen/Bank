package com.example.Bank.client;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // kan ook @Component gebruiken maar Service is specifieker
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
        boolean exists = clientRepository.existsById(clientId);
        if (!exists) {
            throw new IllegalStateException("client with id " + clientId + " does not exists");
        }
        clientRepository.deleteById(clientId);
    }

}
