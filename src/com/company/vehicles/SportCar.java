package com.company.vehicles;

import com.company.details.Engine;
import com.company.professions.Driver;

public class SportCar extends Car {
    private int maxSpeed;

    public SportCar(String Brand, String carClass, int weight, Driver driver, Engine engine) {
        super(Brand, carClass, weight, driver, engine);
    }


}
