package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {

    protected HashMap<Vector2d, grass> grassOnMap = new HashMap<>();
    protected HashMap<Vector2d, Animal> AnimalsOnMap = new HashMap<>();

    @Override
    public boolean isOccupied(Vector2d position) {return (objectAt(position)!=null);}

    @Override
    public Object objectAt(Vector2d position) {
        for (Vector2d x : AnimalsOnMap.keySet()){
            if(x.equals(position)){return AnimalsOnMap.get(position);}
        }
        for(Vector2d xG:grassOnMap.keySet()){
            if(xG.equals(position)){ return grassOnMap.get(position);}
        }
        return null;
    }
    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            AnimalsOnMap.put(animal.getPosition(),animal);
            animal.addObserver(this);
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
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = AnimalsOnMap.get(oldPosition);
        AnimalsOnMap.remove(oldPosition);
        AnimalsOnMap.put(newPosition, animal);
    }

}
