package ma.gestion.ecole.GestionEcole.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import ma.gestion.ecole.GestionEcole.Service.serviceImpl.AuthenticationServiceImpl;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OnStartUpConfig {
    private final AuthenticationServiceImpl authenticationService;
    @PostConstruct
    public void postConstruct(){
        authenticationService.createDefaultEleve();
    }
}
