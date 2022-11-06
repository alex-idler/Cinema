package org.example.model;

import java.util.List;

public class User {
    private String name;
    private String password;
    private Role role;
    private List<Ticket> ticketList;

    public User() {
    }

    public User(String name, String password, Role role) {
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
