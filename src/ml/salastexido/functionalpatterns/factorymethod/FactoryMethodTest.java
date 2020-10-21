package ml.salastexido.functionalpatterns.factorymethod;

import ml.salastexido.functionalpatterns.factorymethod.models.Vehicle;
import ml.salastexido.functionalpatterns.factorymethod.models.VehicleColor;
import ml.salastexido.functionalpatterns.factorymethod.models.VehicleType;

public class FactoryMethodTest {
    public static void main(String[] args) {
        //before Java8 implementation
        Vehicle vehicle = OldVehicleFactory.instanceOfType(VehicleType.BUS, 
                                                           VehicleColor.BALCK);
        System.out.print(vehicle);
    }
}
