package starexplorer.celestialbodies;

public class Planet extends CelestialBody {
    public WorldType worldType;
    public int oxygen, nitrogen, otherElements;

    public Planet(String name, double mass, int massExponent, CelestialBodyType bodyType,
    WorldType worldType,int oxygen,int nitrogen,int otherElements) {
        super(name, mass, massExponent, bodyType);
        this.worldType = worldType;
        this.oxygen = oxygen;
        this.nitrogen = nitrogen;
        this.otherElements = otherElements;
    }
    @Override
    public String toString() {
        return String.format("Planet %s(%.3fe%d,%s) of %s with (%d oxygen, %d nitrogen, %d other)",
        name,mass,massExponent,bodyType.toString(),worldType.toString(),oxygen,nitrogen,otherElements);

    }
}
