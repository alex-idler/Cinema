package org.example.service;

import org.example.model.User;

import java.util.Map;

public interface LoginService {
    void login(Map<String, User> users, OrderService orderService);
}
