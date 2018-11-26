package agh.cs.lab2;

import java.io.IOException;
import java.util.List;

public class UnboundedMap extends AbstractWorldMap implements IWorldMap {
    private List<HayStack> hays;

    private Position lewyDolny;
    private Position prawyGorny;

    public UnboundedMap(List<HayStack> hays){
        this.hays=hays;

        if(hays.size()!=0)
            this.lewyDolny = hays.get(0).getPosition();
        else
            this.lewyDolny = new Position(0,0);
        this.prawyGorny = lewyDolny;

        for(HayStack hay: this.hays)
            setCorners(hay.getPosition());
    }

    public void setCorners(Position position){
        this.prawyGorny=position.upperRight(this.prawyGorny);
        this.lewyDolny=position.lowerLef(this.lewyDolny);
    }

    public String toString(IWorldMap map) throws InterruptedException {
        return new MapVisualizer(map).draw(this.lewyDolny, this.prawyGorny);
    }

    @Override
    public boolean place(Car car) {
        if(super.place(car)) {
            setCorners(car.getPosition());
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        for (HayStack actualHay : hays) {
            if(actualHay.getPosition().equals(position))
                return actualHay;
        }
        return super.objectAt(position);
    }

    public List<Car> getCars(){
        return cars;
    }
}
