package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
public class Animal {
    private MapDirection orientation =MapDirection.NORTH;;
    private Vector2d position=new Vector2d(2,2);
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();
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
                    this.positionChanged(this.position, temp_position);
                    position=temp_position;
                }

            }
            case BACKWARD -> {
                temp_position = position.subtract(orientation.toUnitVector());
                if(map.canMoveTo(temp_position)){
                    this.positionChanged(this.position, temp_position);
                    position=temp_position;

                }

            }
        }


    }
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer:observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }


}
