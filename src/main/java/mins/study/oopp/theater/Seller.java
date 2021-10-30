package mins.study.oopp.theater;

import mins.study.oopp.customer.Customer;
import mins.study.oopp.customer.PayMethod;

/**
 * 판매자
 *
 */
public class Seller {
    private Employee employee;

    public Seller(Employee employee) {
        this.employee = employee;
    }

    public Ticket sellTicket(Ticket ticketToBuy, Customer customer, PayMethod payMethod) {
        
        customer.pay(payMethod, ticketToBuy.getPrice());

        return ticketToBuy;
    }
}
