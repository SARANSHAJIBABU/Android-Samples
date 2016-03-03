package com.saran.daggertutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.saran.daggertutorial.component.DaggerVehicleComponent;
import com.saran.daggertutorial.component.VehicleComponent;
import com.saran.daggertutorial.model.Vehicle;
import com.saran.daggertutorial.module.VehicleModule;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
        Vehicle vehicle1 = component.provideVehicle();
        vehicle1.increaseSpeed(10);
        Toast.makeText(this, String.valueOf(vehicle1.getSpeed()), Toast.LENGTH_SHORT).show();
    }

}
