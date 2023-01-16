package ci.nkagou.parcauto.services.impl;

import ci.nkagou.parcauto.dtos.dmd.DmdDtoOut;
import ci.nkagou.parcauto.entities.Dmd;
import ci.nkagou.parcauto.entities.Employe;
import ci.nkagou.parcauto.exceptions.ResourceNotFoundException;
import ci.nkagou.parcauto.repositories.DmdRepository;
import ci.nkagou.parcauto.services.DmdService;
import ci.nkagou.parcauto.services.EmployeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class DmdServiceImpl implements DmdService {

    private DmdRepository dmdRepository;
    private EmployeService employeService;

    @Override
    public DmdDtoOut dmdToDto(Dmd dmd) {

        DmdDtoOut dto = new DmdDtoOut() ;
        dto.setIdDmd(dmd.getIdDmd());
        dto.setDateRemplissageDmd(dmd.getDateRemplissageDmd().toString());
        dto.setHeureDepart(dmd.getHeureDepart().toString());
        dto.setHeureRetour(dmd.getHeureRetour().toString());
        dto.setKmDepart(dmd.getKmDepart());
        dto.setKmRetour(dmd.getKmRetour());
        dto.setMotif(dmd.getMotif());
        /*dto.setMatriculeEmploye(dmd.getEmploye().getNumMatEmpl().toString());
        dto.setNomCompletEmploye(employeService.getNomComplet(dmd.getEmploye()));*/
        return dto;

    }

    @Override
    public List<DmdDtoOut> listDmdsToDto(List<Dmd> dmds) {

        List<DmdDtoOut> dtos = new ArrayList<>();
        for (Dmd dmd : dmds)
        {
            DmdDtoOut dto = new DmdDtoOut();

            dto = this.dmdToDto(dmd);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<Dmd> all() {
        return dmdRepository.findAll();
    }

    @Override
    public Dmd findById(Long id) {
        return dmdRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Dmd introuvable avec l'identifiant :  " + id)
        );
    }



    @Override
    public Dmd getById(Long id) {
        return dmdRepository.getById(id);
    }

   /* @Override
    public List<Dmd> findByMotif(MotifDmd motif) {
        return dmdRepository.findDmdsByMotifDmd(motif);
    }*/

    @Override
    public List<Dmd> findDmdsByHeureDepart(LocalDateTime dateEtHeure) {
        return dmdRepository.findDmdsByHeureDepart(dateEtHeure);
    }

    @Override
    public List<Dmd> findDmdsByHeureRetour(LocalDateTime dateEtHeure) {
        return dmdRepository.findDmdsByHeureRetour(dateEtHeure);
    }

   /* @Override
    public List<Dmd> findDmdsByEmploye(Employe employe) {
        return dmdRepository.findDmdsByEmploye(employe);
    }*/

    @Override
    public Dmd create(Dmd dmd) {
        return dmdRepository.save(dmd);
    }

    @Override
    public Dmd update(Dmd dmd) {
        return dmdRepository.save(dmd);
    }

    @Override
    public void delete(Dmd dmd) {
        dmdRepository.delete(dmd);
    }
}
