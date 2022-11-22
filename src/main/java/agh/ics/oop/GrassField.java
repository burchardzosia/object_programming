package agh.ics.oop;


import java.util.ArrayList;
import java.util.List;
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
                this.grassOnMap.add(object_grass);
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
        Vector2d upperRightVector=AnimalsOnMap.get(1).getPosition();
        for(Animal x:AnimalsOnMap){
            upperRightVector=x.getPosition().upperRight(upperRightVector);
        }
        for(grass xG: grassOnMap){
            upperRightVector=xG.getPosition().upperRight(upperRightVector);

        }
        return upperRightVector;
    }



    @Override
    public Vector2d LeftBorder(){
        Vector2d LowerLeftVector=AnimalsOnMap.get(1).getPosition();
        for(Animal x:AnimalsOnMap){
            LowerLeftVector=x.getPosition().lowerLeft(LowerLeftVector);
        }
        for(grass xG: grassOnMap){
            LowerLeftVector=xG.getPosition().lowerLeft(LowerLeftVector);

        }
        return LowerLeftVector;
    }



}