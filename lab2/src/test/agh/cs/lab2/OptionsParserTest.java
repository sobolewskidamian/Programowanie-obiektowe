package agh.cs.lab2;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class OptionsParserTest {
    @Test
    public void testParse(){
        Car car = new Car();
        String args[] = {"r", "g", "f", "forward", "t", "hdffsd", "f"};
        MoveDirection tab[] = new OptionsParser().parse(args);
        MoveDirection tab2[] = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};
        assertArrayEquals(tab, tab2);

        for(MoveDirection iterator:tab)
            car.move(iterator);

        assertEquals(new Position(4,2),car.getPosition());
        assertEquals(MapDirection.EAST,car.getMapDirection());
    }
}
