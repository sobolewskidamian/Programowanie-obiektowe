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
        }

        MoveDirection[] nowaTablica2 = new MoveDirection[licznik];
        int a=0;
        for(int i=0;i<tablica.length;i++){
            if(nowaTablica[i] != null){
                nowaTablica2[a]=nowaTablica[i];
                a++;
            }
        }
        return nowaTablica2;
    }
}
