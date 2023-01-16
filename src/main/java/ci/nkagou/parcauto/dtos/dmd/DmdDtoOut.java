package ci.nkagou.parcauto.dtos.dmd;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DmdDtoOut {

    private Long idDmd;
    private String dateRemplissageDmd;
    private String heureDepart;
    private String heureRetour;
    private int  kmDepart;
    private int kmRetour;
    private String motif;
    private String matriculeEmploye;
    private String nomCompletEmploye;

}
