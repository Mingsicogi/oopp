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
    private MovieSchedule movieSchedule;

    public Ticket(Integer price, MovieSchedule movieSchedule) {
        this.price = price;
        this.movieSchedule = movieSchedule;
    }
}
