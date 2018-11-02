package agh.cs.lab2;

public class Car {
    private MapDirection orientacja;
    private int x;
    private int y;
    private Position pozycja;

    public Car() {
        this.x = 2;
        this.y = 2;
        this.pozycja = new Position(x, y);
        this.orientacja = MapDirection.NORTH;
    }

    public String toString() {
        return "Orientacja: " + orientacja + ", pozycja: " + pozycja;
    }

    public void move(MoveDirection direction) {
        Position newPosition;
        Position unitVector;
        if (direction.equals(MoveDirection.RIGHT))
            this.orientacja = this.orientacja.next();
        else if (direction.equals(MoveDirection.LEFT))
            this.orientacja = this.orientacja.previous();
        else if (direction.equals(MoveDirection.FORWARD)) {
            if (orientacja.equals(MapDirection.NORTH))
                ++this.y;
            else if (orientacja.equals(MapDirection.EAST))
                ++this.x;
            else if (orientacja.equals(MapDirection.SOUTH))
                --this.y;
            else if (orientacja.equals(MapDirection.WEST))
                --this.x;
        } else if (direction.equals(MoveDirection.BACKWARD)) {
            if (orientacja.equals(MapDirection.NORTH))
                --this.y;
            else if (orientacja.equals(MapDirection.EAST))
                --this.x;
            else if (orientacja.equals(MapDirection.SOUTH))
                ++this.y;
            else if (orientacja.equals(MapDirection.WEST))
                ++this.x;
        }
        if(this.x>=0 && this.x<=4 && this.y>=0 && this.y<=4)
            this.pozycja = new Position(this.x, this.y);
        else{
            this.x = pozycja.x;
            this.y = pozycja.y;
        }
    }

    public Position getPosition(){
        return this.pozycja;
    }
    public MapDirection getMapDirection(){
        return this.orientacja;
    }
}
