package com.tba.simulation.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tba.simulation.elements.Direction;
import com.tba.simulation.elements.Position;
import com.tba.simulation.elements.TwoDimensionalVehicle;
import com.tba.simulation.elements.Vehicle;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by M.jalian on 03/03/2022.
 */

public class TransportSimulator {
    
    private Scanner scanner = new Scanner(System.in);
    
    // *********** messages***************
    
    private String welcome = "                                \n"+
                             "*    *  *****  *  *   **       \n" +
                             "*    *  *      *  *  *  *      \n" +
                             "******  ***    *  *  *  *      \n" +
                             "*    *  *      *  *  *  *      \n" +
                             "*    *  *****  *  *   **       \n" +
                             "                                \n"
            ;
    
    private String mainMenu = "please insert :\n"+
                              "1 for create vehicle.\n"+
                              "2 for select a vehicle to move on a direction.\n"+
                              "3 for select a vehicle to stop it.\n"+
                              "4 for trace simulation board\n"
            ;
    
    private String addVehicleMessage = "please insert vehicle id and its first position in this format : id,x,y,z\n" +
                                       "for example 80,1,1,1\n" +
                                       "if you don't insert position system use default position\n" +
                                       "which is Origin of coordinates"
            ;
    
    private String selectVehicleToMoveOnDirectionMessage = "please insert vehicle id and its direction to move on in this format : id,direction\n" +
                                            "N : NORTH, S : SOUTH, W : WEST, E : EAST\n" +
                                            "NW : NORTHWESTERN, NE : NORTHEASTERN, SW : SOUTHWESTERN, SE : SOUTHEASTERN\n" +
                                            "for example 80,N\n" +
                                            "which means vehicle 80 should move on north\n" +
                                            "available vehicles are :\n"
            ;
    
    private String stopVehicleMessage = "please insert vehicle id to stop its transmission";
    private String traceBoardMessage = "please insert any key to stop tracing and back to menu";
    
    private String failForExistenceMessage = "fail. existing vehicle";
    private String failForNotExistenceMessage = "fail. not existing vehicle";
    private String failBadCommandMessage= "fail. bad command";
    
    private String successfulMessage = "successful";
    
    // *********** operations ************************
    private String addVehicle(String command) {
        
        String id;
        long x = 0;
        long y = 0;
        long z = 0;
        if (command.contains(",")) {
        
            String[] splittedCommand = command.split(",");
            id = splittedCommand[0];
            x = Long.parseLong(splittedCommand[1]);
            y = Long.parseLong(splittedCommand[2]);
            z = Long.parseLong(splittedCommand[3]);
        } else {
            id = command;
        }
    
        if (VehicleRepository.getRepo().contains(id)){
            return failForExistenceMessage;
        }
        TwoDimensionalVehicle vehicle = new TwoDimensionalVehicle(id, new Position(x,y,z));
        VehicleRepository.getRepo().add(vehicle);
        return successfulMessage;
    }
    
    private String selectVehicleToMoveOnDirection(String command) {
        
        if (!command.contains(",")) {
            return failBadCommandMessage;
        }
        String id;
        Direction direction;
        String [] spilittedCommand = command.split(",");
        id = spilittedCommand[0];
        if (!VehicleRepository.getRepo().contains(id)) {
            return failForNotExistenceMessage;
        }
        direction = Direction.getDirection(spilittedCommand[1]);
        Vehicle vehicle = VehicleRepository.getRepo().recoverVehicle(id);
        vehicle.setDirection(direction);
        TransmissionSystemFactory.getTransmissionSystem().attachToTransmitSystem(vehicle);
        return successfulMessage;
    }
    
    private String stopVehicle(String id) {
        if (!VehicleRepository.getRepo().contains(id)) {
            return failForNotExistenceMessage;
        }
        Vehicle vehicle = VehicleRepository.getRepo().recoverVehicle(id);
        TransmissionSystemFactory.getTransmissionSystem().detachFromTransmitSystem(vehicle);
        return successfulMessage;
    }
    
    private void traceBoard() {
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            private ObjectMapper objectMapper = new ObjectMapper();
            @Override
            public void run () {
                try {
                    System.out.println(
                            objectMapper.writeValueAsString(
                                    VehicleRepository.getRepo().recoverAllVehicles()));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }, 2000, 10000);
        
        
        scanner.nextLine();
        timer.cancel();
    }
    
    public void start() {
        
        System.out.println(welcome);
        String userCommand;
        String operationResult ;
        while (true) {
            System.out.println(mainMenu);
            userCommand = scanner.nextLine();
            switch (userCommand) {
                case "1" :
                    System.out.println(addVehicleMessage);
                    userCommand = scanner.nextLine();
                    operationResult = addVehicle(userCommand);
                    System.out.println(operationResult);
                    break;
                case "2" :
                    System.out.println(selectVehicleToMoveOnDirectionMessage+VehicleRepository.getRepo().getAvailableVehicleIds());
                    userCommand = scanner.nextLine();
                    operationResult = selectVehicleToMoveOnDirection(userCommand);
                    System.out.println(operationResult);
                    break;
                case "3" :
                    System.out.println(stopVehicleMessage);
                    userCommand = scanner.nextLine();
                    operationResult = stopVehicle(userCommand);
                    System.out.println(operationResult);
                    break;
                case  "4" :
                    System.out.println(traceBoardMessage);
                    traceBoard();
                    break;
                default:
                    System.out.println(failBadCommandMessage);
            }
        }
    }
}
