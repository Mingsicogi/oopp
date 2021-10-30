package mins.study.oopp.theater;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TheaterSchedule {
    private Long id;

    private LocalDateTime startTme;
    private LocalDateTime endTime;

    private Theater theater;
    private Movie movie;
    private Integer availableNumberOfSeats;

    public TheaterSchedule(LocalDateTime startTme, LocalDateTime endTime, Theater theater, Movie movie) {
        this.startTme = startTme;
        this.endTime = endTime;
        this.theater = theater;
        this.movie = movie;
        this.availableNumberOfSeats = theater.getNumberOfSeats();
    }
}
