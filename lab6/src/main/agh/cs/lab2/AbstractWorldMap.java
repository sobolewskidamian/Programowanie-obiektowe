package agh.cs.lab2;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap {
    protected List<Car> cars = new LinkedList<>();
    protected HashMap<Position,Car> cars = new HashMap<>();


    protected boolean place(Car car) {
        if (!isOccupied(car.getPosition())) {
            this.cars.add(car);
            return true;
        }
        throw new IllegalArgumentException(car.getPosition() + " jest już zajmowane");
    }

    protected boolean isOccupied(Position position) {
        return objectAt(position)!=null;
    }

    protected Object objectAt(Position position) {
        for (Car actualCar : cars) {
            if (actualCar.getPosition().equals(position))
                return actualCar;
        }
        return null;
    }

    public void run(MoveDirection[] directions) throws InterruptedException, IOException {
        for (int i = 0; i < directions.length; i++) {
            Car actualCar = this.cars.get(i % cars.size());
            Position actualPosition = actualCar.getPosition();
            Position vector = actualCar.getVector(directions[i]);
            Position afterMove = actualPosition.add(vector);
            if(canMoveTo(afterMove) || actualCar.getPosition().equals(afterMove)) {
                actualCar.move(directions[i]);
                setCorners(afterMove);
            }
            System.out.println(toString(actualCar.getMap()));
        }
    }

    protected boolean canMoveTo(Position afterMove){
        return !isOccupied(afterMove);
    }

    void setCorners(Position afterMove) {}

    protected abstract String toString(IWorldMap map) throws InterruptedException, IOException;
}
