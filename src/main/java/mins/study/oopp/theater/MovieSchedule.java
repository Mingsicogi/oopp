package mins.study.oopp.theater;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MovieSchedule {
    private Long id;

    private LocalDateTime startTme;
    private LocalDateTime endTime;

    private Theater theater;
    private Integer availableNumberOfSeats;

    public MovieSchedule(LocalDateTime startTme, LocalDateTime endTime, Theater theater) {
        this.startTme = startTme;
        this.endTime = endTime;
        this.theater = theater;
        this.availableNumberOfSeats = theater.getNumberOfSeats();
    }
}
