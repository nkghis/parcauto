package ci.nkagou.parcauto.services;

import ci.nkagou.parcauto.entities.Direction;
import ci.nkagou.parcauto.entities.Employe;

import java.util.List;

public interface EmployeService {

    List<Employe> all();
    Employe getById(Long id);
    Employe findByMatricule(Long matricule);
    Employe findByEmail(String email);
    Employe create (Employe employe);
    Employe update (Employe employe);
    void delete(Employe employe);
}
