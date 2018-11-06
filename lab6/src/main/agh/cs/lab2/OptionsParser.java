package agh.cs.lab2;

public class OptionsParser {
    public MoveDirection[] parse(String tablica[]){
        MoveDirection[] nowaTablica = new MoveDirection[tablica.length];
        int licznik=0;
        for(String a : tablica){
            if(a.equals("f") || a.equals("forward"))
                nowaTablica[licznik++]=MoveDirection.FORWARD;
            else if(a.equals("b") || a.equals("backward"))
                nowaTablica[licznik++]=MoveDirection.BACKWARD;
            else if(a.equals("r") || a.equals("right"))
                nowaTablica[licznik++]=MoveDirection.RIGHT;
            else if(a.equals("l") || a.equals("left"))
                nowaTablica[licznik++]=MoveDirection.LEFT;
            else throw new IllegalArgumentException(a + " is not legal move specification");
        }

        MoveDirection[] nowaTablica2 = new MoveDirection[licznik];
        for(int i=0;i<licznik;i++)
            nowaTablica2[i]=nowaTablica[i];
        return nowaTablica2;
    }
}
