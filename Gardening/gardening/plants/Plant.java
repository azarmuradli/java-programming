package gardening.plants;

import gardening.utils.GrowthRate;
import gardening.utils.Growable;



public abstract class Plant implements Growable {
    public static int populationCount = 0;
    protected int id;
    protected GrowthRate growthRate;
    protected int maturity;
    protected int maturityGoal;

    public Plant(GrowthRate growthRate,int maturityGoal) {
        this.id = populationCount++;
        this.growthRate = growthRate;
        this.maturityGoal = maturityGoal;
        this.maturity = 0;
    }

    public int getGrowthRateModifier(GrowthRate growthRate) {
        if(growthRate == GrowthRate.SLOW) {
            return 1;
        }
        else if(growthRate == GrowthRate.MODERATE) {
            return 2;
        }
        else {
            return 6;
        }
    }

    public void grow() {
        maturity+= getGrowthRateModifier(growthRate);
    };

    public boolean isMature() {
        return maturity >= maturityGoal;
    }

}