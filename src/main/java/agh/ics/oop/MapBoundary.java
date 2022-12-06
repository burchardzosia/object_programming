package agh.ics.oop;
import java.util.Comparator;
import java.util.TreeSet;
public class MapBoundary implements IPositionChangeObserver{
    TreeSet<Vector2d> ArrayX = new TreeSet<>(Comparator.comparingInt(vector->(vector.x)));
    TreeSet<Vector2d> ArrayY = new TreeSet<>(Comparator.comparingInt(vector->(vector.y)));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        ArrayX.remove(oldPosition);



    }
    public void remove(Vector2d element){
        ArrayX.remove(element);
        ArrayY.remove(element);
    }
    public void add(Vector2d element){
        ArrayX.add(element);
        ArrayY.add(element);
    }
    public Vector2d upperRight(){
        Vector2d position = new Vector2d(ArrayX.last().x,ArrayY.last().y );
        return position;
    }
    public Vector2d lowerLeft(){
        Vector2d position = new Vector2d(ArrayX.first().x,ArrayY.first().y);
        return position;
    }
}
