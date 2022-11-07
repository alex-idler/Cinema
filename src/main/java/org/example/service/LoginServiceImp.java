package org.example.service;

import org.example.model.Role;
import org.example.model.User;
import java.util.Map;
import java.util.Scanner;

public class LoginServiceImp implements LoginService {
    private final String ERROR_MESSAGE = "Неверные данные, повторите ввод";

    @Override
    public void login(Map<String, User> users, OrderService orderService) {
        Scanner in = new Scanner(System.in);
        boolean isLogout = false;
        User currentUser = null;
        while (currentUser == null || isLogout) {
            System.out.print("login: ");
            String login = in.next();
            System.out.print("password: ");
            String password = in.next();
            if(users.get(login) != null && users.get(login).getPassword().equals(password)) {
                currentUser = users.get(login);
                if(currentUser.getRole() == Role.ADMIN) {
                    AdminService adminService = new AdminServiceImp();
                    isLogout = adminService.adminInterface(currentUser, orderService);
                } else if(currentUser.getRole() == Role.USER) {
                    UserService userService = new UserServiceImp();
                    isLogout = userService.userInterface(currentUser, orderService);
                }
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        }
        in.close();
    }
}
