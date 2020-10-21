package ml.salastexido.functionalpatterns.factorymethod.models;

public class Truck implements Vehicle {
    private final VehicleColor color;

    public Truck(final  VehicleColor color){
        this.color = color; 
    }

}
