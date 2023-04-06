package cscd212classes.lab2;

public class Television implements Comparable<Television> {
    private final String make;
    private final String model;
    private final int screenSize;
    private final int resolution;
    private final boolean smart;
    private final boolean fourK;

    // Constructor
    public Television(String make, String model, boolean smart, int screenSize, int resolution) {
        if (make == null || make.isEmpty() || model == null || model.isEmpty()) {
            throw new IllegalArgumentException("make, model, and resolution cannot be null or empty");
        }
        if (screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("screenSize must be at least 32 inches and resolution must be at least 720p");
        }

        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
    }

    //Constructor
    public Television(String model, boolean smart, int screenSize, int resolution, String make) {
        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;

    }

    //Getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }
    @Override
    public String toString() {
        String smartString = "";
        String resolutionString = "";
        if (smart && resolution == 2160) {
            smartString = " smart";
        }
        if (fourK) {
            resolutionString = " with 4K resolution";
        } else {
            resolutionString = " with " + resolution + " resolution";
        }
        return make + "-" + model + ", " + screenSize + " inch" + smartString + " tv" + resolutionString;
    }

    // equals method.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Television that = (Television) o;
        return this.make.equals(that.make)
                && this.model.equals(that.model)
                && this.smart == that.smart
                && this.screenSize == that.screenSize
                && this.resolution == that.resolution
                && this.fourK == that.fourK;
    }
    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(fourK);
    }

    //CompareTo Method. Compares based on make.
    @Override
    public int compareTo(Television another ){
        return make.compareTo(another.make);
    }
}