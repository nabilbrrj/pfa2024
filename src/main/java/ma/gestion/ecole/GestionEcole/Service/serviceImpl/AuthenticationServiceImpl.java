package ma.gestion.ecole.GestionEcole.Service.serviceImpl;

import lombok.RequiredArgsConstructor;
import ma.gestion.ecole.GestionEcole.Entity.UserEntity;
import ma.gestion.ecole.GestionEcole.Repository.UserRepository;
import ma.gestion.ecole.GestionEcole.Service.Iservice.IAuthenticationService;
import ma.gestion.ecole.GestionEcole.config.JwtTokenProvider;
import ma.gestion.ecole.GestionEcole.dto.LoginDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoded;

    public Map<Object, Object> loginAndGenerateToken(LoginDTO data) {
        String login = data.getLogin();
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                login,
                data.getPassword()
        );
        Authentication authentication = authenticationManager.authenticate(authToken);
        UserEntity userEntity = (UserEntity) authentication.getPrincipal();

        String token = jwtTokenProvider.createToken(authentication);
        Map<Object, Object> model = new HashMap<>();
        model.put("username", login);
        model.put("token", token);
        return model;
    }

    public void createDefaultEleve() {
        UserEntity defalutUser = UserEntity.buildDefaultUserForLoginTest(passwordEncoded);
        String username = defalutUser.getUsername();
        boolean exists = this.userRepository.findByLogin(username).isPresent();
        if (exists) return;
        this.userRepository.save(defalutUser);
    }

}
