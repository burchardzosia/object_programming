package agh.ics.oop;
import java.util.ArrayList;
import java.util.HashMap;
public class Animal {
    private MapDirection orientation =MapDirection.NORTH;;
    private Vector2d position=new Vector2d(2,2);
    private IWorldMap map;
    private ArrayList<IPositionObserver> ObserversArray= new ArrayList();
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map=map;
    }

    @Override
    public String toString(){
        return switch (this.orientation){
        case EAST -> "E";
        case WEST -> "W";
        case NORTH -> "N";
        case SOUTH -> "S";
    };
    }

    public Vector2d getPosition(){
        return this.position;
    }
    public MapDirection getOrientation(){
        return this.orientation;
    }

    public boolean  isAt(Vector2d position){return this.position.equals(position);}

    void move(MoveDirection direction){
        Vector2d temp_position;
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD-> {

                temp_position = position.add(orientation.toUnitVector());
                if(map.canMoveTo(temp_position)){

                        position=temp_position;
                }

            }
            case BACKWARD -> {
                temp_position = position.subtract(orientation.toUnitVector());
                if(map.canMoveTo(temp_position)){
                    position=temp_position;
                }

            }
        }


    }
    public void addObserver(IPositionObserver observer){
        ObserversArray.add(observer);
    }

    public void removeObserver(IPositionObserver observer){
        ObserversArray.remove(observer);
    }

    private void positionChanged(Vector2d oldposition, Vector2d newposition){
        for(IPositionObserver observer: ObserversArray){
            observer.positionChanged(oldposition,newposition);
        }
    }


}
