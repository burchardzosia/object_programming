package agh.ics.oop;

public class world {
    public static void main(String[] args) {
        System.out.println("Start systemu!");
        Direction[] t = new Direction[args.length];
        int i = 0;
        for (String x : args) {
            switch (x) {
                case "f":
                    t[i] = Direction.NORTH;
                    break;
                case "b":
                    t[i] = Direction.SOUTH;
                    break;
                case "r":
                    t[i] = Direction.EAST;
                    break;
                case "l":
                    t[i] = Direction.WEST;
                    break;
            }
            i++;
        }
        run(t);
        System.out.println("koniec pracy!");
    }
    public static void run(Direction[] t) {
        for(int i=0;i<t.length-1;i++){
            System.out.println(t[i]+",");
        }
        System.out.println(t[t.length-1]);
        int i=0;
        System.out.println("Start");
        for(Direction x:t){
            i+=1;
            switch (x) {
                case NORTH->System.out.println("zwierzak chodzi do przodu!");
                case SOUTH->System.out.println("zwierzak chodzi do tyłu!");
                case WEST->System.out.println("zwierzak skręca w lewo!");
                case EAST->System.out.println("zwierzak skręca w prawo !");
            }
        }
        System.out.println("Stop");
    }
}
