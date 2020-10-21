package ml.salastexido.functionalpatterns.factorymethod;

import ml.salastexido.functionalpatterns.factorymethod.models.*;
public class OldVehicleFactory {
    
    public static Vehicle  instanceOfType(VehicleType type, VehicleColor color){
        if(type.equals(VehicleType.BUS)){
            return new Bus(color);
        }
        else if(type.equals(VehicleType.CAR)){
            return new Car(color);
        }
        else if(type.equals(VehicleType.TRUCK)){
            return new Truck(color);
        }
        throw new IllegalArgumentException("No support for the type: " + type);
    }
}
