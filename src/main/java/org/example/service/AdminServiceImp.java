package org.example.service;

import org.example.model.User;

import java.util.Map;
import java.util.Scanner;

public class AdminServiceImp {
    public boolean adminInterface(User currentUser) {

        OrderServiceImp orderService = new OrderServiceImp();
        Scanner in = new Scanner(System.in);
        String command = "";
        orderService.printAdminHelp();
        while (!(command = in.next().toLowerCase()).equals("exit")) {
            switch (command) {
                case "list":
                    orderService.printSessions();
                    break;
                case "tickets":
                    orderService.printAllTickets();
                    break;
                case "logout":
                    return true;
            }
            orderService.printAdminHelp();
        }
        in.close();
        return false;
    }
}
