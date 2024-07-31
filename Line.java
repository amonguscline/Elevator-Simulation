public class Line implements Function{
    public final Interval interval;
    public final double entropy;

    public Line(Interval interval, double entropy){
        this.entropy=entropy;
        this.interval=interval;
    }

    public double getRandomTime(){
        double random = Math.random();
        for(double t=interval.min();t<interval.max();t++){
            if(getChanceAtTime(t)>=random) {
                return t;
            }
        }
        return 0;
    }

    public double getChanceAtTime(double t){
        return (entropy*(t-interval.min()))/1440;
    }
}
