package com.tba.simulation.elements;

import com.tba.simulation.api.ITransmittable;

import java.util.Objects;

/**
 * Created by M.jalian on 02/03/2022.
 */

public abstract class Vehicle implements ITransmittable {
    
    private String id;
    private Position firstPosition = new Position();
    private Position currentPosition;
    private Direction direction;
    
    public String getId () {
        return id;
    }
    
    public void setId (String id) {
        this.id = id;
    }
    
    public Position getFirstPosition () {
        return firstPosition;
    }
    
    public void setFirstPosition (Position firstPosition) {
        this.firstPosition = firstPosition;
    }
    
    public Position getCurrentPosition () {
        return currentPosition;
    }
    
    public void setCurrentPosition (Position currentPosition) {
        this.currentPosition = currentPosition;
    }
    
    public Direction getDirection () {
        return direction;
    }
    
    public void setDirection (Direction direction) {
        this.direction = direction;
    }
    
    public Vehicle (String id, Position firstPosition) {
        this.id = id;
        this.firstPosition = firstPosition;
        this.currentPosition = new Position(firstPosition);
    }
    
    public Vehicle (String id) {
        this.id = id;
        this.currentPosition = firstPosition;
    }
    
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getId().equals(vehicle.getId());
    }
    
    @Override
    public int hashCode () {
        return Objects.hash(getId());
    }
    
    @Override
    public String toString () {
        return "Vehicle{" +
                       "id='" + id + '\'' +
                       ", firstPosition=" + firstPosition +
                       ", currentPosition=" + currentPosition +
                       ", direction=" + direction +
                       '}';
    }
}
