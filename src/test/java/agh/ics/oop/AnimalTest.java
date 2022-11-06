package agh.ics.oop;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnimalTest {
    Animal animal1= new Animal();
    MoveDirection direction=MoveDirection.RIGHT;

    @Test
    void testForMove() {
        animal1.move(direction);
        assertEquals(animal1.toString() ,"Wschód,(2,2)");
        animal1.move(MoveDirection.RIGHT);
        assertEquals(animal1.toString() ,"Południe,(2,2)");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() ,"Południe,(2,3)");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() ,"Południe,(2,4)");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() ,"Południe,(2,4)");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString() ,"Wschód,(2,4)");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString() ,"Pólnoc,(2,4)");
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString() ,"Pólnoc,(2,4)");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() ,"Pólnoc,(2,3)");
        animal1.move(MoveDirection.LEFT);
        assertEquals(animal1.toString() ,"Zachód,(2,3)");
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString() ,"Zachód,(1,3)");
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString() ,"Zachód,(0,3)");
        animal1.move(MoveDirection.FORWARD);
        assertEquals(animal1.toString() ,"Zachód,(0,3)");
        animal1.move(MoveDirection.RIGHT);
        assertEquals(animal1.toString() ,"Pólnoc,(0,3)");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() ,"Pólnoc,(0,2)");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() ,"Pólnoc,(0,1)");
        animal1.move(MoveDirection.BACKWARD);
        assertEquals(animal1.toString() ,"Pólnoc,(0,0)");
        animal1.move(MoveDirection.RIGHT);
        assertEquals(animal1.toString() ,"Wschód,(0,0)");

    }
    @Test
    public void testPerser(){
        String[] direction= new String[]{"Forward","f","Backward","r","Left","k","z"};
        MoveDirection[] moveDirection= new MoveDirection[]{MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.BACKWARD,MoveDirection.RIGHT,MoveDirection.LEFT};
        assertArrayEquals(OptionsParser.parser(direction),moveDirection);
    }

}
