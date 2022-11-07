package org.example.service;

import org.example.model.User;
import java.util.Scanner;

public class UserServiceImp implements UserService {

    @Override
    public boolean userInterface(User currentUser, OrderService orderService) {
        Scanner in = new Scanner(System.in);
        String command;
        orderService.printUserHelp();
        while (!(command = in.next().toLowerCase()).equals("exit")) {
            switch (command) {
                case "list":
                    orderService.printSessions();
                    break;
                case "tickets":
                    orderService.printTickets(currentUser);
                    break;
                case "order":
                    orderService.buyTicket(currentUser);
                    break;
                case "cancel":
                    orderService.cancelTicket(currentUser);
                    break;
                case "logout":
                    return true;
            }
            orderService.printUserHelp();
        }
        return false;
    }
}
