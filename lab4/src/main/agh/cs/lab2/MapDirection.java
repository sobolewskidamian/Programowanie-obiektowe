package agh.cs.lab2;

/**
 * Created by Student39 on 2018-10-09.
 */
public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    public String toString(){
        switch(this){
            case EAST: return ">";
            case WEST: return "<";
            case NORTH: return "^";
            case SOUTH: return "v";
            default: return "E";
        }
    }

    public MapDirection next(){
        switch(this){
            case EAST: return SOUTH;
            case WEST: return NORTH;
            case NORTH: return EAST;
            case SOUTH: return WEST;
        }
        return null;
    }

    public MapDirection previous(){
        switch(this){
            case EAST: return NORTH;
            case WEST: return SOUTH;
            case NORTH: return WEST;
            case SOUTH: return EAST;
        }
        return null;
    }
}
