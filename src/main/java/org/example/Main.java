package org.example;
import org.example.domain.repositorio.Clientes;
import org.example.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
            return args -> {
                clientes.salvar(new Cliente("Jefferson"));
                clientes.salvar(new Cliente("Raquel"));

                List<Cliente> todosClientes = clientes.obterTodos();
                todosClientes.forEach(System.out::println);
            };

    }

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @GetMapping("/hello")
    public String hello() {
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}