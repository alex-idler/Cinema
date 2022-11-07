package org.example.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Session {
    private static int sessionsCount = 0;

    private int id;
    private Movie movie;
    private LocalDateTime dateTime;
    private Set<Ticket> ticketSet;

    public Session(Movie movie, LocalDateTime dateTime) {
        this.movie = movie;
        this.dateTime = dateTime;
        this.ticketSet = new HashSet<>();
        this.id = sessionsCount++;
    }

    public String getInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Session id=" + id + " " + dateTime.format(formatter) + " " + movie.getInfo();
    }

    public void addTicket(Ticket ticket) {
        ticketSet.add(ticket);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Set<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(Set<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
