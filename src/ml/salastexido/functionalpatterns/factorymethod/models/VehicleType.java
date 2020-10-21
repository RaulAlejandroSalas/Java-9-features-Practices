package ml.salastexido.functionalpatterns.factorymethod.models;
import ml.salastexido.functionalpatterns.factorymethod.models.*;

public enum VehicleType {
    CAR(Car::new),
    TRUCK(Truck::new),
    BUS(Bus::new)

}
