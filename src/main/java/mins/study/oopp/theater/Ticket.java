package mins.study.oopp.theater;

import lombok.Getter;

/**
 * 영화표
 *
 */
@Getter
public class Ticket {
    private Long id;

    private Integer price;
    private ScreeningSchedule screeningSchedule;

    public Ticket(Integer price, ScreeningSchedule screeningSchedule) {
        this.price = price;
        this.screeningSchedule = screeningSchedule;
    }
}
