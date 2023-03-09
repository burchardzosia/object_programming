package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
public class Animal implements IMapElement{
    private MapDirection orientation =MapDirection.NORTH;;
    private Vector2d position=new Vector2d(2,2);
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<>();
    public Animal(IWorldMap map, Vector2d position){
        this.orientation = MapDirection.NORTH;
        this.position = position;
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

    @Override
    public String getImageSrc() {
        return switch (this.getOrientation()) {
            case SOUTH -> "src/main/resources/down.png";
            case WEST -> "src/main/resources/left.png";
            case NORTH -> "src/main/resources/up.png";
            case EAST -> "src/main/resources/right.png";
        };

    }

    public Vector2d getPosition(){
        return this.position;
    }
    public MapDirection getOrientation(){
        return this.orientation;
    }



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


    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer:observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }


}
