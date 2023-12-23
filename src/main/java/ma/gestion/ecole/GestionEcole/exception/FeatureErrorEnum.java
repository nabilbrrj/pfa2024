package ma.gestion.ecole.GestionEcole.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum FeatureErrorEnum {
    FT0001("The client doesn't exists", HttpStatus.UNAUTHORIZED),
    FT0002("Bad credential while login", HttpStatus.UNAUTHORIZED),
    FT0004("User account is not active", HttpStatus.UNAUTHORIZED),;


    @Getter
    private final String errorMessage;

    @Getter
    private final HttpStatus httpStatus;

    FeatureErrorEnum(String errorMessage, HttpStatus httpStatus) {
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public void throwException(){
        throw newException();
    }

    public ReactiveException newException() {
        return new ReactiveException(this);
    }
}
