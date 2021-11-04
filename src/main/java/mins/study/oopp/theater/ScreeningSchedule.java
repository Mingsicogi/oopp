package mins.study.oopp.theater;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static mins.study.oopp.constants.CommonConstants.SCREENING_SCHEDULE_TIME_FORMAT;

@Getter
public class ScreeningSchedule {
    private Long id;

    private LocalDateTime startTme;
    private LocalDateTime endTime;

    private Screening screening;
    private Integer availableNumberOfSeats;

    public ScreeningSchedule(LocalDateTime startTme, LocalDateTime endTime, Screening screening) {
        this.startTme = startTme;
        this.endTime = endTime;
        this.screening = screening;
        this.availableNumberOfSeats = screening.getNumberOfSeats();
    }

    public void minusAvailableNumberOfSeats() {
        if (availableNumberOfSeats <= 0) {
            throw new RuntimeException(this.startTme.format(DateTimeFormatter.ofPattern(SCREENING_SCHEDULE_TIME_FORMAT)) + " ~ "
                    + this.endTime.format(DateTimeFormatter.ofPattern(SCREENING_SCHEDULE_TIME_FORMAT)) + this.screening.getMovie().getName() + "는 매진입니다.");
        }
        this.availableNumberOfSeats--;
    }

    public void plusAvailableNumberOfSeats() {
        if (availableNumberOfSeats >= screening.getNumberOfSeats()) {
            throw new RuntimeException("좌석 수를 더이상 늘릴 수 없습니다.");
        }
        this.availableNumberOfSeats++;
    }
}
