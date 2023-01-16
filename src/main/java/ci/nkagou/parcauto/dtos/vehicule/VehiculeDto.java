package ci.nkagou.parcauto.dtos.vehicule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class VehiculeDto {

  @NotNull
  @Size(min=2, max=30)
    private String immatriculation;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAchat;

    @NotNull
    private String couleur;

    @NotNull
    private String carteGrise;

    @NotNull
    private Long marque;

    @NotNull
    private Long typeVehicule;
}
