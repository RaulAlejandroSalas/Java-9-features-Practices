package ml.salastexido.functionalpatterns.factorymethod.models;

public class Bus implements Vehicle{

    private final VehicleColor color;

    public Bus(){
        this(VehicleColor.BALCK);
    }

    public Bus(final  VehicleColor color){
        this.color = color; 
    }

    
    public String toString(){
        return "Bus: {" + "color:" + color.name() + "}";
    }

}
