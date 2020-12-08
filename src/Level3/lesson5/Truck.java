package Level3.lesson5;

public class Truck extends Vehicle implements Runnable {
    private final float volume = 60F;
    private final float consumption = 15F;
    private final float on_board;
    private final String name;

    public Truck(String name, float on_board) {
        this.on_board = on_board;
        this.name = name;
    }

    @Override
    public void run() {
        drive(name, on_board, consumption, volume);
    }
}
