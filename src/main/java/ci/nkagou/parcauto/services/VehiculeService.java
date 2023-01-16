package ci.nkagou.parcauto.services;

import ci.nkagou.parcauto.dtos.vehicule.VehiculeDto;
import ci.nkagou.parcauto.dtos.vehicule.VehiculeDtoOut;
import ci.nkagou.parcauto.entities.Marque;
import ci.nkagou.parcauto.entities.Typevehicule;
import ci.nkagou.parcauto.entities.Vehicule;
import ci.nkagou.parcauto.enums.Couleur;

import java.time.LocalDate;
import java.util.List;

public interface VehiculeService {

    Vehicule dtoToVehicule(VehiculeDto dto);
    VehiculeDtoOut vehiculeToDto (Vehicule vehicule);
    List<VehiculeDtoOut> listVehiculesToDto(List<Vehicule> vehicules);
    List<Vehicule> all();
    Vehicule findById(Long id);
    Vehicule create (Vehicule vehicule);
    Vehicule update (Vehicule vehicule);
    void delete(Vehicule vehicule);

    Vehicule findByImmatriculation(String immatriculation);
    Vehicule findByCarteGrise(String carteGrise);
    List<Vehicule> findVehiculesByTypevehicule(Typevehicule typevehicule);
    List<Vehicule> findVehiculesByMarque(Marque marque);
    List<Vehicule> findVehiculesByCouleur(Couleur couleur);
    List<Vehicule> findVehiculesByDateAchat(LocalDate dateAchat);
}
