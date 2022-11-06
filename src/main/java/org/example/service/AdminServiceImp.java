package org.example.service;

import java.util.Scanner;

public class AdminServiceImp {
    public void adminInterface() {

        Scanner in = new Scanner(System.in);
        String command = "";
        System.out.println("exit - выход, list - список сеансов");
        while (!(command = in.nextLine().toLowerCase()).equals("exit")) {
            switch (command) {
                case "help":
                    System.out.println("exit - выход, list - список сеансов, order - купить билет");
                    break;
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
