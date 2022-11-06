package org.example.service;

import org.example.model.User;

import java.util.Map;
import java.util.Scanner;

public class LoginServiceImp {
    public User login(Map<String, User> users) {
        Scanner in = new Scanner(System.in);
        String command = "";
        User currentUser = null;
        while (currentUser == null) {
            System.out.print("login: ");
            String login = in.next();
            System.out.print("password: ");
            String password = in.next();
            if(users.get(login) != null && users.get(login).getPassword().equals(password)) {
                currentUser = users.get(login);
            } else {
                System.out.println("Неверные данные, повторите ввод");
            }
        }
//        in.close();
        return currentUser;
    }
}
