package skillbuilder.indepth.sealed_classes.Sealedinterfaced;

public sealed interface Vehicle permits SeaVehicle, LandVehicle {
    void start();
}

non-sealed interface LandVehicle extends Vehicle {
    void drive();
}

non-sealed interface SeaVehicle extends Vehicle {
    void navigate();
}