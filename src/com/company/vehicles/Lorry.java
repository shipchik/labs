package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;

public class Lorry extends Car {
    private int carryingCapacity;

    public Lorry(String Brand, String carClass, int weight, Driver driver, Engine engine) {
        super(Brand, carClass, weight, driver, engine);
    }


}
