package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> AnimalsOnMap=new ArrayList<>();
    List<grass> grassOnMap=new ArrayList<>();

    @Override
    public boolean isOccupied(Vector2d position) {return (objectAt(position)!=null);}

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal x : AnimalsOnMap) {
            if(x.isAt(position)){return x;}
        }
        for(grass xG:grassOnMap){
            if(position.equals(xG.getPosition())){return xG;}
        }
        return null;
    }
    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            AnimalsOnMap.add(animal);
            return true;
        }
        return false;
    }

    public abstract  Vector2d LeftBorder();
    public abstract Vector2d RightBorder();
    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(this.LeftBorder(), this.RightBorder());
    }

}










