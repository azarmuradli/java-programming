package starexplorer.observation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import starexplorer.celestialbodies.Star;
import starexplorer.celestialbodies.WorldType;
import starexplorer.celestialbodies.CelestialBodyType;
import starexplorer.celestialbodies.Planet;

public class StarExplorer {
    private StarSystem starSystem;

    public StarExplorer(String fileName) {
        starSystem = new StarSystem();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            boolean first = true;
            starSystem.planets = new ArrayList<>();
            while((line = reader.readLine())!=null) {
                if(first) {
                    String[] lineArr = line.split(" ");
                    starSystem.star = new Star(
                        lineArr[0],
                        Double.parseDouble(lineArr[1]),
                        Integer.parseInt(lineArr[2]),
                        CelestialBodyType.valueOf(lineArr[3]),
                        Integer.parseInt(lineArr[4]));
                    first = false;
                }
                else {
                    String[] lineArr = line.split(" ");
                    Planet planet = new Planet(
                        lineArr[0],
                        Double.parseDouble(lineArr[1]),
                        Integer.parseInt(lineArr[2]),
                        CelestialBodyType.valueOf(lineArr[3]),
                        WorldType.valueOf(lineArr[4]),
                        Integer.parseInt(lineArr[5]),
                        Integer.parseInt(lineArr[6]),
                        Integer.parseInt(lineArr[7]));
        
                    starSystem.planets.add(planet);
                }
        
            }
            reader.close();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isHabitable(Planet planet) {
        if((planet.bodyType == CelestialBodyType.TERRESTRIAL_PLANET )
        && (planet.worldType==WorldType.CONTINENTAL || planet.worldType==WorldType.OCEAN || planet.worldType==WorldType.LANDMASS)
        && (planet.nitrogen>=70 && planet.nitrogen<=80)
        && (planet.oxygen>=20 && planet.oxygen<=25)
        && (planet.otherElements <=5)) {return true;}
        else {
            return false;
        }
    }
    public boolean isHabitable(String planetName) {
        Planet planet = null;
        boolean exist = false;
        for(int i=0;i<starSystem.planets.size();i++) {
            if(starSystem.planets.get(i).toString().contains(planetName)) {
                exist = true;
                planet = starSystem.planets.get(i);
            }
        }
        if(exist && planet !=null && isHabitable(planet)) {
            return true;
        }
        else {
            return false;
        }
    }
}



