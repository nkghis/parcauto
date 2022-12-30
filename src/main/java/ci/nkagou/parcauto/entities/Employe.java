package ci.nkagou.parcauto.entities;

import ci.nkagou.parcauto.enums.Genre;
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

@Table(name = "employes", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "EMPLOYE_MATRICULE_UK", columnNames = "numMatEmpl"),
                @UniqueConstraint(name = "EMPLOYE_EMAIL_UK", columnNames = "email"),
        })
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;

    @Column(unique = true)
    private Long numMatEmpl;

    private String nom;
    private String prenom;

    //employe.setGenre(Genre.MASCULIN);
    @Enumerated(EnumType.ORDINAL)
    private Genre genre;

    private String fonction;
    private LocalDate dateEmbauche;

    @Column(unique = true)
    private String email;


    private String telephoneEmploye;
    private LocalDate dateNaissance;
    private boolean estSuperieureHierachique;
    private boolean estChauffeur;

    @ManyToOne
    @JoinColumn(name = "idSite")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "idDirection")
    private Direction direction;


}
