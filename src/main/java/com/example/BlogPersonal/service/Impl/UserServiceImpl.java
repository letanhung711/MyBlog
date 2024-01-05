package com.example.BlogPersonal.service.Impl;

import com.example.BlogPersonal.model.User;
import com.example.BlogPersonal.repository.UserRepository;
import com.example.BlogPersonal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User verifyLogin(String username, String password) {
        return null;
    }
}
