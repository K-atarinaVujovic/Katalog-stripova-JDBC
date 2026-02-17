package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Serijal {
    @Getter @Setter
    private String naslov;

    @Getter @Setter
    private int id;

    public Serijal(String naslov){
        this.naslov = naslov;
    }
}
