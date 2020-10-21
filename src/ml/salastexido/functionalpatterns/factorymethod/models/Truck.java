package ml.salastexido.functionalpatterns.factorymethod.models;

public class Truck implements Vehicle {
    private final VehicleColor color;

    public Truck(){
        this(VehicleColor.BALCK);
    }

    public Truck(final  VehicleColor color){
        this.color = color; 
    }

    public String toString(){
        return "Truck: {" + "color:" + color.name() + "}";
    }

}
