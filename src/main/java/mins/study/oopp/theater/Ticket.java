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
    private TheaterSchedule theaterSchedule;

    public Ticket(Integer price, TheaterSchedule theaterSchedule) {
        this.price = price;
        this.theaterSchedule = theaterSchedule;
    }
}
