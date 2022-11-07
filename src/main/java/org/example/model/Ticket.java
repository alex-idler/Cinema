package org.example.model;

public class Ticket {
    private static int ticketsCount = 0;

    private int id;
    private User owner;
    private Session session;

    public Ticket(User owner, Session session) {
        this.owner = owner;
        this.session = session;
        this.id = ticketsCount++;
        session.addTicket(this);
    }

    public String getInfo() {
        return "Ticket id="+ id + " " + session.getInfo() + " " + owner.getName();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (!owner.equals(ticket.owner)) return false;
        return session.equals(ticket.session);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + owner.hashCode();
        result = 31 * result + session.hashCode();
        return result;
    }
}
