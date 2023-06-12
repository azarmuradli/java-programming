package gardening.plants;
import gardening.utils.GrowthRate;
import gardening.plants.Plant;

public class Palm extends Plant {
    public int COCONUT_YIELD;
    private int coconutFruitCount;

    public Palm(GrowthRate growthRate,int maturityGoal) {
        super( GrowthRate.MODERATE,10);
        COCONUT_YIELD = 2;
        coconutFruitCount = 0;
    }


    @Override
    public void grow() {
        maturity+= getGrowthRateModifier(growthRate);
        coconutFruitCount+=COCONUT_YIELD;
    }

    @Override
    public boolean isMature() {
        return (maturity > maturityGoal) && (coconutFruitCount>=12);
    }

    @Override
    public String toString() {
        if(isMature()) {
            return String.format("(Palm tree %d; coconut fruit count: %d; maturity level: %d; is mature)",id,coconutFruitCount,maturity);
        }
        else {
            return String.format("(Palm tree %d; coconut fruit count: %d; maturity level: %d; is not mature)",id,coconutFruitCount,maturity);
        }
    }

}