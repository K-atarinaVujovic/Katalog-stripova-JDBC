package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
public class Strip {
    private int id;
    private String naslov;
    private LocalDate datumPocetka;
    private LocalDate datumZavrsetka;

    public Strip(String naslov, LocalDate datumPocetka, LocalDate datumZavrsetka){
        this.naslov = naslov;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
    }
}
