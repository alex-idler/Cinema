package org.example.service;

import org.example.model.User;

import java.util.Map;

public interface AdminService {
    boolean adminInterface(User currentUser, OrderService orderService, Map<String, User> users);
}
