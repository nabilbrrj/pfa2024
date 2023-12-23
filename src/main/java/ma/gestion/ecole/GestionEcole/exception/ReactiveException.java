package ma.gestion.ecole.GestionEcole.exception;

public class ReactiveException extends RuntimeException {

    private final FeatureErrorEnum featureErrorEnum;

    public ReactiveException(FeatureErrorEnum featureErrorEnum) {
        super(featureErrorEnum.getErrorMessage());
        this.featureErrorEnum = featureErrorEnum;
    }

    public FeatureErrorEnum getFeature() {
        return featureErrorEnum;
    }
}