package com.saran.daggertutorial.component;

import com.saran.daggertutorial.model.Motor;
import com.saran.daggertutorial.model.Vehicle;
import com.saran.daggertutorial.module.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Saran on 26/2/16.
 */

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {
    Vehicle provideVehicle();
    Motor provideMotor();
}
