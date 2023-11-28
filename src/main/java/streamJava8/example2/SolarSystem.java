package streamJava8.example2;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {

    public static List<Planet> getPlanets(){
        List<Planet> planets = new ArrayList<>();
        Planet mercury = new Planet();
        mercury.setName("Mercury");
        mercury.setDensity(5.43);
        mercury.setHasRings(false);
        mercury.setNumberOfMoons(0);

        Planet venus = new Planet();
        venus.setName("Venus");
        venus.setDensity(5.24);
        venus.setHasRings(true);
        venus.setNumberOfMoons(0);

        planets.add(venus);
        planets.add(mercury);
        return planets;
    }
}
