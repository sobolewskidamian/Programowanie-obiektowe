package agh.cs.lab2;

import java.io.IOException;

public class CarSystem {
    public static  void main(String[] args) throws InterruptedException, IOException {
        try {
            String tab[] = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f",};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new UnboundedMap();

            map.placeObject(new Car(map, new Position(2,0)));
            map.placeObject(new Car(map));
            map.placeObject(new Car(map, new Position(3,3)));

            map.run(directions);
        } catch(IllegalArgumentException ex){
            System.out.println(ex.toString());
        }
    }
}
