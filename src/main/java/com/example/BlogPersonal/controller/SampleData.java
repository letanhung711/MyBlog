package com.example.BlogPersonal.controller;

import com.example.BlogPersonal.model.Role;
import com.example.BlogPersonal.model.User;
import com.example.BlogPersonal.repository.RoleRepository;
import com.example.BlogPersonal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class SampleData implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public void run(String... args) throws Exception {
        addUser();
        addRoleAdmin();
    }
    private void addRoleAdmin(){
        if (!roleRepository.existsByName("ADMIN")){
            Role roleAdmin = new Role();
            roleAdmin.setName("ADMIN");
            roleRepository.save(roleAdmin);
        }
    }
    private void addUser() throws ParseException {
        if (!userRepository.existsByFullName("Lê Tấn Hưng")) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            User users = new User();
            users.setFullName("Lê Tấn Hưng");
            users.setBirthdate(dateFormat.parse("2024-01-05"));
            users.setAddress("Tiền Giang");
            users.setEmail("letanhung@gmail.com");
            users.setUsername("admin");
            users.setPassword(passwordEncoder.encode("123Aa"));
            users.setCreate_time(timestamp);
            userRepository.save(users);
        }
    }
}
