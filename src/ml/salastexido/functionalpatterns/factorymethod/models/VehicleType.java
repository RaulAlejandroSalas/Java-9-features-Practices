package ml.salastexido.functionalpatterns.factorymethod.models;
import java.util.function.Function;


public enum VehicleType {
    CAR(Car::new),
    TRUCK(Truck::new),
    BUS(Bus::new);

    public final Function<VehicleColor,Vehicle> vFunction;

    VehicleType(Function<VehicleColor,Vehicle> f){
        this.vFunction = f;
    }




}
