package ch16.practice0507.practice01.framework;

public abstract class Ticket {
    protected String name;
    public Ticket(String name) {
        this.name = name;
    }

    public abstract void enter();

    @Override
    public String toString() {
        return "[MetaMonTicket:" + name + "]";
    }
}
