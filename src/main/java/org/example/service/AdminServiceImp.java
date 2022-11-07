package org.example.service;

import org.example.model.User;

import java.util.Map;
import java.util.Scanner;

public class AdminServiceImp {
    public boolean adminInterface(User currentUser, OrderServiceImp orderService) {   //todo interface
        Scanner in = new Scanner(System.in);
        String command = "";
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
                case "addmovie":
                    orderService.addMovie();
                    break;
                case "addsession":
                    orderService.addSession();
                    break;
                case "logout":
                    return true;
            }
            orderService.printAdminHelp();
        }
        return false;
    }
}
