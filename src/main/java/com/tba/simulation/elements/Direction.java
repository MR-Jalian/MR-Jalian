package com.tba.simulation.elements;



/**
 * Created by M.jalian on 02/03/2022.
 */

public enum Direction {
    
    NORTH("N"),
    SOUTH("S"),
    WEST("W"),
    EAST("E"),
    NORTHWESTERN("NW"),
    NORTHEASTERN("NE"),
    SOUTHWESTERN("SW"),
    SOUTHEASTERN("SE");
    
    private String abbreviation;
    
    Direction (String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public static Direction getDirection(String abbreviation) {
        
        for (Direction d : Direction.values()) {
            
            if (d.abbreviation.equals(abbreviation)) {
                return d;
            }
        }
        throw new RuntimeException("bad abbreviation for direction : "+ abbreviation);
    }

}
