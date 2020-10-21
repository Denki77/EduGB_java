package Level1;

import Level1.lesson7.Cat;
import Level1.lesson7.Plate;

/**
 * 1. Расширить задачу про котов и тарелки с едой (задача в методичке)
 * 2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
 * 3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
 * 4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
 * 5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
 * 6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
 */

public class HW7 {

    public static void main(String[] args) {

        Plate plate = new Plate(100);
        plate.info();

        Cat[] cats = {
                new Cat("Barsik", 5),
                new Cat("Marsik", 50),
                new Cat("Tubik", 20),
                new Cat("Missi", 40),
                new Cat("Merlin", 500),
                new Cat("Orjin", 30),
        };

        for (int i = 0; i < cats.length; i++){
            System.out.printf("Hi kitty %s, you should eat.\n", cats[i].getName());

            while (!cats[i].eat(plate)){
                cats[i].imFull();
                System.out.printf("%s: meow-meow-meow...\n", cats[i].getName());
                plate.addFoodIntoPlate(100);
            }

            cats[i].imFull();
            plate.info();
            System.out.println();
        }



    }
}
