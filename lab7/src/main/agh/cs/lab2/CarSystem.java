package agh.cs.lab2;

import java.io.IOException;
import java.util.List;

public class CarSystem {
    public static  void main(String[] args) throws InterruptedException, IOException {
        try {
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
        } catch(IllegalArgumentException ex){
            System.out.println(ex.toString());
        }
    }
}
