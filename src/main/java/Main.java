import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        while (!input.equals("End")) {
            List<String> vehicleData = Arrays.stream(input.split("\\s+")).toList();
            switch (vehicleData.get(0)) {
                case "car":
                    Vehicle car = new Vehicle(vehicleData.get(1),
                            vehicleData.get(2),
                            Integer.parseInt(vehicleData.get(3)),
                            "car");
                    vehicles.add(car);
                    break;
                case "truck":
                    Vehicle truck = new Vehicle(vehicleData.get(1),
                            vehicleData.get(2),
                            Integer.parseInt(vehicleData.get(3)),
                            "truck");
                    vehicles.add(truck);
                    break;
            }
            input = sc.nextLine();
        }

        String model = sc.nextLine();

        while (!model.equals("Close the Catalogue")) {
            printModelData(model, vehicles);
            model = sc.nextLine();
        }

        avgHorsePower(vehicles);
    }

    public static void printModelData(String model, List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            if (v.getModel().equals(model)) {
                System.out.println(v);
            }
        }
    }

    public static void avgHorsePower(List<Vehicle> vehicles) {
        double sumHorsepowerCar = 0;
        double sumHorsepowerTruck = 0;
        int countCars = 0;
        int countTruck = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            if ((vehicles.get(i).getModel().toLowerCase().equals("car"))) {
                sumHorsepowerCar += vehicles.get(i).getHorsepower();
                countCars++;
            } else {
                sumHorsepowerTruck += vehicles.get(i).getHorsepower();
                countTruck++;
            }
        }
        double avgHorsepowerCar = 0;
        double avgHorsepowerTruck = 0;
        if (countCars != 0) {
            avgHorsepowerCar = sumHorsepowerCar / countCars;
        }
        if (countTruck != 0) {
            avgHorsepowerTruck = sumHorsepowerTruck / countCars;
        }
        System.out.printf("Cars have average horsepower of: %.2f./n", avgHorsepowerCar);
        System.out.printf("Trucks have average horsepower of: %.2f./n", avgHorsepowerTruck);
    }
}