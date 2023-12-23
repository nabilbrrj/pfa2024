package ma.gestion.ecole.GestionEcole.Entity;

import jakarta.persistence.*;
import lombok.*;
import ma.gestion.ecole.GestionEcole.Entity.Enum.Role;
import ma.gestion.ecole.GestionEcole.Entity.Enum.Sexe;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String pass;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String prenom;

    private String image;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String lieu;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telephone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Role> role;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role
                .stream()
                .map(role -> (GrantedAuthority) role::name)
                .collect(Collectors.toList());
    }
    public static UserEntity buildDefaultUserForLoginTest(PasswordEncoder passwordEncoder){
        return UserEntity.builder()
                .id(null)
                .login("test")
                .pass(passwordEncoder.encode("test"))
                .name("berji")
                .prenom("nabil")
                .role(Arrays.asList(Role.ELEVE))
                .adresse("xxxx")
                .lieu("xxxx")
                .email("xxxx")
                .sexe(Sexe.HOMME)
                .telephone("000000000")
                .image("wwww")
                .build();
    }

    @Override
    public String getPassword() {
        return this.pass;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}