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

@SpringBootApplication
@RestController
public class Main {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
            return args -> {
                Cliente cliente = new Cliente("Jefferson");
                clientes.salvar(cliente);

                Cliente cliente2 = new Cliente("Raquel");
                clientes.salvar(cliente2);
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