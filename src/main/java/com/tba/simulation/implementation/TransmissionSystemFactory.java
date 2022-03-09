package com.tba.simulation.implementation;

import com.tba.simulation.api.ITransmissionSystem;

/**
 * Created by M.jalian on 03/03/2022.
 */

public class TransmissionSystemFactory {
    private static ITransmissionSystem transmissionSystem;
    
    private TransmissionSystemFactory () {
    }
    
    public static ITransmissionSystem getTransmissionSystem() {
        if (transmissionSystem != null) {
            return transmissionSystem;
        } else {
            synchronized (TransmissionSystemFactory.class) {
                if (transmissionSystem != null) {
                    return transmissionSystem;
                } else {
                    transmissionSystem = new DefaultTransmissionSystem();
                    return transmissionSystem;
                }
            }
        }
    }
}
