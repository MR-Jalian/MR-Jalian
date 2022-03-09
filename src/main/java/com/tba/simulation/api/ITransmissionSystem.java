package com.tba.simulation.api;

/**
 * Created by M.jalian on 02/03/2022.
 */

public interface ITransmissionSystem {

    void doTransmissionTask();
    void attachToTransmitSystem(ITransmittable transmittable);
    void detachFromTransmitSystem(ITransmittable transmittable);
}
