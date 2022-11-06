package org.example.service;

import org.example.model.*;

import java.util.List;
import java.util.Scanner;

public class OrderServiceImp {
    private final Cinema cinema = new Cinema();
    private final String USER_HELP_MESSAGE = "exit - выход, list - список сеансов, order - купить билет, tickets - информация о купленных билетах";
    private final String ADMIN_HELP_MESSAGE = "exit - выход, list - список сеансов";
    private final String ORDER_MESSAGE = "Для покупки билета введите ID сеанса или 'exit' для отмены";
    private final String PRINT_TICKETS_ERROR_MESSAGE = "У Вас нет билетов";

    public void printSessions() {
        List<Session> sessionList = cinema.getSessionList();
        for(Session session : sessionList) {
            System.out.println(session.getInfo());
        }
    }

    public void printUserHelp() {
        System.out.println(USER_HELP_MESSAGE);
    }
    public void printAdminHelp() {
        System.out.println(ADMIN_HELP_MESSAGE);
    }
    public void printTickets(User currentUser) {
        if(currentUser.getTicketList() == null) {
            System.out.println(PRINT_TICKETS_ERROR_MESSAGE);
            return;
        }
        for(Ticket ticket : currentUser.getTicketList()) {
            System.out.println(ticket.getSession().getInfo());
        }
    }
    public void buyTicket(User currentUser) {
        printSessions();
        System.out.println(ORDER_MESSAGE);
        Scanner in = new Scanner(System.in);
        String command = "";
        while (!(command = in.next().toLowerCase()).equals("exit")) {
            try {
                Integer i = Integer.valueOf(command);
                System.out.println("=== " + i);
                for(Session session : cinema.getSessionList()) {
                    if (session.getId() == i) {
                        currentUser.addTicket(new Ticket(currentUser, session));
                    }
                }
            }catch (NumberFormatException e) {
                System.out.println(ORDER_MESSAGE);
            }
        }
    }
}
