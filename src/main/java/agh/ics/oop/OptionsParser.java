package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parser(String[] args){
       List<MoveDirection> args2 = new ArrayList<MoveDirection>();
        for (String x : args) {
            switch (x) {
                case "Right","r" -> args2.add(MoveDirection.RIGHT);
                case "Left","l" -> args2.add(MoveDirection.LEFT);
                case "Forward","f" -> args2.add(MoveDirection.FORWARD);
                case "Backward","b" -> args2.add(MoveDirection.BACKWARD);
                default ->{
                }
            }
        }
        MoveDirection[] finalArgs= new MoveDirection[args2.size()];
        args2.toArray(finalArgs);
        return finalArgs;
    }
}
