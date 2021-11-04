package mins.study.oopp.theater;

import mins.study.oopp.customer.Customer;
import mins.study.oopp.ticket.Ticket;
import mins.study.oopp.ticket.TicketSeller;
import mins.study.oopp.ticket.discount.condition.MorningDiscountCondition;
import mins.study.oopp.ticket.discount.policy.DiscountPolicy;
import mins.study.oopp.ticket.discount.policy.MaxDiscountPolicy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class TicketSellerTest {

    @Test
    void sellTicket() {
        // GIVE
        Employee employee = new Employee("minssogi", "010-1234-5678", 20);
        Movie ironMan = new Movie("아이언맨", "로다쥬 나오는 아이언맨 1편임.");
        Screening screening = new Screening(ironMan, ScreeningType.IMAX, 25_000, 300);

        LocalDateTime startTime = LocalDateTime.of(2021, 12, 6, 9, 0);
        ScreeningSchedule ironManScreeningSchedule = new ScreeningSchedule(startTime, startTime.plusHours(2), screening);
        Ticket ticket = new Ticket(ironManScreeningSchedule);


        TicketSeller ticketSeller = new TicketSeller(employee);

        // WHEN
        Customer customer = new Customer();
        ticketSeller.sellTicket(ticket, customer);

        // THEN
        Assertions.assertEquals(299, ticketSeller.howManySeats(ticket));
        ticketSeller.refundTicket(ticket, customer);
        Assertions.assertEquals(300, ticketSeller.howManySeats(ticket));
    }
}