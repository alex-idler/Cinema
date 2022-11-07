package org.example.service;

import org.example.model.User;

public interface AdminService {
    boolean adminInterface(User currentUser, OrderService orderService);
}
