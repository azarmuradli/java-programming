package gardening.plants;

import gardening.plants.Palm;
import gardening.plants.Plant;
import gardening.utils.GrowthRate;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PalmTreeTest {
    @Test
    public void testPalm() {
        Plant palm = new Palm(GrowthRate.MODERATE,10);
        assertEquals("(Palm tree 0; coconut fruit count: 0; maturity level: 0; is not mature)",palm.toString());
        palm.grow();
        palm.grow();
        palm.grow();
        palm.grow();
        assertEquals("(Palm tree 0; coconut fruit count: 8; maturity level: 8; is not mature)",palm.toString());
        palm.grow();
        palm.grow();
        palm.grow();
        palm.grow();
        assertEquals("(Palm tree 0; coconut fruit count: 16; maturity level: 16; is mature)",palm.toString());
    }
}