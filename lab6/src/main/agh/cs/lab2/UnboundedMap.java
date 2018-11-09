package agh.cs.lab2;

import java.io.IOException;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap implements IWorldMap {
    private Position lewyDolny;
    private Position prawyGorny;

    public UnboundedMap(){
        this.lewyDolny = new Position(0,0);
        this.prawyGorny = lewyDolny;
    }

    public void setCorners(Position position){
        this.prawyGorny=position.upperRight(this.prawyGorny);
        this.lewyDolny=position.lowerLef(this.lewyDolny);
    }

    public String toString(IWorldMap map) throws InterruptedException {
        return new MapVisualizer(map).draw(this.lewyDolny, this.prawyGorny);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return super.canMoveTo(position);
    }

    @Override
    public boolean placeCar(Car car) {
        if(super.placeCar(car)) {
            setCorners(car.getPosition());
            return true;
        }
        return false;
    }

    @Override
    public boolean placeHayStack(HayStack hay) {
        if(super.placeHayStack(hay)) {
            setCorners(hay.getPosition());
            return true;
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) throws InterruptedException, IOException {
        super.run(directions);
    }

    @Override
    public boolean isOccupied(Position position) {
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Position position) {
        return super.objectAt(position);
    }

    public List<Car> getCars(){
        return super.getCars();
    }
}
