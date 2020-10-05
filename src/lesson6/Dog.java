package lesson6;

public class Dog extends Animals{

    public Dog(String name){
        this.type_animal = "dog";
        this.name = name;

        this.max_distance_for_run = random.nextInt(1000);
        this.max_distance_for_swim = random.nextInt(100);
        this.max_height_for_jump = random.nextInt(5);
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
