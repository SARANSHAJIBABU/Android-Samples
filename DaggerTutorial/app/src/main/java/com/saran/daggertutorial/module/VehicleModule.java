package com.saran.daggertutorial.module;

import com.saran.daggertutorial.model.Motor;
import com.saran.daggertutorial.model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Saran on 26/2/16.
 */

@Module
public class VehicleModule {

    @Provides
    Motor provideMotor(){
        return new Motor();
    }

    @Provides
    Vehicle provideVehicle(){
        return new Vehicle(new Motor());
    }
}
