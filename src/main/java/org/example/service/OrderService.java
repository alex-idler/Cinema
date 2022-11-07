package org.example.service;

import org.example.model.*;
public interface OrderService {
    void printSessions();
    void printUserHelp();
    void printAdminHelp();
    void printTickets(User currentUser);
    void printAllTickets();
    void printAllMovies();
    void buyTicket(User currentUser);
    void cancelTicket(User currentUser);
    void addMovie();
    void removeMovie();
    void addSession();
    void removeSession();
}
