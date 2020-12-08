package Level3.lesson5;

public class Bus extends Vehicle implements Runnable {
    private final float volume = 40F;
    private final float consumption = 7.5F;
    private float on_board;
    private String name;

    public Bus(String name, float on_board) {
        this.on_board = on_board;
        this.name = name;
    }

    @Override
    public void run() {
        drive(name, on_board, consumption, volume);
    }
}