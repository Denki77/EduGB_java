package Level2.lesson1;

public class Wall implements Barrier {

    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public int valueBarrier() {

        return this.height;

    }

    @Override
    public void whatIsIt() {
        System.out.println("It is a wall height = " + this.height);
    }

}
