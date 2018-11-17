package agh.cs.lab2;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testUnboundedMap {

    @Test
    public void testCars() throws InterruptedException, IOException {
        String tab[] = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f",};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new UnboundedMap();

        map.placeObject(new HayStack(new Position(-4,-1)));
        map.placeObject(new HayStack(new Position(2,3)));
        map.placeObject(new HayStack(new Position(4,6)));
        map.placeObject(new HayStack(new Position(1,0)));
        map.placeObject(new Car(map, new Position(2,0)));
        map.placeObject(new Car(map));
        map.placeObject(new Car(map, new Position(3,3)));

        List<Car> cars = ((UnboundedMap) map).getCars();
        IPositionChangeObserver observer=(UnboundedMap) map;
        for(Car actual: cars)
            actual.addObserver(observer);

        map.run(directions);
        IObject car0 = cars.get(0);
        IObject car1 = cars.get(1);
        IObject car2 = cars.get(2);
        Assert.assertEquals(car0.getPosition(), new Position(2,2));
        Assert.assertEquals(car1.getPosition(), new Position(4,2));
        Assert.assertEquals(car2.getPosition(), new Position(7,3));
    }
}
