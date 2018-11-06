package agh.cs.lab2;

/**
 * Created by Student39 on 2018-10-09.
 */

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testRectangularMap {

    @Test
    public void testCars() throws InterruptedException, IOException {
        String tab[] = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f",};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(5,5);
        map.place(new Car(map));
        map.place(new Car(map));
        map.place(new Car(map, new Position(3,4)));
        map.run(directions);
        List<Car> cars = ((RectangularMap) map).getCars();
        Car car0 = cars.get(0);
        Car car1 = cars.get(1);
        Assert.assertEquals(car0.getPosition(), new Position(2,0));
        Assert.assertEquals(car1.getPosition(), new Position(3,4));
    }



}
