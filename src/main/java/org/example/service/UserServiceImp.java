package org.example.service;

import org.example.model.Cinema;
import org.example.model.Session;
import org.example.model.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserServiceImp {

    public boolean userInterface(User currentUser, OrderServiceImp orderService) {  //todo interface
        Scanner in = new Scanner(System.in);
        String command = "";
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
                case "logout":
                    return true;
            }
            orderService.printUserHelp();
        }
        return false;
    }
}
