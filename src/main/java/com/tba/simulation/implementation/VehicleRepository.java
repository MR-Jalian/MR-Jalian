package com.tba.simulation.implementation;

import com.tba.simulation.elements.Vehicle;

import java.util.*;

/**
 * Created by M.jalian on 03/03/2022.
 */

public class VehicleRepository {
    
    private Map<String, Vehicle> repo = new HashMap<>(5);
    private static VehicleRepository vehicleRepository;
    
    private VehicleRepository () {
    }
    public static VehicleRepository getRepo(){
        
        if (vehicleRepository != null) {
            return vehicleRepository;
        } else {
            synchronized (VehicleRepository.class) {
                if (vehicleRepository != null) {
                    return vehicleRepository;
                } else {
                    vehicleRepository = new VehicleRepository();
                    return vehicleRepository;
                }
            }
        }
    }
    
    public void add (Vehicle vehicle) {
        repo.put(vehicle.getId(), vehicle);
    }
    
    public boolean contains(String vehicleId) {
        return repo.containsKey(vehicleId);
    }
    public Vehicle recoverVehicle(String vehicleId){
        return repo.get(vehicleId);
    }
    
    public List<Vehicle> recoverAllVehicles(){
        return new ArrayList<>( repo.values());
    }
    public Set<String> getAvailableVehicleIds(){
        return repo.keySet();
    }
}
