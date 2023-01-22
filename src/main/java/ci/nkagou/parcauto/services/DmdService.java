package ci.nkagou.parcauto.services;

import ci.nkagou.parcauto.dtos.dmd.DmdParcDto;
import ci.nkagou.parcauto.dtos.dmd.DmdParcDtoOut;
import ci.nkagou.parcauto.dtos.dmd.DmdUserDto;
import ci.nkagou.parcauto.dtos.dmd.DmdUserDtoOut;
import ci.nkagou.parcauto.entities.Dmd;
import ci.nkagou.parcauto.entities.Employe;
import ci.nkagou.parcauto.entities.EmployeDmd;

import java.util.List;

public interface DmdService {

    DmdUserDtoOut dmdUserToDto(EmployeDmd employeDmd);
    DmdParcDtoOut dmdParcToDto(EmployeDmd employeDmd);
    List<DmdUserDtoOut> listDmdsToDto(List<EmployeDmd> dmds);
    List<DmdParcDtoOut> listDmdsParcToDto(List<EmployeDmd> dmds);
    List<EmployeDmd> all();
    EmployeDmd findById(Long id);
    List<EmployeDmd> findEmployeDmdsByEmploye(Employe employe);
    EmployeDmd createDmdUser (DmdUserDto dto);
    EmployeDmd createDmdParc (DmdParcDto dto);
    EmployeDmd updateDmdUser (DmdUserDto dto);
    EmployeDmd updateDmdParc (DmdParcDto dto);
    void delete(EmployeDmd employeDmd);
}
