package ci.nkagou.parcauto.entities;

import ci.nkagou.parcauto.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employe_dmd")
public class EmployeDmd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployeDmd;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="idEmploye", nullable = false)
    private Employe employe;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="idDmd" , nullable = false)
    private Dmd dmd;

    private String Destination;

    private String motifDmd;

    @Enumerated(EnumType.ORDINAL)
    private Statut statut;


}
