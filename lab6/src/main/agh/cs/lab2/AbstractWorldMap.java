package agh.cs.lab2;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap {
    protected HashMap<Position,Object> objects = new HashMap<>();
    protected List<Car> cars = new LinkedList<>();

    protected boolean placeCar(Car car) {
        if (!isOccupied(car.getPosition())) {
            this.objects.put(car.getPosition(),car);
            this.cars.add(car);
            return true;
        }
        throw new IllegalArgumentException(car.getPosition() + " jest już zajmowane");
    }

    protected boolean placeHayStack(HayStack hay) {
        if (!isOccupied(hay.getPosition())) {
            this.objects.put(hay.getPosition(),hay);
            return true;
        }
        throw new IllegalArgumentException(hay.getPosition() + " jest już zajmowane");
    }

    protected boolean isOccupied(Position position) {
        return objectAt(position)!=null;
    }

    protected Object objectAt(Position position) {
        for (Position actual : this.objects.keySet()) {
            if (actual.equals(position))
                return objects.get(actual);
        }
        return null;
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
                System.out.println(afterMove.toString());
                setCorners(afterMove);
            }
            System.out.println(toString(actualCar.getMap()));
        }
    }

    protected boolean canMoveTo(Position afterMove){
        return !isOccupied(afterMove);
    }

    protected List<Car> getCars(){
        return this.cars;
    }

    protected List<HayStack> getHayStacks(){
        List<HayStack> hay = new LinkedList<>();
        for(Object actual : this.objects.values()) {
            if (actual instanceof HayStack)
                hay.add((HayStack) actual);
        }
        return hay;
    }

    void setCorners(Position afterMove) {}

    protected abstract String toString(IWorldMap map) throws InterruptedException, IOException;
}
