package org.example.service;

import org.example.model.Cinema;
import org.example.model.Session;
import org.example.model.User;

import java.util.List;
import java.util.Scanner;

public class UserServiceImp {

    OrderServiceImp orderService = new OrderServiceImp(); //todo ----------- change to interface
    public void userInterface(User currentUser) {
        Scanner in = new Scanner(System.in);
        String command = "";
        orderService.printUserHelp();
        while (!(command = in.next().toLowerCase()).equals("exit")) {
            switch (command) {
                case "help":
                    orderService.printUserHelp();
                    break;
                case "list":
                    orderService.printSessions();
                    break;
                case "tickets":
                    orderService.printTickets(currentUser);
                    break;
                case "order":
                    orderService.buyTicket(currentUser);
                    break;
                default:
                    orderService.printUserHelp();
            }
        }
        in.close();
    }


}
