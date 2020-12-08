package Level3.lesson5;

public class Car extends Vehicle implements Runnable {
    private final float volume = 20F;
    private final float consumption = 2.5F;
    private float on_board;
    private String name;

    public Car(String name, float on_board) {
        this.on_board = on_board;
        this.name = name;
    }

    @Override
    public void run() {
        drive(name, on_board, consumption, volume);
    }
}
