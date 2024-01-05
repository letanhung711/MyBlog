package com.example.BlogPersonal.service;

import com.example.BlogPersonal.model.User;

public interface UserService {
    User verifyLogin(String username, String password);
}
