import java.util.ArrayList;

public class Floor{
    private ArrayList<Human> humans = new ArrayList<>();
    public Floor(int floorNumber){
        
    }
    public void addHuman(Human h){
        humans.add(h);
    }
    public void removeHuman(Human h){
        humans.remove(humans.indexOf(h));
    }
}