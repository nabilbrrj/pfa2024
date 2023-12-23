package ma.gestion.ecole.GestionEcole.Controller;

import lombok.RequiredArgsConstructor;
import ma.gestion.ecole.GestionEcole.Service.Iservice.IAuthenticationService;
import ma.gestion.ecole.GestionEcole.dto.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor

public class AuthenticationController implements IAuthentiationApi{
    private final IAuthenticationService authenticationService;

    @Override

    public ResponseEntity generateToken(@RequestBody LoginDTO data){
        try {
            Map<Object, Object> model = this.authenticationService.loginAndGenerateToken(data);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }
}
