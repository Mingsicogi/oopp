package mins.study.oopp.ticket;

import lombok.Getter;
import mins.study.oopp.theater.ScreeningSchedule;

/**
 * 영화표
 *
 */
@Getter
public class Ticket {
    private Long id;

    private ScreeningSchedule screeningSchedule;

    public Ticket(ScreeningSchedule screeningSchedule) {
        this.screeningSchedule = screeningSchedule;
    }
}
