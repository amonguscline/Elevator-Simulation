import java.util.*;
public class Human {
    private ArrayList<Event> events = new ArrayList<>();
    private final double entropy;
    private final Building building;
    private Floor currentFloor;
    //calculate final interval, then get the presses intervals chain
    public Human(Building building, Interval arrivalInterval, double entropy){
        this.building=building;
        this.entropy=entropy;
        Interval timeInBuilding = getTimeInBuilding(arrivalInterval);
        System.out.println(timeInBuilding);
        events.add(new Enter(timeInBuilding.min(),this));
        generatePresses(timeInBuilding);
        events.add(new Exit(timeInBuilding.max(),this));   
    }

    private Interval getTimeInBuilding(Interval arrivalInterval){
        Sigmoid arrivalProbability = new Sigmoid(arrivalInterval);
        double arrivalTime = arrivalProbability.getRandomTime();
        Interval exitInterval = new Interval(arrivalTime, 1440);
        Sigmoid exitProbability = new Sigmoid(exitInterval);
        double exitTime = exitProbability.getRandomTime();
        return new Interval(arrivalTime, exitTime);
    }

    private void generatePresses(Interval timeInBuilding){
        //there's an issue if the difference is set to >0, as it will always have an interval of 1 and just infinite loop
        while(timeInBuilding.max()-timeInBuilding.min()>1){
            double nextPressTime=getNextPressTime(timeInBuilding);
            if(nextPressTime!=0){
                timeInBuilding=new Interval(nextPressTime, timeInBuilding.max());
                //change this to a floor of interest for the human
                Floor floor = new Floor(0);
                //System.out.println(nextPressTime);
                events.add(new Press(nextPressTime,this,floor));
            }
            else{break;}
        }
    }

    private double getNextPressTime(Interval pressInterval){
        Line pressLine = new Line(pressInterval, entropy);
        
        return pressLine.getRandomTime();
    }

    public ArrayList<Event> getEvents(){
        return events;
    }

    public void setFloor(Floor floor){
        //make this happen in the elevator
        if(this.currentFloor!=null){this.currentFloor.removeHuman(this);}
        this.currentFloor = floor;
        this.currentFloor.addHuman(this);
    }
}
