package mins.study.oopp.theater;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 상영관
 *
 */
@Getter
@NoArgsConstructor
public class Theater {

    private Long id;

    private Integer numberOfSeats;
    private TheaterType type;

    public Theater(TheaterType type, Integer numberOfSeats) {
        this.type = type;
        this.numberOfSeats = numberOfSeats;
    }
}
