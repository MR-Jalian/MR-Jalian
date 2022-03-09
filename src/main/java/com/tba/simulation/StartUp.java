package com.tba.simulation;

import com.tba.simulation.implementation.TransportSimulator;

/**
 * Created by M.jalian on 02/03/2022.
 */

public class StartUp {
    
    public static void main (String[] args) {
        TransportSimulator simulator = new TransportSimulator();
        simulator.start();
    }
}
