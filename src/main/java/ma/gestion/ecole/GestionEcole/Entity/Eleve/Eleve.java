package ma.gestion.ecole.GestionEcole.Entity.Eleve;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.gestion.ecole.GestionEcole.Entity.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Eleve extends UserEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tuteur_id")
    private Tuteur tuteur;
    @OneToMany(mappedBy = "eleve", cascade = CascadeType.ALL)
    private List<AbscenceElev> absEleve;
    @OneToMany(mappedBy = "eleve", cascade = CascadeType.ALL)
    private List<RetardElev> retEleve;
    @ManyToMany
    @JoinTable(name = "eleve_matiere",
            joinColumns = @JoinColumn(name = "eleve_id"),
            inverseJoinColumns = @JoinColumn(name = "matiere_id"))
    private List<Matiere> matieres;
}
