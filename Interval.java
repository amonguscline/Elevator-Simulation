public record Interval(double min, double max) {
    public double getMidpoint(){
        return min+(max-min)/2;
    }
}
