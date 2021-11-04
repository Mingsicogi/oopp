package mins.study.oopp.ticket;

import mins.study.oopp.customer.Customer;
import mins.study.oopp.theater.Employee;
import mins.study.oopp.ticket.discount.condition.MorningDiscountCondition;
import mins.study.oopp.ticket.discount.policy.DiscountPolicy;
import mins.study.oopp.ticket.discount.policy.MaxDiscountPolicy;

/**
 * 판매자
 *
 */
public class TicketSeller {

    private Employee employee;
    private DiscountPolicy maxDiscountPolicy = new MaxDiscountPolicy(new MorningDiscountCondition());

    public TicketSeller(Employee employee) {
        this.employee = employee;
    }

    public void sellTicket(Ticket ticketToBuy, Customer customer) {
        ticketToBuy.getScreeningSchedule().minusAvailableNumberOfSeats();
        customer.pay(maxDiscountPolicy.calculateFinalPrice(ticketToBuy.getScreeningSchedule()));
        customer.hasTicket(ticketToBuy);
    }

    public void refundTicket(Ticket ticketToRefund, Customer customer) {
        ticketToRefund.getScreeningSchedule().plusAvailableNumberOfSeats();
        customer.cancelPay(maxDiscountPolicy.calculateFinalPrice(ticketToRefund.getScreeningSchedule()));
        customer.returnTicket(ticketToRefund);
    }

    public int howManySeats(Ticket ticket) {
        return ticket.getScreeningSchedule().getAvailableNumberOfSeats();
    }
}
