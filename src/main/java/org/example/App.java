package org.example;

import org.example.model.Role;
import org.example.model.User;
import org.example.service.AdminServiceImp;
import org.example.service.LoginServiceImp;
import org.example.service.OrderServiceImp;
import org.example.service.UserServiceImp;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        System.out.println("-- Welcome to the Cinema --");
        Map<String, User> users = new HashMap<>();
        users.put("admin", new User("admin", "1", Role.ADMIN));
        users.put("user", new User("user", "1", Role.USER));

        OrderServiceImp orderService = new OrderServiceImp();       //todo сменить на интерфейс
        LoginServiceImp loginService = new LoginServiceImp();       //todo сменить на интерфейс
        loginService.login(users, orderService);

    }
}
