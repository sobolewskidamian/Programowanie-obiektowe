package agh.cs.lab2;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected HashMap<Position,IObject> objects = new HashMap<>();
    protected List<Car> cars = new LinkedList<>();

    public boolean placeObject(IObject obj) {
        if (!isOccupied(obj.getPosition())) {
            this.objects.put(obj.getPosition(),obj);
            if(obj instanceof Car)
                this.cars.add((Car) obj);
            return true;
        }
        throw new IllegalArgumentException(obj.getPosition() + " jest już zajmowane");
    }

    public boolean isOccupied(Position position) {
        return objectAt(position)!=null;
    }

    public Object objectAt(Position position) {
        return objects.get(position);
    }

    public void run(MoveDirection[] directions) throws InterruptedException, IOException {
        List<Car> cars = getCars();

        for (int i = 0; i < directions.length; i++) {
            Car actualCar = cars.get(i % cars.size());
            Position actualPosition = actualCar.getPosition();
            Position vector = actualCar.getVector(directions[i]);
            Position afterMove = actualPosition.add(vector);
            if(canMoveTo(afterMove) || actualCar.getPosition().equals(afterMove)) {
                actualCar.move(directions[i]);
                objects.remove(actualPosition);
                objects.put(afterMove,actualCar);
                setCorners(afterMove);
            }
            System.out.println(toString(actualCar.getMap()));
        }
    }

    public boolean canMoveTo(Position afterMove){
        return !isOccupied(afterMove);
    }

    protected List<Car> getCars(){
        return this.cars;
    }

    void setCorners(Position afterMove) {}

    protected abstract String toString(IWorldMap map) throws InterruptedException, IOException;
}
