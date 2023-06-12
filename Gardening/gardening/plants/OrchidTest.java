package gardening.plants;

import gardening.plants.Orchid;
import gardening.plants.Plant;
import gardening.utils.GrowthRate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OrchidTest {
    @Test
    public void testOrchid() {
        Plant orchid = new Orchid(GrowthRate.FAST,15);
        assertEquals("(Orchid 0; flower count: 0; maturity level: 0; is not mature)",orchid.toString());
        orchid.grow();
        orchid.grow();
        orchid.grow();
        orchid.grow();
        assertEquals("(Orchid 0; flower count: 2; maturity level: 24; is mature)",orchid.toString());
        orchid.grow();
        orchid.grow();
        orchid.grow();
        orchid.grow();
        assertEquals("(Orchid 0; flower count: 6; maturity level: 48; is mature)",orchid.toString());
    }
}