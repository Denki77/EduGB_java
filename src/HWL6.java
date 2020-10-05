import lesson6.Cat;
import lesson6.Dog;

public class HWL6 {
    /**
     * 1. Создать классы Собака и Кот с наследованием от класса Животное.
     * 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
     * 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
     * 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
     * 5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
     */
    public static void main(String[] args) {

        Cat kitten = new Cat("Mini");
        kitten.jump(10);
        kitten.swim(50);
        kitten.run(1);
        System.out.println();
        System.out.println();

        Cat kitty = new Cat("Barsik");
        kitty.jump(1);
        kitty.swim(5);
        kitty.run(5);
        System.out.println();
        System.out.println();

        Dog puppy = new Dog("Jonny");
        puppy.jump(10);
        puppy.swim(50);
        puppy.run(1);
        System.out.println();
        System.out.println();

        Dog boss = new Dog("Rex");
        boss.jump(5);
        boss.swim(50);
        boss.run(100);
    }
}
