package agh.cs.lab1;
/**
 * Created by student17 on 2018-10-02.
 */
public class CarSystem {

    public static void run(String[] tab){

        Direction[] tablica = zamien(tab);
        for(Direction a : tablica){
            switch(a){
                case FORWARD:
                    System.out.println("Do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Do tyłu");
                    break;
                case RIGHT:
                    System.out.println("W prawo");
                    break;
                case LEFT:
                    System.out.println("W lewo");
                    break;
                default:
                    System.out.println("Stop");
                    break;
            }
        }
    }
    public static Direction[] zamien(String args[]){
        int licznik=0;

        Direction[] arguments = new Direction[args.length];

        for(String a : args){
            switch(a){
                case "f":
                    arguments[licznik]=Direction.FORWARD;
                    break;
                case "b":
                    arguments[licznik]=Direction.BACKWARD;
                    break;
                case "r":
                    arguments[licznik]=Direction.RIGHT;
                    break;
                case "l":
                    arguments[licznik]=Direction.LEFT;
                    break;
                default:
                    arguments[licznik]=Direction.NULL;
                    break;
            }
            licznik++;
        }
        return arguments;
    }

    public static void main(String args[]){
        System.out.println("Start systemu");
        System.out.println();
        run(args);
        System.out.println();
        System.out.println("Zakończenie działania systemu");
    }
}
