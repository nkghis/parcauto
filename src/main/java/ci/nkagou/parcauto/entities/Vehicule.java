package ci.nkagou.parcauto.entities;

import ci.nkagou.parcauto.enums.Couleur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vehicules", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "VEHICULE_UK", columnNames = "immatriculation") })
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @Column(unique = true)
    private String immatriculation;

    //vehicule.setCouleur(Couleur.JAUNE);
    @Enumerated(EnumType.ORDINAL)
    private Couleur couleur;
    private LocalDate dateAchat;
    private String carteGrise;

    @ManyToOne
    @JoinColumn(name = "idMarque")
    private Marque marque;

    @ManyToOne
    @JoinColumn(name ="idTypeVehicule")
    private Typevehicule typevehicule;

}
