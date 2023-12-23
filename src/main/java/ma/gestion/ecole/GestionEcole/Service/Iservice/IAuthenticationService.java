package ma.gestion.ecole.GestionEcole.Service.Iservice;

import ma.gestion.ecole.GestionEcole.dto.LoginDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface IAuthenticationService {
    public Map<Object, Object> loginAndGenerateToken(LoginDTO data);
}
