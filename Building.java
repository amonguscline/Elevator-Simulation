
import java.util.*;
public class Building{
    private Floor[] floors = new Floor[(int) (Math.random()*9)+1];
    public Building(){
       for(int i=0;i<floors.length;i++){floors[i]=new Floor(i);}
       Elevator elevator = new Elevator(floors[0]);
    }
    
}