package streamJava8.example2;

public class Planet {
    private String name;
    private double density;
    private boolean hasRings;
    private int numberOfMoons;

    public Planet(){

    }
    public Planet(String name, double density, boolean hasRings, int numberOfMoons) {
        this.name = name;
        this.density = density;
        this.hasRings = hasRings;
        this.numberOfMoons = numberOfMoons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public boolean isHasRings() {
        return hasRings;
    }

    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    public void setNumberOfMoons(int numberOfMoons) {
        this.numberOfMoons = numberOfMoons;
    }
}
