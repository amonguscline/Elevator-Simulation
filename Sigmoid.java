public class Sigmoid implements Function{
    private final double mean;
    private final double difference;
    public final Interval i;

    public Sigmoid(Interval i){
        this.i=i;
        double mean = i.getMidpoint();
        this.mean=mean;
        this.difference=i.max()-i.min();
    }
    public double getRandomTime(){
        double random = Math.random();
        for(double t=i.min();t<i.max();t++){
            if(getChanceAtTime(t)>=random) {
                return t;
            }
        }
        return 0;
    }

    public double getChanceAtTime(double t){
        return 1/(1+Math.exp((-10/difference)*(t-mean)));
    }
}