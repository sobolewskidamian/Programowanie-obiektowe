package agh.cs.lab2;

public class HayStack implements IObject{
    private Position position;

    public HayStack(Position position){
        this.position = position;
    }

    public Position getPosition(){
        return this.position;
    }

    public String toString(){
        return "s";
    }
}
