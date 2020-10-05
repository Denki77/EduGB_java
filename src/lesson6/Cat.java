package lesson6;

import java.util.Random;

public class Cat extends Animals{

    public Cat(String name){
        this.type_animal = "cat";
        this.name = name;

        this.max_distance_for_run = random.nextInt(200);
        this.max_distance_for_swim = 0;
        this.max_height_for_jump = random.nextInt(10);
    }

    @Override
    public void run(int distance) {
        printDo(distance, max_distance_for_run, "run");
    }

    @Override
    public void swim(int distance) {
        printDo(distance, max_distance_for_swim, "swim");
    }

    @Override
    public void jump(int height) {
        printDo(height, max_height_for_jump, "jump");
    }
}
