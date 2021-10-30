package mins.study.oopp.theater;

import lombok.Getter;

import java.time.LocalDate;

public class TicketManagement {
    private Long id;

    @Getter
    private Ticket ticket;
    @Getter
    private Integer availableTickets;

    private LocalDate managementDate;

    public TicketManagement(Ticket ticket) {
        this.ticket = ticket;
        this.availableTickets = ticket.getMovieSchedule().getAvailableNumberOfSeats();
        this.managementDate = LocalDate.now();
    }

    public void sold(Ticket ticket) {
        if(availableTickets > 0) {
            this.availableTickets--;
        } else {
            throw new RuntimeException("Sold out ticket");
        }
    }
}
