package com.tba.simulator.test;

import com.tba.simulation.implementation.TransportSimulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by M.jalian on 03/03/2022.
 */

@RunWith(JUnit4.class)
public class simulTest {
    
    @Test
    public void test() {
        TransportSimulator simulator = new TransportSimulator();
        simulator.start();
    }

}
