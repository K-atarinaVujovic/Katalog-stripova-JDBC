package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Serijal {
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String naslov;
}
