package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GrassFieldTest {
    IWorldMap map = new GrassField(10);
    Vector2d vector1 = new Vector2d(2,7);
    Vector2d vector2 = new Vector2d(2,8);
    Vector2d vector3 = new Vector2d(2, 3);
    Animal animal1 = new Animal(map, vector1);
    Animal animal2 = new Animal(map, vector2);
    Animal animal3 = new Animal(map, vector3);
    Animal animal4 = new Animal(map, vector3);
    @Test
    void testField() {
        map.place(animal1);
        map.place(animal2);
        map.place(animal3);
        map.place(animal4);
        assertFalse(map.canMoveTo(vector1));
        assertFalse(map.canMoveTo(vector2));
        assertFalse(map.canMoveTo(vector3));
        assertTrue(map.canMoveTo(new Vector2d(3,5)));
        assertTrue(map.canMoveTo(new Vector2d(-4,0)));


    }


}
