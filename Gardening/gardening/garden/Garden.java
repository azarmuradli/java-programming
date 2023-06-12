package gardening.garden;

import java.util.ArrayList;
import gardening.plants.Plant;
import gardening.plants.Orchid;
import gardening.plants.Palm;
import gardening.utils.GrowthRate;


public class Garden {
    public ArrayList<Plant> seedlings = new ArrayList<Plant>();
    public ArrayList<Plant> maturePlants = new ArrayList<Plant>();

    public Garden() {}

    public void plantOrchid() {
        seedlings.add(new Orchid(GrowthRate.FAST,15));
    }
    public void plantPalmTree() {
        seedlings.add(new Palm(GrowthRate.MODERATE,10));
    }
    public void growAll() {
        for(int i=0;i<seedlings.size();i++) {
            seedlings.get(i).grow();
            if(seedlings.get(i).isMature()) {
                maturePlants.add(seedlings.get(i));
            }
        }
        for(int i=0;i<maturePlants.size();i++) {
            if(seedlings.contains(maturePlants.get(i))) {
                seedlings.remove(maturePlants.get(i));
            }
        }
    }
}