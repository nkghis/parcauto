package ci.nkagou.parcauto.services.impl;

import ci.nkagou.parcauto.entities.AppUser;
import ci.nkagou.parcauto.entities.Employe;
import ci.nkagou.parcauto.exceptions.ResourceNotFoundException;
import ci.nkagou.parcauto.repositories.EmployeRepository;
import ci.nkagou.parcauto.repositories.UserRepository;
import ci.nkagou.parcauto.services.EmployeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class EmployeServiceImpl implements EmployeService {

    private EmployeRepository employeRepository;
    private UserRepository userRepository;

    @Override
    public List<Employe> all() {
        return employeRepository.findAll();
    }

    @Override
    public Employe findById(Long id) {
        return employeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employé introuvable avec l'identifiant :  " + id)
        );
    }

    @Override
    public List<Employe> findEmployesByEstUtilisateur(Boolean estUtilisateur) {
        return employeRepository.findEmployesByEstUtilisateur(estUtilisateur);
    }

    @Override
    public Employe findByMatricule(Long matricule) {
        return employeRepository.findByNumMatEmpl(matricule);
    }

    @Override
    public Employe findByEmail(String email) {
        return employeRepository.findByEmail(email);
    }

    @Override
    public Employe create(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe update(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe getEmployeByUserName(String username) {
        AppUser user = userRepository.findByUserName(username);
        return user.getEmploye();
    }

    @Override
    public void delete(Employe employe) {
        employeRepository.delete(employe);
    }

    @Override
    public String getNomComplet(Employe employe) {

        String nomComplet = employe.getPrenom() + " " + employe.getNom();
        return nomComplet;
    }
}
