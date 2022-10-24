package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class Vector2dTest {
    Vector2d vector = new Vector2d(1,2);
    Vector2d vector2 = new Vector2d(-1,2);
    Vector2d vector3 = new Vector2d(1,2);
    Vector2d vector4 = new Vector2d(4,5);
    Vector2d vector5 = new Vector2d(0,8);
    Vector2d vector6 = new Vector2d(0,0);
    Vector2d vector7 = new Vector2d(-4,-2);
    @Test
    void testForEquals() {
        assertNotEquals(vector,vector2);
        assertEquals(vector,vector3);
        assertNotEquals(3,vector);
    }
    @Test
    void testForToString() {
        assertEquals(vector.toString(),"(1,2)");
        assertEquals(vector2.toString(),"(-1,2)");
        assertNotEquals(vector,"(-1,2)");
    }
    @Test
    void testForPrecedes(){
        assertTrue(vector.precedes(vector4));
        assertFalse(vector4.precedes(vector5));
    }
    @Test
    void testForFollows(){
        assertTrue(vector4.follows(vector));
        assertFalse(vector4.follows(vector5));
    }
    @Test
    void testForUpperRight(){
        assertEquals(vector4.upperRight(vector),new Vector2d(4,5));
        assertEquals(vector7.upperRight(vector6),new Vector2d(0,0));
        assertNotEquals(vector5.upperRight(vector2),new Vector2d(2,5));

    }
    @Test
    void testForLowerLeft(){
        assertEquals(vector5.lowerLeft(vector6),new Vector2d(0,0));
        assertEquals(vector7.lowerLeft(vector6),new Vector2d(-4,-2));
        assertNotEquals(vector3.lowerLeft(vector2),new Vector2d(7,2));
    }
    @Test
    void testForAdd(){
        assertEquals(vector5.add(vector6),new Vector2d(0,8));
        assertEquals(vector6.add(vector7),new Vector2d(-4,-2));
    }
    @Test
    void testForSubtract(){
        assertEquals(vector5.subtract(vector6),new Vector2d(0,8));
        assertEquals(vector6.subtract(vector7),new Vector2d(4,2));
    }
    @Test
    void testOpposite(){
        assertEquals(vector3.opposite(),new Vector2d(-1,-2));
        assertEquals(vector6.opposite(),new Vector2d(0,0));
    }

}