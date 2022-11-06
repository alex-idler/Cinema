package org.example.model;

public class Ticket {
    private User owner;
    private Session session;

    public Ticket(User owner, Session session) {
        this.owner = owner;
        this.session = session;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
