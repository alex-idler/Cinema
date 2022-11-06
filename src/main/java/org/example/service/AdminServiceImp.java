package org.example.service;

import org.example.model.User;

import java.util.Scanner;

public class AdminServiceImp {
    public void adminInterface(User currentUser) {

        Scanner in = new Scanner(System.in);
        String command = "";
        System.out.println("exit - выход, list - список сеансов");
        while (!(command = in.nextLine().toLowerCase()).equals("exit")) {
            switch (command) {
                case "list":
                    System.out.println("tut budet spisok filmov");
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
