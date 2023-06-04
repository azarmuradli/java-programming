package starexplorer.celestialbodies;


public class Star extends CelestialBody {
    public int surfaceTemperature;

    public Star(String name, double mass, int massExponent, CelestialBodyType bodyType,int surfaceTemperature) {
        super(name, mass, massExponent, bodyType);
        if(bodyType!=CelestialBodyType.MS_STAR) throw  new IllegalArgumentException();
        this.surfaceTemperature = surfaceTemperature;
    }
    
}
