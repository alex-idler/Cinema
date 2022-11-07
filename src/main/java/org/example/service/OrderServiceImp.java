package org.example.service;

import org.example.model.*;

import java.util.List;
import java.util.Scanner;

public class OrderServiceImp {
    private final Cinema cinema;
    private final String USER_HELP_MESSAGE = "exit - выход, list - список сеансов, order - купить билет, " +
            "tickets - информация о купленных билетах, logout - выход";
    private final String ADMIN_HELP_MESSAGE = "exit - выход, list - список сеансов, movies - список фильмов, " +
            "tickets - информация о проданных билетах, addmovie - добавление фильма, logout - выход";
    private final String ORDER_MESSAGE = "Для покупки билета введите ID сеанса, 'exit' для отмены";
    private final String ORDER_SUCCESS_MESSAGE = "Билет оплачен. Для покупки ещё одного введите ID сеанса, 'exit' для выхода в меню";
    private final String PRINT_TICKETS_ERROR_MESSAGE = "У Вас нет билетов";
    private final String PRINT_ALL_TICKETS_ERROR_MESSAGE = "Нет проданных билетов";
    private final String PRINT_ALL_MOVIES_ERROR_MESSAGE = "Нет фильмов";
    private final String ADD_MOVIE_MESSAGE = "Добавление фильма";
    private final String ADD_MOVIE_ERROR_MESSAGE = "Ошибка ввода данных";

    public OrderServiceImp() {
        cinema = new Cinema();
    }

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
        if(currentUser.getTicketList().isEmpty()) {
            System.out.println(PRINT_TICKETS_ERROR_MESSAGE);
            return;
        }
        for(Ticket ticket : currentUser.getTicketList()) {
            System.out.println(ticket.getSession().getInfo());
        }
    }

    public void printAllTickets() {
        if(cinema.getSessionList().isEmpty()) {
            System.out.println(PRINT_ALL_TICKETS_ERROR_MESSAGE);
            return;
        }
        for(Session session : cinema.getSessionList()) {
            if( !session.getTicketSet().isEmpty() ) {
                for(Ticket ticket : session.getTicketSet()) {
                    System.out.println(ticket.getInfo());
                }
            }
        }
    }

    public void printAllMovies() {
        if(cinema.getMovieList().isEmpty()) {
            System.out.println(PRINT_ALL_MOVIES_ERROR_MESSAGE);
            return;
        }
        for(Movie movie : cinema.getMovieList()) {
            System.out.println(movie.getInfoWithId());
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
                for(Session session : cinema.getSessionList()) {
                    if (session.getId() == i) {
                        currentUser.addTicket(new Ticket(currentUser, session));
                        System.out.println(ORDER_SUCCESS_MESSAGE);
                    }
                }
            }catch (NumberFormatException e) {
                System.out.println(ORDER_MESSAGE);
            }
        }
    }

    public void addMovie() {
        System.out.println(ADD_MOVIE_MESSAGE);
        Scanner in = new Scanner(System.in);
        String command = "";

        System.out.print("Название: ");
        String title = in.next();
        System.out.print("Жанр: ");
        String genre = in.next();
        System.out.print("Год выпуска: ");
        try {
            Integer year = Integer.valueOf(in.next());
            cinema.addMovie(title, genre, year);
        }catch (NumberFormatException e) {
            System.out.println(ADD_MOVIE_ERROR_MESSAGE);
        }
    }
}
