public class Vehicle {
    private String model;
    private String colour;
    private int horsepower;
    private String type;

    public Vehicle(String model, String colour, int horsepower, String type) {
        this.model = model;
        this.colour = colour;
        this.horsepower = horsepower;
        this.type = type;
    }

    public String toString() {
        if (type.toLowerCase().equals("car")) {
            return String.format("Type: Car\nModel: %s\nColor: %s\nHorsepower: %s", type, model, colour, horsepower);
        } else {
            return String.format("Type: Truck\nModel: %s\nColor: %s\nHorsepower: %s", type, model, colour, horsepower);
        }
    }

    public String getModel() {
        return model;
    }

    public int getHorsepower() {
        return horsepower;
    }
}
