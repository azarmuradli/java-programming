package gardening.garden;

import gardening.garden.Garden;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GardenTest {
    @Test
    public void testGarden() {
        Garden garden = new Garden();
        assertEquals(0,garden.seedlings.size());
        assertEquals(0,garden.maturePlants.size());
        garden.plantOrchid();
        garden.plantPalmTree();
        assertEquals(2,garden.seedlings.size());
        assertEquals(0,garden.maturePlants.size());
        garden.growAll();
        garden.growAll();
        garden.growAll();
        garden.growAll();
        assertEquals(1,garden.seedlings.size());
        assertEquals(1,garden.maturePlants.size());
        garden.growAll();
        garden.growAll();
        garden.growAll();
        garden.growAll();
        assertEquals(0,garden.seedlings.size());
        assertEquals(2,garden.maturePlants.size());
    }
}