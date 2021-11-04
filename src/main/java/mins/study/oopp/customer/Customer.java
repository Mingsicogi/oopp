package mins.study.oopp.customer;

import lombok.Getter;
import mins.study.oopp.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    @Getter
    private List<Ticket> ticket = new ArrayList<>();

    public void hasTicket(Ticket ticket) {
        this.ticket.add(ticket);
    }

    public void returnTicket(Ticket ticket) {
        this.ticket.remove(ticket);
    }

    public void pay(Integer price) {
        System.out.println("### " + price + " has been paid.");
    }

    public void cancelPay(Integer price) {
        System.out.println("### " + price + " has been canceled.");
    }
}
