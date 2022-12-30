package ci.nkagou.parcauto.services;

import ci.nkagou.parcauto.entities.Employe;
import ci.nkagou.parcauto.entities.Site;

import java.util.List;

public interface SiteService {

    List<Site> all();
    Site getById(Long id);
    Site findByLibelle(String libelle);
    Site create (Site site);
    Site update (Site site);

    void delete(Site site);
}
