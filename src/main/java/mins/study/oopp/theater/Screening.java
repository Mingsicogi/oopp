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

    private Integer numberOfSeats;
    private ScreeningType type;

    public Screening(ScreeningType type, Integer numberOfSeats) {
        this.type = type;
        this.numberOfSeats = numberOfSeats;
    }
}
