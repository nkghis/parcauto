package ci.nkagou.parcauto.services.impl;

import ci.nkagou.parcauto.dtos.vehicule.VehiculeDto;
import ci.nkagou.parcauto.dtos.vehicule.VehiculeDtoOut;
import ci.nkagou.parcauto.entities.Marque;
import ci.nkagou.parcauto.entities.Typevehicule;
import ci.nkagou.parcauto.entities.Vehicule;
import ci.nkagou.parcauto.enums.Couleur;
import ci.nkagou.parcauto.exceptions.ResourceNotFoundException;
import ci.nkagou.parcauto.repositories.MarqueRepository;
import ci.nkagou.parcauto.repositories.TypevehiculeRepository;
import ci.nkagou.parcauto.repositories.VehiculeRepository;
import ci.nkagou.parcauto.services.MarqueService;
import ci.nkagou.parcauto.services.TypevehiculeService;
import ci.nkagou.parcauto.services.VehiculeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class VehiculeServiceImpl implements VehiculeService {

    private VehiculeRepository vehiculeRepository;
    private TypevehiculeService typevehiculeService;
    private MarqueService marqueService;

    @Override
    public Vehicule dtoToVehicule(VehiculeDto dto) {

        Vehicule vehicule = new Vehicule();
        Typevehicule typevehicule = typevehiculeService.findById(dto.getMarque());
        Marque marque = marqueService.findById(dto.getMarque());
        Couleur couleur = Couleur.valueOf(dto.getCouleur());
        vehicule.setImmatriculation(dto.getImmatriculation());
        vehicule.setCouleur(couleur);
        vehicule.setDateAchat(dto.getDateAchat());
        vehicule.setCarteGrise(dto.getCarteGrise());
        vehicule.setMarque(marque);
        vehicule.setTypevehicule(typevehicule);
        return vehicule;
    }

    @Override
    public VehiculeDtoOut vehiculeToDto(Vehicule vehicule) {

        VehiculeDtoOut dto = new VehiculeDtoOut();
        dto.setId(vehicule.getIdVehicule());
        dto.setImmatriculation(vehicule.getImmatriculation());
        dto.setCouleur(vehicule.getCouleur().name());
        dto.setCarteGrise(vehicule.getCarteGrise());
        dto.setDateAchat(vehicule.getDateAchat().toString());
        dto.setTypeVehicule(vehicule.getTypevehicule().getLibelle());
        dto.setMarque(vehicule.getMarque().getName());

        return dto;
    }

    @Override
    public List<VehiculeDtoOut> listVehiculesToDto(List<Vehicule> vehicules) {

        List<VehiculeDtoOut> dtos = new ArrayList<>();

        for (Vehicule vehicule : vehicules){

            VehiculeDtoOut dto = new VehiculeDtoOut();
             dto = this.vehiculeToDto(vehicule);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<Vehicule> all() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Vehicule introuvable avec l'identifiant :  " + id)
        );
    }



    @Override
    public Vehicule create(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule update(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void delete(Vehicule vehicule) {
        vehiculeRepository.delete(vehicule);
    }

    @Override
    public Vehicule findByImmatriculation(String immatriculation) {
        return vehiculeRepository.findByImmatriculation(immatriculation);
    }

    @Override
    public Vehicule findByCarteGrise(String carteGrise) {
        return vehiculeRepository.findByCarteGrise(carteGrise);
    }

    @Override
    public List<Vehicule> findVehiculesByTypevehicule(Typevehicule typevehicule) {
        return findVehiculesByTypevehicule(typevehicule);
    }

    @Override
    public List<Vehicule> findVehiculesByMarque(Marque marque) {
        return vehiculeRepository.findVehiculesByMarque(marque);
    }

    @Override
    public List<Vehicule> findVehiculesByCouleur(Couleur couleur) {
        return vehiculeRepository.findVehiculesByCouleur(couleur) ;
    }

    @Override
    public List<Vehicule> findVehiculesByDateAchat(LocalDate dateAchat) {
        return vehiculeRepository.findVehiculesByDateAchat(dateAchat);
    }
}
