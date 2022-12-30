package ci.nkagou.parcauto.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "dmds")
public class Dmd {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDmd;

    private LocalDateTime dateRemplissageDmd;
    private String motifDmd;
    private LocalDateTime heureDepart;
    private LocalDateTime heureRetour;
    private int  kmDepart;
    private int kmRetour;
}
