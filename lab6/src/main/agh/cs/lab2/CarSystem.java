package agh.cs.lab2;

import java.io.IOException;

public class CarSystem {
    public static  void main(String[] args) throws InterruptedException, IOException {
        try {
            String tab[] = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f",};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new UnboundedMap();
            ((UnboundedMap) map).placeHayStack(new HayStack(new Position(-4,-1)));
            ((UnboundedMap) map).placeHayStack(new HayStack(new Position(2,3)));
            ((UnboundedMap) map).placeHayStack(new HayStack(new Position(4,6)));
            ((UnboundedMap) map).placeHayStack(new HayStack(new Position(1,0)));
            map.placeCar(new Car(map, new Position(2,0)));
            map.placeCar(new Car(map));
            map.placeCar(new Car(map, new Position(3,3)));
            map.run(directions);
        } catch(IllegalArgumentException ex){
            System.out.println(ex.toString());
        }
    }
}
