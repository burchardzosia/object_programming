package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class OptionParserTest {
    @Test
    void parseTest(){
        String[] array1 = {"b", "f", "r", "r"};
        OptionsParser parser = new OptionsParser();
        MoveDirection[] directions = {MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.RIGHT,
                MoveDirection.RIGHT};
        assertTrue(Arrays.equals(directions, parser.parser(array1)));
        String[] array2 = {"bsda", "f", "r", "r"};
        OptionsParser parser2 = new OptionsParser();
        Assertions.assertThrows(IllegalArgumentException.class, ()-> parser2.parser(array2));


    }

}
