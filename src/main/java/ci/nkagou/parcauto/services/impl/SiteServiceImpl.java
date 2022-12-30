package ci.nkagou.parcauto.services.impl;

import ci.nkagou.parcauto.entities.Site;
import ci.nkagou.parcauto.repositories.SiteRepository;
import ci.nkagou.parcauto.services.SiteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class SiteServiceImpl implements SiteService {

    private SiteRepository siteRepository;


    @Override
    public List<Site> all() {
        return siteRepository.findAll();
    }

    @Override
    public Site getById(Long id) {
        return siteRepository.getById(id);
    }

    @Override
    public Site findByLibelle(String libelle) {
        return siteRepository.findByLibelle(libelle);
    }

    @Override
    public Site create(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public Site update(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public void delete(Site site) {
        siteRepository.delete(site);
    }
}
