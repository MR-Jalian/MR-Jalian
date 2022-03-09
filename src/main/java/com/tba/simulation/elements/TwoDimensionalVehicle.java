package com.tba.simulation.elements;

/**
 * Created by M.jalian on 02/03/2022.
 */

public class TwoDimensionalVehicle extends Vehicle {
    
    
    public TwoDimensionalVehicle (String id, Position firstPosition) {
        super(id, firstPosition);
    }
    public TwoDimensionalVehicle (String id) {
        super(id);
    }
    
    @Override
    public void transmit () {
        switch (this.getDirection()) {
            case NORTH:
                this.getCurrentPosition().setY(this.getCurrentPosition().getY()+1);
                break;
            case SOUTH:
                this.getCurrentPosition().setY(this.getCurrentPosition().getY()-1);
                break;
            case WEST:
                this.getCurrentPosition().setX(this.getCurrentPosition().getX()-1);
                break;
            case EAST:
                this.getCurrentPosition().setX(this.getCurrentPosition().getX()+1);
                break;
            case NORTHWESTERN:
                this.getCurrentPosition().setY(this.getCurrentPosition().getY()+1);
                this.getCurrentPosition().setX(this.getCurrentPosition().getX()-1);
                break;
            case NORTHEASTERN:
                this.getCurrentPosition().setY(this.getCurrentPosition().getY()+1);
                this.getCurrentPosition().setX(this.getCurrentPosition().getX()+1);
                break;
            case SOUTHWESTERN:
                this.getCurrentPosition().setY(this.getCurrentPosition().getY()-1);
                this.getCurrentPosition().setX(this.getCurrentPosition().getX()-1);
                break;
            case SOUTHEASTERN:
                this.getCurrentPosition().setY(this.getCurrentPosition().getY()-1);
                this.getCurrentPosition().setX(this.getCurrentPosition().getX()+1);
                break;
        }
    }
    
    @Override
    public String toString () {
        return "TwoDimensionalVehicle{" +
                       super.toString() + "}";
    }
}
