package ma.gestion.ecole.GestionEcole.Controller;

import ma.gestion.ecole.GestionEcole.dto.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("auth")
@CrossOrigin("*")
public interface IAuthentiationApi {
    @PostMapping("login")
    ResponseEntity generateToken(@RequestBody LoginDTO data);
}
