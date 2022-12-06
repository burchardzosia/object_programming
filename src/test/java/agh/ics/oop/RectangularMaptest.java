package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RectangularMaptest {


        @Test
        void IWorldMapTest(){
            IWorldMap map = new RectangularMap(5,5);
            Vector2d pos=new Vector2d(1,1);
            Vector2d pos2=new Vector2d(2,3);
            Vector2d pos3=new Vector2d(1,3);
            Animal animal = new Animal(map,pos);
            Animal animal2 = new Animal(map,pos2);
            Animal animal3=new Animal(map,pos3);
            Animal animal4=new Animal(map,pos);

            assertTrue(map.place(animal));
            assertTrue(map.place(animal2));
            assertTrue(map.place(animal3));
            Assertions.assertThrows(IllegalArgumentException.class, ()->map.place(animal3));
            assertEquals(map.objectAt(pos), animal);
            assertTrue(map.isOccupied(pos2));


        }

}
