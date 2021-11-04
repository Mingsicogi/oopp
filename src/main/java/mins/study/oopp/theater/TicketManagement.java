package mins.study.oopp.theater;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TicketManagement {
    private Long id;

    private List<ManagementInfo> ticketInfos = new ArrayList<>();

    public TicketManagement(Ticket... tickets) {
        for (Ticket ticket : tickets) {
            ticketInfos.add(new ManagementInfo(ticket));
        }
    }

    public void addTicketInfo(Ticket ticket) {
        ticketInfos.add(new ManagementInfo((ticket)));
    }

    public int numberOfAvailableSeats(Ticket ticket) {
        ManagementInfo ticketManagementInfo = ticketInfos.stream().filter(managementInfo -> managementInfo.getTicket().equals(ticket)).findFirst().orElseThrow(() -> new RuntimeException("판매할 티켓정보가 등록되지 않았습니다."));
        return ticketManagementInfo.getAvailableTickets();
    }

    public void sold(Ticket ticket) {
        ManagementInfo ticketManagementInfo = ticketInfos.stream().filter(managementInfo -> managementInfo.getTicket().equals(ticket)).findFirst().orElseThrow(() -> new RuntimeException("판매할 티켓정보가 등록되지 않았습니다."));
        if (ticketManagementInfo.getAvailableTickets() > 0) {
            ticketManagementInfo.minusAvailableTickets();
        } else {
            throw new RuntimeException("Sold out ticket");
        }
    }

    @Getter
    private class ManagementInfo {
        private Ticket ticket;
        private Integer availableTickets;
        private LocalDate managementDate;

        public ManagementInfo(Ticket ticket) {
            this.ticket = ticket;
            this.availableTickets = ticket.getScreeningSchedule().getAvailableNumberOfSeats();
            this.managementDate = LocalDate.now();
        }

        public void minusAvailableTickets() {
            this.availableTickets--;
        }

        @Override
        public boolean equals(Object o) {
            ManagementInfo that = (ManagementInfo) o;
            return this.ticket.getId().equals(that.ticket.getId());
        }
    }
}
