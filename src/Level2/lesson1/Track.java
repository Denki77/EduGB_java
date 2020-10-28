package Level2.lesson1;

public class Track implements Barrier {

    private final int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public int valueBarrier() {

        return this.distance;

    }

    @Override
    public void whatIsIt() {
        System.out.println("It is a track distance = " + this.distance);
    }

}
