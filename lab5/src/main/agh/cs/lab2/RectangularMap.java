package agh.cs.lab2;

import java.io.IOException;
import java.util.List;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {
    public Position lewyDolny;
    public Position prawyGorny;

    public RectangularMap(int width, int height) {
        this.lewyDolny = new Position(0,0);
        this.prawyGorny = new Position(width-1, height-1);
    }

    public String toString(IWorldMap map) throws InterruptedException {
        return new MapVisualizer(map).draw(lewyDolny, prawyGorny);
    }

    @Override
    public boolean place(Car car) {
        return super.place(car);
    }

    public boolean canMoveTo(Position position) {
        return (position.larger(lewyDolny) && position.smaller(prawyGorny) && !isOccupied(position));
    }

    public void run(MoveDirection[] directions) throws InterruptedException, IOException {
        super.run(directions);
    }

    public boolean isOccupied(Position position) {
        return objectAt(position)!=null;
    }

    public Object objectAt(Position position) {
        return super.objectAt(position);
    }

    public List<Car> getCars(){
        return cars;
    }
}
