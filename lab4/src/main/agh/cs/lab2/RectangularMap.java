package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final Position smallest;
    private final Position largest;
    private int width;
    private int height;
    private List<Car> cars;


    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        smallest = new Position(0 ,0);
        largest = new Position(this.width-1, this.height-1);
        this.cars = new ArrayList<>();
    }

    public boolean canMoveTo(Position position) {
        
        return (position.smaller(largest) && position.larger(smallest) && !isOccupied(position));
    }

    public boolean place(Car car) {
        if (canMoveTo(car.getPosition())) {
            this.cars.add(car);
            return true;
        } else return false;
    }

    public void run(MoveDirection[] directions) throws InterruptedException {
        for (int i = 0; i < directions.length; i++) {
            Car actualCar = cars.get(i % this.cars.size());
            actualCar.move(directions[i]);
            System.out.print(toString(actualCar.getMap()));
        }
    }

    public boolean isOccupied(Position position) {
        for (Car actualCar : cars) {
            if (position.equals(actualCar.getPosition()))
                return true;
        }
        return false;
    }

    public Object objectAt(Position position) {
        for (Car actualCar : cars) {
            if (actualCar.getPosition().equals(position))
                return actualCar;
        }
        return null;
    }

    public String toString(IWorldMap map) throws InterruptedException {
        return new MapVisualizer(map).draw(smallest, largest);
    }
}
