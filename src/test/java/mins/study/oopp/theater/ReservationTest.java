package mins.study.oopp.theater;

import lombok.extern.slf4j.Slf4j;
import mins.study.oopp.customer.Customer;
import mins.study.oopp.ticket.Reservation;
import mins.study.oopp.ticket.Ticket;
import mins.study.oopp.ticket.TicketSeller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

@Slf4j
public class ReservationTest {

    @Test
    void reservation() {
        // GIVE
        Movie ironMan = new Movie("아이언맨", "로다쥬 나오는 아이언맨 1편임.");
        Screening screening = new Screening(ironMan, ScreeningType.IMAX, 25_000, 1);

        LocalDateTime startTime = LocalDateTime.of(2021, 12, 6, 9, 0);
        ScreeningSchedule ironManScreeningSchedule = new ScreeningSchedule(startTime, startTime.plusHours(2), screening);
        Ticket ticket = new Ticket(ironManScreeningSchedule);

        Customer customer = new Customer();

        // WHEN
        Reservation reservation = new Reservation(customer, ticket);

        // THEN
        Employee employee = new Employee("minssogi", "010-1234-5678", 20);
        TicketSeller ticketSeller = new TicketSeller(employee);
        Assertions.assertEquals(0, ticketSeller.howManySeats(ticket));
    }

    @Test
    @DisplayName("매진인 경우")
    void reservation_2() {
        // GIVE
        Movie ironMan = new Movie("아이언맨", "로다쥬 나오는 아이언맨 1편임.");
        Screening screening = new Screening(ironMan, ScreeningType.IMAX, 25_000, 1);

        LocalDateTime startTime = LocalDateTime.of(2021, 12, 6, 9, 0);
        ScreeningSchedule ironManScreeningSchedule = new ScreeningSchedule(startTime, startTime.plusHours(2), screening);
        Ticket ticket1 = new Ticket(ironManScreeningSchedule);
        Ticket ticket2 = new Ticket(ironManScreeningSchedule);

        Customer customer = new Customer();

        // WHEN
        String message = Assertions.assertThrows(RuntimeException.class, () -> {
            Reservation reservation = new Reservation(customer, ticket1, ticket2);
        }).getMessage();
        log.info(message);
    }
}
