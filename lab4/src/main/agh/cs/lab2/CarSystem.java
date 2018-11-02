package agh.cs.lab2;

/**
 * Created by Student39 on 2018-10-09.
 */
public class CarSystem {
    public static  void main(String[] args) throws InterruptedException {
        String tab[] = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f",};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(5,5);
        map.place(new Car(map));
        map.place(new Car(map));
        map.place(new Car(map, new Position(3,4)));
        map.run(directions);
    }
}
