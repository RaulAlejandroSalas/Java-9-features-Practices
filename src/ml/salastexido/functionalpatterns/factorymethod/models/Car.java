package ml.salastexido.functionalpatterns.factorymethod.models;

public class Car implements Vehicle{
    private final VehicleColor color;

    public Car(){
        this.color = VehicleColor.BALCK;
    }

    public Car(final  VehicleColor color){
        this.color = color; 
    }

    public String toString(){
        return "Car: {" + "color:" + color.name() + "}";
    }

}
