package ci.nkagou.parcauto.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attribution_vehicule")
/*@Table(name = "visites_techniques", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "VIGNETTE_UK", columnNames = "numVignette") })*/
public class Attribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAttribution;

    private LocalDate dateAttribution;

    @ManyToOne
    @JoinColumn(name = "idEmployé")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "idDmd")
    private Dmd dmd;

    @ManyToOne
    @JoinColumn(name = "idVehicule")
    private Vehicule vehicule;


}
