package ma.gestion.ecole.GestionEcole.Repository;

import ma.gestion.ecole.GestionEcole.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByLogin(String login);

}
