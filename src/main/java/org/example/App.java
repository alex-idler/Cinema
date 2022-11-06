package org.example;

import org.example.model.Role;
import org.example.model.User;
import org.example.service.AdminServiceImp;
import org.example.service.LoginServiceImp;
import org.example.service.UserServiceImp;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        System.out.println("-- cinema --");
        Map<String, User> users = new HashMap<>();
        users.put("admin", new User("admin", "1", Role.ADMIN));
        users.put("user", new User("user", "1", Role.USER));

        LoginServiceImp loginService = new LoginServiceImp();       //todo сменить на интерфейс
        User currentUser = loginService.login(users);

        if(currentUser.getRole() == Role.ADMIN) {
            AdminServiceImp adminService = new AdminServiceImp();   //todo сменить на интерфейс
            adminService.adminInterface();
        } else if(currentUser.getRole() == Role.USER) {
            UserServiceImp userService = new UserServiceImp();      //todo сменить на интерфейс
            userService.userInterface();
        }
    }
}
