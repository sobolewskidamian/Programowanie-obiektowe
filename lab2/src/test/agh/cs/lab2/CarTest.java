package agh.cs.lab2;

/**
 * Created by Student39 on 2018-10-09.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CarTest {

    @Test
    public void testInit()
    {
        Car car = new Car();
        Position p = new Position(2,2);
        assertEquals(p, car.getPosition());
        assertEquals(MapDirection.NORTH, car.getMapDirection());
    }
    @Test
    public void testToString() {
        Car car = new Car();
        String str = car.toString();
        assertEquals("Orientacja: Polnoc, pozycja: (2,2)", str);
    }

    @Test
    public void testMove(){
        Car car = new Car();
        String tab[] = {"r", "f", "f", "f"};
        for(MoveDirection kierunek : new OptionsParser().parse(tab))
            car.move(kierunek);

        assertEquals(car.getPosition(), new Position(4,2));
        assertEquals(car.getMapDirection(), MapDirection.EAST);


        String tab2[] = {"r", "f"};
        for(MoveDirection kierunek : new OptionsParser().parse(tab2))
            car.move(kierunek);
        assertEquals(car.getPosition(), new Position(4,1));
        assertEquals(car.getMapDirection(), MapDirection.SOUTH);
    }

    @Test
    public void testMove2(){
        Car car = new Car();
        String tab[] = {"r", "f", "f", "l", "b"};
        for(MoveDirection kierunek : new OptionsParser().parse(tab))
            car.move(kierunek);

        assertNotEquals(car.getPosition(), new Position(4,2));
    }


}
