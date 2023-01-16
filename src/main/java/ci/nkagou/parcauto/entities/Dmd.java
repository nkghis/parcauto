package ci.nkagou.parcauto.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dmds")
public class Dmd {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDmd;

    private LocalDate dateRemplissageDmd;
    //private String motifDmd;
    private LocalTime heureDepart;
    private LocalTime heureRetour;
    private int  kmDepart;
    private int kmRetour;


    private String motif;

    @OneToMany(mappedBy = "employe", fetch = FetchType.EAGER)
    private List<EmployeDmd> employeDmdList;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "employe_dmd",
            joinColumns = @JoinColumn(name = "idDmd"),
            inverseJoinColumns = @JoinColumn(name = "idEmploye")
    )
    private List<Employe> employes = new ArrayList<>();

    public Dmd(LocalDate dateRemplissageDmd, LocalTime heureDepart, LocalTime heureRetour, int kmDepart, int kmRetour, String motif, List<Employe> employes) {
        this.dateRemplissageDmd = dateRemplissageDmd;
        this.heureDepart = heureDepart;
        this.heureRetour = heureRetour;
        this.kmDepart = kmDepart;
        this.kmRetour = kmRetour;
        this.motif = motif;
        this.employes = employes;
    }

    public Dmd(Long idDmd, LocalDate dateRemplissageDmd, LocalTime heureDepart, LocalTime heureRetour, int kmDepart, int kmRetour, String motif, List<EmployeDmd> employeDmdList) {
        this.idDmd = idDmd;
        this.dateRemplissageDmd = dateRemplissageDmd;
        this.heureDepart = heureDepart;
        this.heureRetour = heureRetour;
        this.kmDepart = kmDepart;
        this.kmRetour = kmRetour;
        this.motif = motif;
        this.employeDmdList = employeDmdList;
    }
}
