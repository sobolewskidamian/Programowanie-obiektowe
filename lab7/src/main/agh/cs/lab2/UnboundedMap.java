package agh.cs.lab2;

public class UnboundedMap extends AbstractWorldMap {
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
    public boolean placeObject(IObject car) {
        if(super.placeObject(car)) {
            setCorners(car.getPosition());
            return true;
        }
        return false;
    }
}
