import java.util.*;

import javax.xml.stream.util.EventReaderDelegate;
public class Main {
    //I don't know where I should do event handling, human or main?
    public static Stack<Event> events = new Stack<>();
    public static Building building = new Building();
    public static void main(String args[]){
        for(int i=0;i<3;i++){
            double entropy = 10*Math.random();
            System.out.println(entropy);
            Human h = new Human(building, new Interval(0, 1440),entropy);
            
            for(Event e: h.getEvents()){
                events.add(e);
            }
        }
        events.sort((a,b)->{return (int) (a.time()-b.time());});
        while(events.size()>0){
            //create a tick system (Adapt what i got from chatgpt)
            Event e = events.pop();

        }
        
        System.out.println(events);
    }
}
