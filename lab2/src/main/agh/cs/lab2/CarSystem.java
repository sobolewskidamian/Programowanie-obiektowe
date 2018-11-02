package agh.cs.lab2;

/**
 * Created by Student39 on 2018-10-09.
 */
public class CarSystem {
    public static  void main(String[] args){
        Position position1 = new Position(1,2);
        System.out.println(position1);
        Position position2 = new Position(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection a = MapDirection.EAST;
        System.out.println(a);
        a=a.next();
        System.out.println(a);
        a=a.previous();
        System.out.println(a);



        System.out.println();
        System.out.println();
        System.out.println();

        Car car = new Car();
        System.out.println(car);

        String tab[] = {"r", "f", "f", "f", "b", "b", "f"};
        for(MoveDirection kierunek : new OptionsParser().parse(tab)) {
            car.move(kierunek);
        }

        System.out.println(car);

    }
}
