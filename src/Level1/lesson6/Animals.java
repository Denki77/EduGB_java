package Level1.lesson6;

import java.util.Random;

public abstract class Animals {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    protected String name;
    protected String type_animal;

    protected int max_distance_for_run;
    protected int max_distance_for_swim;
    protected int max_height_for_jump;

    protected Random random = new Random();

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public abstract void jump(int height);

    public void printDo(int value, int max_value, String method){
        if (max_value >= value) {
            System.out.println(name + " can do it (" + method + " to " + value + "m), because it is a " + type_animal);
        } else {
            System.out.println(name + ANSI_RED + " can`t do it" + ANSI_RESET + " (" + method + " to " + value + "m), because it is a " + type_animal);

        System.out.println(ANSI_GREEN + "*********************************************\n" +
                "For information: " + name + "(it is a " + type_animal + ") " +
                "can run to " + max_distance_for_run + "m, " +
                "can swim to " + max_distance_for_swim + "m, " +
                "can jump to " + max_height_for_jump + "m.\n" +
                "*********************************************" + ANSI_RESET);
        }
    }

}
