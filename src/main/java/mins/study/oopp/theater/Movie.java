package mins.study.oopp.theater;

import lombok.Getter;

@Getter
public class Movie {
    private Long id;

    private String name;
    private String description;

    public Movie(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
