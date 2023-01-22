package ci.nkagou.parcauto.services.impl;

import ci.nkagou.parcauto.dtos.dmd.DmdParcDto;
import ci.nkagou.parcauto.dtos.dmd.DmdParcDtoOut;
import ci.nkagou.parcauto.dtos.dmd.DmdUserDto;
import ci.nkagou.parcauto.dtos.dmd.DmdUserDtoOut;
import ci.nkagou.parcauto.entities.Dmd;
import ci.nkagou.parcauto.entities.Employe;
import ci.nkagou.parcauto.entities.EmployeDmd;
import ci.nkagou.parcauto.enums.MoyenDemande;
import ci.nkagou.parcauto.enums.Statut;
import ci.nkagou.parcauto.exceptions.ResourceNotFoundException;
import ci.nkagou.parcauto.repositories.DmdRepository;
import ci.nkagou.parcauto.repositories.EmployeDmdRepository;
import ci.nkagou.parcauto.services.DmdService;
import ci.nkagou.parcauto.services.EmployeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class DmdServiceImpl implements DmdService {

    private DmdRepository dmdRepository;
    private EmployeService employeService;
    private EmployeDmdRepository employeDmdRepository;

    @Override
    public DmdUserDtoOut dmdUserToDto(EmployeDmd dmd) {

        DmdUserDtoOut dto = new DmdUserDtoOut() ;
        dto.setId(dmd.getIdEmployeDmd());
        dto.setDatePrevue(dmd.getDmd().getDatePrevue().toString());
        dto.setHeurePrevue(dmd.getDmd().getHeurePrevue().toString());
        dto.setMoyenDemande(dmd.getDmd().getMoyenDemande().name());
        dto.setMotif(dmd.getMotifDmd());
        dto.setDestination(dmd.getDestination());
        dto.setDateOperation(dmd.getDmd().getDateOperation().toString());
        dto.setStatut(dmd.getStatut().name());
        /*dto.setMatriculeEmploye(dmd.getEmploye().getNumMatEmpl().toString());
        dto.setNomCompletEmploye(employeService.getNomComplet(dmd.getEmploye()));*/
        return dto;

    }

    @Override
    public DmdParcDtoOut dmdParcToDto(EmployeDmd dmd) {
        DmdParcDtoOut dto= new DmdParcDtoOut();
        dto.setId(dmd.getIdEmployeDmd());
        dto.setDatePrevue(dmd.getDmd().getDatePrevue().toString());
        dto.setHeurePrevue(dmd.getDmd().getHeurePrevue().toString());
        dto.setMoyenDemande(dmd.getDmd().getMoyenDemande().name());
        dto.setMotif(dmd.getMotifDmd());
        dto.setDestination(dmd.getDestination());
        dto.setDateOperation(dmd.getDmd().getDateOperation().toString());
        dto.setStatut(dmd.getStatut().name());
        dto.setEmploye(dmd.getEmploye().toNomComplet());
        return dto;
    }

    @Override
    public List<DmdUserDtoOut> listDmdsToDto(List<EmployeDmd> dmds) {

        List<DmdUserDtoOut> dtos = new ArrayList<>();
        for (EmployeDmd dmd : dmds)
        {
            DmdUserDtoOut dto = new DmdUserDtoOut();

            dto = this.dmdUserToDto(dmd);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<DmdParcDtoOut> listDmdsParcToDto(List<EmployeDmd> dmds) {
        List<DmdParcDtoOut> dtos = new ArrayList<>();
        for (EmployeDmd dmd : dmds)
        {
            DmdParcDtoOut dto = new DmdParcDtoOut();

            dto = this.dmdParcToDto(dmd);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<EmployeDmd> all() {
        return employeDmdRepository.findAll();
    }

    @Override
    public EmployeDmd findById(Long id) {
        return employeDmdRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Dmd introuvable avec l'identifiant :  " + id)
        );
    }

    @Override
    public List<EmployeDmd> findEmployeDmdsByEmploye(Employe employe) {
        return employeDmdRepository.findEmployeDmdsByEmploye(employe);
    }


    @Override
    public EmployeDmd createDmdUser(DmdUserDto dto) {

        //Initit Dmd
        Dmd dmd = new Dmd();

        //Set Value
        dmd.setDatePrevue(dto.getDatePrevue());
        dmd.setHeurePrevue(dto.getHeurePrevue());
        dmd.setMoyenDemande(MoyenDemande.valueOf(dto.getMoyenDemande()));
        dmd.setDateOperation(LocalDateTime.now());
        //Create Dmd on Database.
        Dmd dmdPersist = dmdRepository.save(dmd);

        //Set Value
        EmployeDmd employeDmd = new EmployeDmd();
        employeDmd.setDestination(dto.getDestination());
        employeDmd.setMotifDmd(dto.getMotif());
        employeDmd.setStatut(Statut.DEMANDE);
        employeDmd.setDmd(dmdPersist);
        employeDmd.setEmploye(dto.getEmploye());

        //Create EmployeDmd on Database.
        employeDmdRepository.save(employeDmd);

        return employeDmd;
    }

    @Override
    public EmployeDmd createDmdParc(DmdParcDto dto) {
        return null;
    }

    @Override
    public EmployeDmd updateDmdUser(DmdUserDto dto) {

        EmployeDmd employeDmd = this.findById(dto.getId());
        Dmd dmd = dmdRepository.getById(employeDmd.getDmd().getIdDmd());
        dmd.setDatePrevue(dto.getDatePrevue());
        dmd.setHeurePrevue(dto.getHeurePrevue());
        dmd.setDateOperation(LocalDateTime.now());
        dmd.setMoyenDemande(MoyenDemande.valueOf(dto.getMoyenDemande()));
        dmdRepository.save(dmd);


        employeDmd.setMotifDmd(dto.getMotif());
        employeDmd.setDestination(dto.getDestination());

        return employeDmdRepository.save(employeDmd);
    }

    @Override
    public EmployeDmd updateDmdParc(DmdParcDto dto) {
        return null;
    }

    @Override
    public void delete(EmployeDmd employeDmd) {

        employeDmdRepository.delete(employeDmd);
    }
}
