package com.tba.simulation.implementation;

import com.tba.simulation.api.ITransmissionSystem;
import com.tba.simulation.api.ITransmittable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by M.jalian on 03/03/2022.
 */

public class DefaultTransmissionSystem implements ITransmissionSystem, Runnable {
    
    private List<ITransmittable> transmittableList = new ArrayList<>();
    
    public DefaultTransmissionSystem () {
    
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(this, 0, 3, TimeUnit.SECONDS);
    }
    
    public void doTransmissionTask () {
    
        for (ITransmittable transmittable : transmittableList) {
            transmittable.transmit();
        }
    }
    
    public void attachToTransmitSystem (ITransmittable transmittable) {
        
        transmittableList.add(transmittable);
    }
    
    public void detachFromTransmitSystem (ITransmittable transmittable) {
        
        transmittableList.remove(transmittable);
    }
    
    @Override
    public void run () {
        if (!transmittableList.isEmpty()) {
    
            this.doTransmissionTask();
        }
        
    }
}
