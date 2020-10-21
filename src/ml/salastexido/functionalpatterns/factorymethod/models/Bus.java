package ml.salastexido.functionalpatterns.factorymethod.models;

public class Bus implements Vehicle{

    private final VehicleColor color;

    public Bus(final  VehicleColor color){
        this.color = color; 
    }

}
