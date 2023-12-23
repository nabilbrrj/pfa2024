package ma.gestion.ecole.GestionEcole.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import ma.gestion.ecole.GestionEcole.Entity.Eleve.Eleve;
import ma.gestion.ecole.GestionEcole.Entity.Professeur.Professeur;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Admin extends UserEntity {
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Tuteur> tuteurList;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Eleve> eleveList;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<Professeur> professeurList;
}
