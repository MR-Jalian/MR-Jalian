package com.tba.simulation.elements;

/**
 * Created by M.jalian on 02/03/2022.
 */

public class Position {
    
    private long x = 0;
    private long y = 0;
    private long z = 0;
    
    public long getX () {
        return x;
    }
    
    public void setX (long x) {
        this.x = x;
    }
    
    public long getY () {
        return y;
    }
    
    public void setY (long y) {
        this.y = y;
    }
    
    public long getZ () {
        return z;
    }
    
    public void setZ (long z) {
        this.z = z;
    }
    
    public Position (long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Position (long x, long y) {
        this.x = x;
        this.y = y;
    }
    
    public Position () {
    }
    
    public Position (Position position) {
         this(position.getX(), position.getY(), position.getZ());
    }
    
    @Override
    public String toString () {
        return "Position{" +
                       "x=" + x +
                       ", y=" + y +
                       ", z=" + z +
                       '}';
    }
}
