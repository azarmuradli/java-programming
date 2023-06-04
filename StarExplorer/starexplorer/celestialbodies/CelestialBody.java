package starexplorer.celestialbodies;

import java.lang.Math;

public class CelestialBody {
    public String name;
    public double mass;
    public int massExponent;
    public CelestialBodyType bodyType;

    public CelestialBody(String name, double mass, int massExponent, CelestialBodyType bodyType) {
        if(name=="" || name==null || mass<=0) throw new IllegalArgumentException();
        this.name = name;
        this.mass= mass;
        this.massExponent = massExponent;
        this.bodyType = bodyType;
    }

    @Override
    public String toString() {
        return String.format("%s(%.3fe%d,%s)",name,mass,massExponent,bodyType.toString());
    }
}
