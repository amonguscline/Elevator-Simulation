import java.util.*;
public class Elevator{
    enum State{
        UP,
        DOWN,
        IDLE
    };
    private int max=10;
    private ArrayList<Human> humans;
    private ArrayList<Event> requests; 
    private Floor currentFloor;
    private State state = State.IDLE;
    //make an energy amount that will discourage the neural net
    public Elevator(Floor startingFloor){
        currentFloor = startingFloor;
    }

    public void call(Event e){
        requests.add(e);
    }
    private void goToFloor(){
        //set state based on floor state
    }
    private void getNextState(Floor to){
        //compare to to currentfloor
        if(to.floorNumber()>currentFloor.floorNumber()){this.state=State.UP;}
        else if(to.floorNumber()<currentFloor.floorNumber()){this.state=State.DOWN;}
        
    }
}