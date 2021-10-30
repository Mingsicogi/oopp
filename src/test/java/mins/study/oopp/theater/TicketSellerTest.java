package mins.study.oopp.theater;

import mins.study.oopp.customer.Customer;
import mins.study.oopp.customer.PayMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class TicketSellerTest {

    @Test
    void sellTicket() {
        // GIVE
        Employee employee = new Employee("minssogi", "010-1234-5678", 20);
        Movie ironMan = new Movie("아이언맨", "로다쥬 나오는 아이언맨 1편임.");
        Theater theater = new Theater(TheaterType.IMAX, 300);

        TheaterSchedule ironManTheaterSchedule = new TheaterSchedule(LocalDateTime.now(), LocalDateTime.now().plusMonths(1L), theater, ironMan);
        Ticket ticket = new Ticket(25_000, ironManTheaterSchedule);

        TicketManagement ticketManagement = new TicketManagement(ticket);

        TicketSeller ticketSeller = new TicketSeller(employee, ticketManagement);

        // WHEN
        Customer customer = new Customer();
        Ticket buyTicket = ticketSeller.sellTicket(ticket, customer, PayMethod.CASH);
        customer.hasTicket(buyTicket);

        // THEN
        Assertions.assertEquals(299, ticketSeller.howManySeats(ticket));
    }
}