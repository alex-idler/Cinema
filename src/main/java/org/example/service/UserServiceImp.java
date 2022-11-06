package org.example.service;

import org.example.model.Cinema;
import org.example.model.Session;

import java.util.List;
import java.util.Scanner;

public class UserServiceImp {
    Cinema cinema = new Cinema();

    public void userInterface() {
        Scanner in = new Scanner(System.in);
        String command = "";
        System.out.println("exit - выход, list - список сеансов, order - купить билет");
        while (!(command = in.next().toLowerCase()).equals("exit")) {
            switch (command) {
                case "help":
                    System.out.println("exit - выход, list - список сеансов, order - купить билет");
                    break;
                case "list":
                    List<Session> sessionList = cinema.getSessionList();
                    for(Session session : sessionList) {
                        System.out.println(session.getInfo());
                    }
                    break;
                case "order":
                    System.out.println("pokupka bileta");
                    break;
                default:
                    System.out.println("exit - выход, list - список сеансов, order - купить билет");
            }
        }
        in.close();
    }
}
