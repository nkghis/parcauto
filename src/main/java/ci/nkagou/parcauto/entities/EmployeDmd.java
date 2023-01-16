package ci.nkagou.parcauto.entities;

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

    private LocalDateTime dateOperation;

    public EmployeDmd(Employe employe, Dmd dmd, LocalDateTime dateOperation) {
        this.employe = employe;
        this.dmd = dmd;
        this.dateOperation = dateOperation;
    }
}
