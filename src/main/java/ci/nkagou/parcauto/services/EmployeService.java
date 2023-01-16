package ci.nkagou.parcauto.services;

import ci.nkagou.parcauto.entities.Employe;

import java.util.List;

public interface EmployeService {

    List<Employe> all();
    Employe findById(Long id);
    Employe findByMatricule(Long matricule);
    Employe findByEmail(String email);
    Employe create (Employe employe);
    Employe update (Employe employe);
    void delete(Employe employe);

    String getNomComplet(Employe employe);
}
