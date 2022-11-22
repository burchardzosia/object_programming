package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
public class RectangularMap extends AbstractWorldMap  {
    int width;
    int height;
    private final List<Animal> MapAnimals=new ArrayList<>();
    public RectangularMap(int width, int height){
        this.width= width;
        this.height = height;

    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(width-1,height-1)) && !isOccupied(position);
    }



    @Override
    public Vector2d LeftBorder() {return new Vector2d(0,0);}


    @Override
    public Vector2d RightBorder() {return new Vector2d(this.width,this.height);}




}
