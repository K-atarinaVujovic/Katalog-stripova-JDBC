package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Filtrirano po korisniku
// Sortirano descending po broju procitanih delova
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitalacStatsDTO {
    private String naslovStripa;
    private int brojProcitanihDelova;
    private int maxDelova;
}
