package ci.nkagou.parcauto.services;

import ci.nkagou.parcauto.dtos.dmd.DmdDtoOut;
import ci.nkagou.parcauto.entities.Dmd;

import java.time.LocalDateTime;
import java.util.List;

public interface DmdService {

    DmdDtoOut dmdToDto (Dmd dmd);
    List<DmdDtoOut> listDmdsToDto(List<Dmd> dmds);
    List<Dmd> all();

    Dmd findById(Long id);

    Dmd getById(Long id);
   // List<Dmd> findByMotif(MotifDmd motif);
    List<Dmd> findDmdsByHeureDepart(LocalDateTime dateEtHeure);
    List<Dmd> findDmdsByHeureRetour(LocalDateTime dateEtHeure);
   // List<Dmd> findDmdsByEmploye(Employe employe);
    Dmd create (Dmd dmd);
    Dmd update (Dmd dmd);
    void delete(Dmd dmd);
}
