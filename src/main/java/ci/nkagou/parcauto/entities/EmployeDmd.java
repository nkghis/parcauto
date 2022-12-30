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


    @ManyToOne
    @JoinColumn(name ="idEmploye")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name ="idDmd")
    private Dmd dmd;

    private LocalDateTime dateOperation;
}
