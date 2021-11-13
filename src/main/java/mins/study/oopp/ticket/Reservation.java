package mins.study.oopp.ticket;

import lombok.Getter;
import mins.study.oopp.customer.Customer;
import mins.study.oopp.ticket.discount.condition.MorningDiscountCondition;
import mins.study.oopp.ticket.discount.policy.DiscountPolicy;
import mins.study.oopp.ticket.discount.policy.MaxDiscountPolicy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Reservation {
    private Customer customer;
    private List<Ticket> tickets;

    private DiscountPolicy maxDiscountPolicy = new MaxDiscountPolicy(new MorningDiscountCondition());

    public Reservation(Customer customer, Ticket... tickets) {
        this.customer = customer;

        this.availableReservation(tickets);
        for (Ticket ticket : tickets) {
            ticket.getScreeningSchedule().minusAvailableNumberOfSeats();
            customer.pay(maxDiscountPolicy.calculateFinalPrice(ticket.getScreeningSchedule()));
            customer.hasTicket(ticket);
        }
        this.tickets = Arrays.asList(tickets);
    }

    /**
     * 예매가능 여부 체크
     *
     * @param tickets 예약하려는 tickets
     * @return 가능여부
     */
    private void availableReservation(Ticket... tickets) {
        Map<String, Integer> temp = new HashMap<>();
        for (Ticket ticket : tickets) {
            temp.computeIfAbsent(ticket.getScreeningSchedule().getScreening().getMovie().getName(), k -> ticket.getScreeningSchedule().getAvailableNumberOfSeats());

            if (temp.get(ticket.getScreeningSchedule().getScreening().getMovie().getName()) <= 0) {
                throw new RuntimeException(ticket.getScreeningSchedule().getScreening().getMovie().getName() + " Sold out.");
            } else {
                int newValue = temp.get(ticket.getScreeningSchedule().getScreening().getMovie().getName()) - 1;
                temp.put(ticket.getScreeningSchedule().getScreening().getMovie().getName(), newValue);
            }
        }
    }
}
