package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;

@SpringBootApplication
@Slf4j
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    @Profile("!test")
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        log.info("================= Initialization ================");
        return args -> {
            List<Customer> customers = List.of(
                    Customer.builder()
                            .firstName("Gabriell").lastName("Cookman").email("gcookman0@usa.gov").build(),
                    Customer.builder()
                            .firstName("Damita").lastName("Ende").email("dende1@businessweek.com").build(),
                    Customer.builder()
                            .firstName("Reeva").lastName("Troctor").email("rtroctor2@marriott.com").build()
            );
            customerRepository.saveAll(customers);
        };
    }

}
