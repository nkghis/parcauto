package ci.nkagou.parcauto.repositories;

import ci.nkagou.parcauto.entities.Attribution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributionRepository extends JpaRepository<Attribution, Long> {
}
