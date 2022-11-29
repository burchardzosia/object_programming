package agh.ics.oop;
import java.util.Random;
import java.lang.Math;
public class GrassField extends AbstractWorldMap{
    int size;

    public GrassField(int size){
        this.size=size;
        addingGrass(size);
    }
    private void addingGrass(int size) {
        Random generator = new Random();
        int x;
        int y;
        for (int i = 0; i < size; i++) {
            x = generator.nextInt((int) Math.sqrt(size * 10));
            y = generator.nextInt((int) Math.sqrt(size * 10));
            Vector2d grassPosition = new Vector2d(x, y);
            if (!isOccupied(grassPosition)) {
                grass object_grass=new grass(grassPosition);
                this.grassOnMap.put(grassPosition,object_grass);
            }
        }
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (objectAt(position) != null) {
            return objectAt(position) instanceof grass;
        }
        return true;
    }
    @Override
    public Vector2d RightBorder(){
        Vector2d upperRightVector= new Vector2d(0,0);
        for(Vector2d x:AnimalsOnMap.keySet()){
            upperRightVector=x.upperRight(upperRightVector);
        }
        for(Vector2d xG: grassOnMap.keySet()){
            upperRightVector=xG.upperRight(upperRightVector);

        }
        return upperRightVector;
    }



    @Override
    public Vector2d LeftBorder(){
        Vector2d LowerLeftVector=new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        for(Vector2d x:AnimalsOnMap.keySet()){
            LowerLeftVector=x.lowerLeft(LowerLeftVector);
        }
        for(Vector2d xG: grassOnMap.keySet()){
            LowerLeftVector=xG.lowerLeft(LowerLeftVector);

        }
        return LowerLeftVector;
    }



}