package com.example.usermanagement.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.usermanagement.entity.Role;
import com.example.usermanagement.repository.RoleRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadRoles(RoleRepository roleRepository) {
        return args -> {

            if (roleRepository.count() == 0) {

                Role admin = new Role();
                admin.setName("ADMIN");

                Role manager = new Role();
                manager.setName("MANAGER");

                Role user = new Role();
                user.setName("USER");

                roleRepository.save(admin);
                roleRepository.save(manager);
                roleRepository.save(user);
            }
        };
    }
}