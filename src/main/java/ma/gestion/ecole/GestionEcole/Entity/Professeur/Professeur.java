package ma.gestion.ecole.GestionEcole.Entity.Professeur;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gestion.ecole.GestionEcole.Entity.Admin;
import ma.gestion.ecole.GestionEcole.Entity.Matiere;
import ma.gestion.ecole.GestionEcole.Entity.UserEntity;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Professeur extends UserEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL)
    private List<AbscenceProf> absProf;
    @OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL)
    private List<RetardProf> retProf;
    @OneToOne(fetch  = FetchType.LAZY)
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;
}
