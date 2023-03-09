package agh.ics.oop;
import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.List;
public class SimulationEngine implements IEngine, Runnable{
    private MoveDirection[] tab;
    private IWorldMap map;
    private Vector2d[] tabPosition;
    private List<Animal> animals;
    private int moveDelay;
    private App app;
    public SimulationEngine(MoveDirection[] tab,IWorldMap map, Vector2d[] tabPosition,int moveDelay, App app){
        this.tab=tab;
        this.map=map;
        this.tabPosition=tabPosition;
        this.moveDelay = moveDelay;
        this.app = app;
        this.animals = new ArrayList<>();
        for (Vector2d x :tabPosition ) {
            Animal animal=new Animal(map,x);
            if(map.place(animal)){
                this.animals.add(animal);
            }
        }
    }
    public void addDirections(MoveDirection[] directions){
        this.tab = directions;
    }

    @Override
    public void run() {
        int tabLength=animals.size();
        Animal[] tabAnimals= new Animal[tabLength];
        animals.toArray(tabAnimals);
        int i=0;
        if(tabLength!=0){
            for (MoveDirection x :tab ) {
                tabAnimals[i%tabLength].move(x);
                i++;
                System.out.println(map);
                app.actualizeMap();
                try {
                    Thread.sleep(moveDelay);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

            }
        }


    }
}

