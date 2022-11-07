package org.example;

import org.example.model.Role;
import org.example.model.User;
import org.example.service.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        System.out.println("-- Welcome to the Cinema -- [login 'admin' pass '1' OR login 'user' pass '1']");
        Map<String, User> users = new HashMap<>();
        users.put("admin", new User("admin", "1", Role.ADMIN));
        users.put("user", new User("user", "1", Role.USER));

        OrderService orderService = new OrderServiceImp();
        LoginService loginService = new LoginServiceImp();
        loginService.login(users, orderService);
    }
}
