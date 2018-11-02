package agh.cs.lab2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap {
    protected List<Car> cars = new LinkedList<>();

    protected boolean place(Car car) {
        if (!isOccupied(car.getPosition())) {
            this.cars.add(car);
            return true;
        }
        return false;
    }

    protected boolean isOccupied(Position position) {
        for (Car actualCar : cars)
            if (position.equals(actualCar.getPosition()))
                return true;
        return false;
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

    protected abstract void setCorners(Position afterMove);

    protected abstract boolean canMoveTo(Position afterMove);

    protected abstract String toString(IWorldMap map) throws InterruptedException, IOException;
}
