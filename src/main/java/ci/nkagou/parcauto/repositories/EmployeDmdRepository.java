package ci.nkagou.parcauto.repositories;

import ci.nkagou.parcauto.entities.Employe;
import ci.nkagou.parcauto.entities.EmployeDmd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeDmdRepository extends JpaRepository<EmployeDmd, Long> {

    List<EmployeDmd> findEmployeDmdsByEmploye(Employe employe);
}
