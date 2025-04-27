package skillbuilder.indepth.sealed_classes.Sealedinterfaced;

public class SealedInterfaceWorkingDemo {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.drive();
    }
}

class Car implements LandVehicle {

    @Override
    public void drive() {
        System.out.println("Car is driving...");
    }

    @Override
    public void start() {
        System.out.println("Car starting...");
    }
}

class ship implements SeaVehicle {

    @Override
    public void navigate() {
        System.out.println("navigating...");
    }

    @Override
    public void start() {
        System.out.println("ship is starting..");
    }
}