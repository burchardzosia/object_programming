package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;
public class SimulationEngine implements IEngine{
    private MoveDirection[] tab;
    private IWorldMap map;
    private Vector2d[] tabPosition;
    private List<Animal> animals;
    public SimulationEngine(MoveDirection[] tab,IWorldMap map, Vector2d[] tabPosition){
        this.tab=tab;
        this.map=map;
        this.tabPosition=tabPosition;
        this.animals = new ArrayList<>();
        for (Vector2d x :tabPosition ) {
            Animal animal=new Animal(map,x);
            if(map.place(animal)){
                this.animals.add(animal);
            }
        }
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
            }
        }


    }
}

