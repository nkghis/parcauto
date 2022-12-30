package ci.nkagou.parcauto.repositories;

import ci.nkagou.parcauto.entities.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository  extends JpaRepository<Vehicule, Long> {
}
