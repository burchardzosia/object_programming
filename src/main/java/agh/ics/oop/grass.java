package agh.ics.oop;

import java.util.Random;

public class grass {
    Vector2d position;
    public grass(Vector2d grassPosition){
        this.position=grassPosition;


    }
    public Vector2d getPosition(){
        return this.position;
    }
    public String toString(){
        return "*";
    }

}

