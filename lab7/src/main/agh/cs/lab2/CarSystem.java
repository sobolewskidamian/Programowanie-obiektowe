package agh.cs.lab2;

import java.io.IOException;
import java.util.Observable;

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

            Observer obs1 = new Observer(1);
            Observer obs3 = new Observer(3);
            Car car1 = new Car(map, new Position(2,0));
            car1.addObserver(obs1);
            Car car2 = new Car(map);
            car2.addObserver(obs1);
            Car car3 = new Car(map, new Position(3,3));
            car3.addObserver(obs1);
            car3.addObserver(obs3);

            map.placeObject(car1);
            map.placeObject(car2);
            map.placeObject(car3);

            map.run(directions);
        } catch(IllegalArgumentException ex){
            System.out.println(ex.toString());
        }
    }
}
