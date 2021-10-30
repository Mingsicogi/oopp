package mins.study.oopp.customer;

import lombok.Getter;
import mins.study.oopp.theater.Ticket;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    @Getter
    private List<Ticket> ticket = new ArrayList<>();

    public void hasTicket(Ticket ticket) {
        this.ticket.add(ticket);
    }

    public void pay(PayMethod payMethod, Integer price) {
        System.out.println("### " + price + " has been paid. (pay method : " + payMethod + ")");
    }
}
