package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GrassFieldTest {


    @Test
    void testField() {
        IWorldMap map = new GrassField (10);
        Vector2d pos=new Vector2d(2,2);
        Animal animal = new Animal(map,pos);
        assertTrue(map.place(animal));
        assertEquals(map.objectAt(pos), animal);
        assertTrue(map.isOccupied(pos));



    }


}
