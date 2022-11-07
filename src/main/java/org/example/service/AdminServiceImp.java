package org.example.service;

import org.example.model.Role;
import org.example.model.User;

import java.util.Map;
import java.util.Scanner;

public class AdminServiceImp implements AdminService {

    private final String ADD_USER_MESSAGE = "Добавление пользователя";
    private final String ADD_USER_ERROR_MESSAGE = "Ошибка создания пользователя";
    private final String REMOVE_USER_MESSAGE = "Удаление пользователя";
    private final String REMOVE_USER_ERROR_MESSAGE = "Не удалось удалить пользователя";

    @Override
    public boolean adminInterface(User currentUser, OrderService orderService, Map<String, User> users) {
        Scanner in = new Scanner(System.in);
        String command;
        orderService.printAdminHelp();
        while (!(command = in.next().toLowerCase()).equals("exit")) {
            switch (command) {
                case "list":
                    orderService.printSessions();
                    break;
                case "movies":
                    orderService.printAllMovies();
                    break;
                case "tickets":
                    orderService.printAllTickets();
                    break;
                case "am":
                    orderService.addMovie();
                    break;
                case "rm":
                    orderService.removeMovie();
                    break;
                case "as":
                    orderService.addSession();
                    break;
                case "rs":
                    orderService.removeSession();
                    break;
                case "au":
                    addUser(users);
                    break;
                case "ru":
                    removeUser(users);
                    break;
                case "users":
                    printUsers(users);
                    break;
                case "logout":
                    return true;
            }
            orderService.printAdminHelp();
        }
        return false;
    }

    void addUser(Map<String, User> users) {
        System.out.println(ADD_USER_MESSAGE);
        Scanner in = new Scanner(System.in);
        System.out.print("Login: ");
        String login = in.next();
        System.out.print("Password: ");
        String password = in.next();
        System.out.print("Role (1 - admin, 2 - user): ");
        try {
            Integer roleId = Integer.valueOf(in.next());
            if(roleId == 1) {
                users.put(login, new User(login, password, Role.ADMIN));
            } else if(roleId == 2) {
                users.put(login, new User(login, password, Role.USER));
            } else {
                System.out.println(ADD_USER_ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            System.out.println(ADD_USER_ERROR_MESSAGE);
        }
    }

    void removeUser(Map<String, User> users) {
        System.out.println(REMOVE_USER_MESSAGE);
        System.out.println(users.keySet());
        Scanner in = new Scanner(System.in);
        System.out.print("Введите логин удаляемого пользователя: ");
        String login = in.next();
        if(users.remove(login) == null) {
            System.out.println(REMOVE_USER_ERROR_MESSAGE);
        }
    }

    void printUsers(Map<String, User> users) {
        System.out.println(users.keySet());
    }
}
