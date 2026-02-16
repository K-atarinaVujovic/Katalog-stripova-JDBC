package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

// filtrirano po serijalima koji imaju vise od jednog stripa
// sortirano descending po broju stripova
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SerijalStatsDTO {
    private String naslov;
    private List<String> glavniAutori;
    private int brojStripova;
    private int brojDelovaPoStripu;
}

