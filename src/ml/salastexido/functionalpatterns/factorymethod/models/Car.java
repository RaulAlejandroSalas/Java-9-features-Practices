package ml.salastexido.functionalpatterns.factorymethod.models;

public class Car implements Vehicle{
    private final VehicleColor color;

    public Car(final  VehicleColor color){
        this.color = color; 
    }

}
