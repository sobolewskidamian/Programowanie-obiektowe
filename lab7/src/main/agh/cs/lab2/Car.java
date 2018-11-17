package agh.cs.lab2;

import java.util.LinkedList;
import java.util.List;

public class Car implements IObject{
    private MapDirection orientacja;
    private Position pozycja;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers;

    public Car(IWorldMap map, Position initialPosition) {
        this.pozycja = initialPosition;
        this.orientacja = MapDirection.NORTH;
        this.map=map;
        this.observers = new LinkedList<>();
    }

    public Car(IWorldMap map) {
        this.pozycja = new Position(2,2);
        this.orientacja = MapDirection.NORTH;
        this.map=map;
        this.observers = new LinkedList<>();
    }

    public String toString() {
        return orientacja.toString();
    }


    public Position getUnitVector(){
        switch(this.orientacja) {
            case NORTH: return new Position(0, 1);
            case EAST: return new Position(1, 0);
            case SOUTH: return new Position(0, -1);
            case WEST: return new Position(-1, 0);
        }
        return null;
    }

    public Position getVector(MoveDirection direction){
        Position zero = new Position(0,0);
        if (direction.equals(MoveDirection.FORWARD)) {
            return zero.add(getUnitVector());
        } else if (direction.equals(MoveDirection.BACKWARD)) {
            return zero.subtract(getUnitVector());
        } else {
            return zero;
        }
    }

    public void move (MoveDirection direction) {

        if (direction.equals(MoveDirection.RIGHT))
            this.orientacja = this.orientacja.next();
        else if (direction.equals(MoveDirection.LEFT))
            this.orientacja = this.orientacja.previous();
        else {
            Position vect = getVector(direction);
            Position newP = this.pozycja.add(vect);
            positionChanged(this.pozycja, newP);
            this.pozycja = newP;
        }
    }

    public Position getPosition(){
        return this.pozycja;
    }

    @Override
    public void setPosition(Position nowa) {
        this.pozycja=nowa;
    }

    public IWorldMap getMap(){
        return this.map;
    }

    public void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    public void positionChanged(Position oldPosition,Position newPosition) {
        for(IPositionChangeObserver actual: this.observers)
            actual.positionChanged(oldPosition,newPosition);
    }
}
