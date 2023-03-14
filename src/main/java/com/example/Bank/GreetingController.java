package com.example.Bank;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @GetMapping("/world")
    public String getGreeting(){
        return "Hellow test test";
    }

    @PostMapping("/users")
    public Client createClient(int id, String first_name, String last_name, double balance) {
        return new Client(id,first_name,last_name,balance);
    }


}
