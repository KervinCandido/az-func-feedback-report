package br.com.fiap.techchallenge;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
    public String greeting(String name) {
        return "Guten Tag " + name;
    }
}
