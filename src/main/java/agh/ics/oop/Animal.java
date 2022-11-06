package agh.ics.oop;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }
    @Override
    public String toString(){return orientation +","+ position;}



    boolean isAt(Vector2d position){return this.position==position;}
    void move(MoveDirection direction){
        Vector2d temp_position;
        Vector2d vectorOne = new Vector2d(0,0);
        Vector2d vectorTwo = new Vector2d(4,4);
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD-> {
                temp_position = position.add(orientation.toUnitVector());
                if (temp_position.follows(vectorOne) && temp_position.precedes(vectorTwo)) {
                    position=temp_position;
                }
            }
            case BACKWARD -> {
                temp_position = position.subtract(orientation.toUnitVector());
                if (temp_position.follows(vectorOne) && temp_position.precedes(vectorTwo)) {
                    position=temp_position;
                }


            }
        }
    }



}
