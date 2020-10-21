package ml.salastexido.functionalpatterns.factorymethod.models;

public class Plane implements Vehicle{
    private final VehicleColor color;

    Plane(final VehicleColor color){
        this.color = color;
    }

    public String toString(){
        return "Plane: {" + "color:" + color.name() + "}";
    }
}
