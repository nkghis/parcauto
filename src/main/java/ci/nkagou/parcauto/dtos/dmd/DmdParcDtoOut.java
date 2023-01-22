package ci.nkagou.parcauto.dtos.dmd;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DmdParcDtoOut {

    private Long id;
    private String datePrevue;
    private String heurePrevue;
    private String moyenDemande;
    private String motif;
    private String destination;
    private String dateOperation;
    private String employe;
    private String statut;

}
