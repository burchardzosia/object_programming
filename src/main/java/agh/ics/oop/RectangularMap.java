package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
public class RectangularMap implements IWorldMap  {
    int width;
    int height;
    private final List<Animal> MapAnimals= new ArrayList<>();
    public RectangularMap(int width, int height){
        this.width= width;
        this.height = height;

    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(width-1,height-1)) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())){
            MapAnimals.add(animal);
            return true;
        }
    return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal x : MapAnimals) {
            if(x.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal x : MapAnimals) {
            if(x.isAt(position)){
                return x;
            }
        }
    return null;
    }
    @Override
    public String toString(){
        MapVisualizer graphic= new MapVisualizer(this);
        return graphic.draw(new Vector2d(0,0), new Vector2d(width-1,height-1));
    }

}
