package ci.nkagou.parcauto.services.impl;

import ci.nkagou.parcauto.entities.Employe;
import ci.nkagou.parcauto.repositories.EmployeRepository;
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

    @Override
    public List<Employe> all() {
        return employeRepository.findAll();
    }

    @Override
    public Employe getById(Long id) {
        return employeRepository.getById(id);
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
    public void delete(Employe employe) {
        employeRepository.delete(employe);
    }
}
