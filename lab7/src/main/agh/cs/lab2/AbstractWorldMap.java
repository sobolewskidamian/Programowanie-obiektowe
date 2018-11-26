package agh.cs.lab2;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

abstract class AbstractWorldMap implements IPositionChangeObserver, IWorldMap{
    protected HashMap<Position,IObject> objects = new HashMap<>();
    protected List<Car> cars = new LinkedList<>();

    public boolean placeObject(IObject obj) {
        if (!isOccupied(obj.getPosition())) {
            this.objects.put(obj.getPosition(),obj);
            if(obj instanceof Car)
                this.cars.add((Car) obj);
            return true;
        }
        throw new IllegalArgumentException(obj.getPosition() + " jest już zajmowane");
    }

    public boolean isOccupied(Position position) {
        return objectAt(position)!=null;
    }

    public Object objectAt(Position position) {
        return objects.get(position);
    }

    public void run(MoveDirection[] directions) throws InterruptedException, IOException {
        List<Car> cars = getCars();

        for (int i = 0; i < directions.length; i++) {
            Car actualCar = cars.get(i % cars.size());
            Position actualPosition = actualCar.getPosition();
            Position vector = actualCar.getVector(directions[i]);
            Position afterMove = actualPosition.add(vector);
            if(canMoveTo(afterMove) || actualCar.getPosition().equals(afterMove)) {
                actualCar.move(directions[i]);
                setCorners(afterMove);
            }
            System.out.println(toString(actualCar.getMap()));
        }
    }

    public boolean canMoveTo(Position afterMove){
        return !isOccupied(afterMove);
    }

    public void positionChanged(Position oldPosition, Position newPosition) {
        if(!oldPosition.equals(newPosition)){
            Car obj = (Car) objects.get(oldPosition);
            obj.setPosition(newPosition);
            objects.remove(oldPosition);
            objects.put(newPosition,obj);
        }
    }

    protected List<Car> getCars(){
        return this.cars;
    }

    void setCorners(Position afterMove) {}

    protected abstract String toString(IWorldMap map) throws InterruptedException, IOException;
}
/*
2.i -       10 plików tylko będzie z orzeczeniami, w kazdym jest 100 orzeczeń,
2.ii. -     asci art
2.iii -     tekst nie musi byc sformatowany (textContent)
2.iv -      jedno pod drugim caseNumber - pierwsza wartosc w tej tablicy courtCases
2.v -       moze byc na dowolnej pozycji w skladzie sędziowskim
2.vi -      korzystac z klas, ktore oferuje Java, np. sortetSet lub sortedHashMap (imie i nazwisko identyfikuje sedziego, nie ma powtarzających sie)
2.vii -     ile spraw w styczniu, lutym itd
2.viii -    ile orzeczeń w sądach powszechnych, trybunale itd. (nie interesuje nas ile wydal wyrokow sąd apelacyjny)
2.ix -      mozemy identyfikowac po tytule ustawy, mozemy tez oprzeć się na złożonym kluczu (hgw jak) (od 2011 nie ma juz journal number), jest taka strona isap.sejm.gov.pl)
2.x -       ile przez jednego sedziego, ile przez dwoch, trzech itd
3. -        mamy polecenie z podaniem katalogu i pojawia się konsola, musi dzialac backspace, strzalki i byla w niej historia (uzycie biblioteki do konsoli w javie, czegos na bazie readline w unixie)
5. -        ladujemy tylko na poczatku programu
6. -        wczytujemy jsona i musimy przetworzyć na coś innego a nie pozostawić w JSONie

maven central - uzyte biblioteki muszą się tu znajdować
https://search.maven.org/search?q=g:org.json

nie ladujemy danych do systemu przechowywania danych, mamy to zaimplementowac w surowej javie używając bibliotek

2 pkt za konsultacje - częściowe rozwiązanie
3 pkt za jakość kodu w rozwiązaniu końcowym (nie ma dupllikacji, metody i zmienne mają odpowiednie nazwy itd)
3 pkt za spełnienie wymagań
+ nie wszystkie wymagania zostały podane (napisanie testow pomoze)
 */