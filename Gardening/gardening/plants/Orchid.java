package gardening.plants;
import gardening.utils.GrowthRate;

public class Orchid extends Plant {
    private int flowerCount;

    public Orchid(GrowthRate growthRate,int maturityGoal) {
        super(GrowthRate.FAST,15);
        flowerCount = 0;
    }


    @Override
    public void grow() {
        maturity+= getGrowthRateModifier(growthRate);
        if(isMature()) {
            flowerCount+=1;
        }
        
    }

    @Override
    public String toString() {
        if(isMature()) {
            return String.format("(Orchid %d; flower count: %d; maturity level: %d; is mature)",id,flowerCount,maturity);
        }
        else {
            return String.format("(Orchid %d; flower count: %d; maturity level: %d; is not mature)",id,flowerCount,maturity);
        }
    }
}