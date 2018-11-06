package agh.cs.lab2;

/**
 * Created by Student39 on 2018-10-09.
 */

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testUnboundedMap {

    @Test
    public void testCars() throws InterruptedException, IOException {
        List<HayStack> hays = new ArrayList<>();
        hays.add(new HayStack(new Position(-4,-1)));
        hays.add(new HayStack(new Position(2,3)));
        hays.add(new HayStack(new Position(4,6)));
        hays.add(new HayStack(new Position(1,0)));
        String tab[] = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f",};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new UnboundedMap(hays);
        map.place(new Car(map, new Position(2,0)));
        map.place(new Car(map));
        map.place(new Car(map, new Position(3,3)));
        map.run(directions);
        List<Car> cars = ((UnboundedMap) map).getCars();
        Car car0 = cars.get(0);
        Car car1 = cars.get(1);
        Car car2 = cars.get(2);
        Assert.assertEquals(car0.getPosition(), new Position(2,2));
        Assert.assertEquals(car1.getPosition(), new Position(4,2));
        Assert.assertEquals(car2.getPosition(), new Position(7,3));
    }



}
