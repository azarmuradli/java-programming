package starexplorer;

import starexplorer.celestialbodies.CelestialBodyType;
import starexplorer.celestialbodies.CelestialBody;
import starexplorer.celestialbodies.Planet;
import starexplorer.celestialbodies.WorldType;
import starexplorer.observation.StarExplorer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StarTests {
    @Test
    public void testEarth() {
        CelestialBody cBody = new CelestialBody("Earth",5.972,24,CelestialBodyType.TERRESTRIAL_PLANET);
        assertEquals("Earth(5.972e24,TERRESTRIAL_PLANET)",cBody.toString());
    }
    @Test
    public void testEarthAsPlanet() {
        Planet planet = new Planet("Earth",5.972,24,CelestialBodyType.TERRESTRIAL_PLANET,WorldType.LANDMASS,78,21,1);
        assertEquals("Planet Earth(5.972e24,TERRESTRIAL_PLANET) of LANDMASS with (78 oxygen, 21 nitrogen, 1 other)",planet.toString());
    }
    @Test 
    public void testStarExplorer() {
        StarExplorer starExplorer = new StarExplorer("solarsystem.txt");
        assertEquals(true,starExplorer.isHabitable("Earth"));
        assertEquals(false,starExplorer.isHabitable("Venus"));
        assertEquals(false,starExplorer.isHabitable("JUPITER"));
        assertEquals(false,starExplorer.isHabitable("XYZ"));
    }
}
