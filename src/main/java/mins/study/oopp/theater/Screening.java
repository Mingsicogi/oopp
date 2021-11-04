package mins.study.oopp.theater;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 상영관
 *
 */
@Getter
@NoArgsConstructor
public class Screening {

    private Long id;

    private Movie movie;
    private ScreeningType type;

    private Integer price;

    private Integer numberOfSeats;

    public Screening(Movie movie, ScreeningType type, Integer price, Integer numberOfSeats) {
        this.movie = movie;
        this.type = type;
        this.price = price;
        this.numberOfSeats = numberOfSeats;
    }
}
