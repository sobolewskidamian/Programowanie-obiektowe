package agh.cs.lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student39 on 2018-10-09.
 */
public class CarSystem {
    public static  void main(String[] args) throws InterruptedException, IOException {
        try {
            List<HayStack> hays = new ArrayList<>();
            hays.add(new HayStack(new Position(-4, -1)));
            hays.add(new HayStack(new Position(2, 3)));
            hays.add(new HayStack(new Position(4, 6)));
            hays.add(new HayStack(new Position(1, 0)));

            String tab[] = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f",};
            MoveDirection[] directions = new OptionsParser().parse(tab);

            IWorldMap map = new UnboundedMap(hays);

            map.place(new Car(map, new Position(2, 0)));
            map.place(new Car(map));
            map.place(new Car(map));
            map.place(new Car(map, new Position(3, 3)));

            map.run(directions);
        } catch(IllegalArgumentException ex){
            System.out.println(ex.toString());
        }
    }
}
