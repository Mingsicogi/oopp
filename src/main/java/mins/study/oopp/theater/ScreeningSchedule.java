package mins.study.oopp.theater;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScreeningSchedule {
    private Long id;

    private LocalDateTime startTme;
    private LocalDateTime endTime;

    private Screening screening;
    private Movie movie;
    private Integer availableNumberOfSeats;

    public ScreeningSchedule(LocalDateTime startTme, LocalDateTime endTime, Screening screening, Movie movie) {
        this.startTme = startTme;
        this.endTime = endTime;
        this.screening = screening;
        this.movie = movie;
        this.availableNumberOfSeats = screening.getNumberOfSeats();
    }
}
