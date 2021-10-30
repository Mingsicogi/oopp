package mins.study.oopp.theater;

import mins.study.oopp.customer.Customer;
import mins.study.oopp.customer.PayMethod;

/**
 * 판매자
 *
 */
public class TicketSeller {

    private Employee employee;
    private TicketManagement ticketManagement;

    public TicketSeller(Employee employee, TicketManagement ticketManagement) {
        this.employee = employee;
        this.ticketManagement = ticketManagement;
    }

    public Ticket sellTicket(Ticket ticketToBuy, Customer customer, PayMethod payMethod) {
        customer.pay(payMethod, ticketToBuy.getPrice());
        ticketManagement.sold(ticketToBuy);

        return ticketToBuy;
    }
}
