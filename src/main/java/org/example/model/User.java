package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        this.ticketList = new ArrayList<>();
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

    public Ticket getTicketById(int id) {
        for(Ticket ticket : ticketList) {
            if(ticket.getId() ==  id) {
                return ticket;
            }
        }
        return null;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!password.equals(user.password)) return false;
        if (role != user.role) return false;
        return Objects.equals(ticketList, user.ticketList);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + (ticketList != null ? ticketList.hashCode() : 0);
        return result;
    }
}
