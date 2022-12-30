package ci.nkagou.parcauto.repositories;

import ci.nkagou.parcauto.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository  extends JpaRepository <Employe, Long> {

    Employe findByNumMatEmpl (Long matricule);
    Employe findByEmail(String email);
}
