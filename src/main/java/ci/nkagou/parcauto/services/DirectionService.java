package ci.nkagou.parcauto.services;


import ci.nkagou.parcauto.entities.Direction;
import ci.nkagou.parcauto.entities.Employe;
import ci.nkagou.parcauto.entities.Site;

import java.util.List;

public interface DirectionService {

    List<Direction> all();
    Direction getById(Long id);
    Direction findByLibelle(String libelle);
    Direction create (Direction direction);
    Direction update (Direction direction);
    void delete(Direction direction);

}
