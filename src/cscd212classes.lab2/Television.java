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
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }
        if (screenSize < 32 || resolution < 720) {
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }

        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        if(this.resolution == 2160) {
            this.fourK = true;
        }
        else {
            this.fourK = false;
        }
    }

    //Constructor
    public Television(String model, boolean smart, int screenSize, int resolution, String make) {
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.make = make;
        if(this.resolution == 2160) {
            this.fourK = true;
        }
        else {
            this.fourK = false;
        }

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

    // Implementing the toString method
    @Override
    public String toString() {
        if(this.smart && this.fourK){

            return this.make + "-" + this.model + ", " + this.screenSize + " inch " + "smart tv with " + this.resolution + " resolution";
        }
        else if(this.smart){

            return this.make + "-" + this.model + ", " + this.screenSize + " inch " + "smart tv with " + resolution + " resolution";
        }
        else if(this.fourK){

            return this.make + "-" + this.model + ", " + this.screenSize + " inch " + "tv with 4K resolution";

        }
        else{
            return this.make + "-" + this.model + ", " + this.screenSize + " inch " + "tv with " + resolution + " resolution";
        }

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
                && this.model == that.model
                && this.smart == that.smart
                && this.screenSize == that.screenSize
                && this.resolution == that.resolution
                && this.fourK == that.fourK;
    }
    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(smart) + Boolean.hashCode(fourK);
    }
    @Override
    public int compareTo(Television another) {
        if (another == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }

        int makeCompare = this.make.compareTo(another.make);
        if (makeCompare != 0) {
            return makeCompare;
        }

        int modelCompare = this.model.compareTo(another.model);
        if (modelCompare != 0) {
            return modelCompare;
        }

        return this.screenSize - another.getScreenSize();
    }

   /* @Override
    public int compareTo(Television another) {
        if (another == null) {
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }

        int makeCompare = this.make.compareTo(another.make);
        if (makeCompare != 0) {
            return makeCompare;
        }

        int modelCompare = this.model.compareTo(another.model);
        if (modelCompare != 0) {
            return modelCompare;
        }
        return Integer.compare(another.screenSize, this.screenSize);
    }

 /* @Override
  public int compareTo(Television another) {
      if (another == null) {
          throw new IllegalArgumentException("null parameter in the compareTo method");
      }

      int makeCompare = this.make.compareTo(another.make);
      if (makeCompare != 0) {
          return makeCompare;
      }

      int modelCompare = this.model.compareTo(another.model);
      if (modelCompare != 0) {
          return modelCompare;
      }

      if (this.screenSize < another.screenSize) {
          return -1;
      } else if (this.screenSize > another.screenSize) {
          return 1;
      } else {
          return 0;
      }
  }*/
}

