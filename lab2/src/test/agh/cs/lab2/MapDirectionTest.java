package agh.cs.lab2;

/**
 * Created by Student39 on 2018-10-09.
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MapDirectionTest {
    @Test
    public void testPublic() {
        MapDirection a = MapDirection.EAST;
        MapDirection b = MapDirection.SOUTH;
        assertEquals(a.next(), b);

        a = MapDirection.SOUTH;
        b = MapDirection.WEST;
        assertEquals(a.next(), b);

        a = MapDirection.WEST;
        b = MapDirection.NORTH;
        assertEquals(a.next(), b);

        a = MapDirection.NORTH;
        b = MapDirection.EAST;
        assertEquals(a.next(), b);
    }

    @Test
    public void testToString()
    {
        assertEquals(MapDirection.NORTH.toString(),"Polnoc");
        assertEquals(MapDirection.SOUTH.toString(),"Poludnie");
        assertEquals(MapDirection.WEST.toString(),"Zachod");
        assertEquals(MapDirection.EAST.toString(),"Wschod");
    }
}
