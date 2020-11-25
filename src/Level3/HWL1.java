package Level3;

import Level3.lesson1.*;

/**
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 * 3. Большая задача:
 * a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
 * b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
 * поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * c. Для хранения фруктов внутри коробки можете использовать ArrayList;
 * d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
 * (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
 * e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
 * которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае
 * (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
 * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
 * (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в
 * текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
 * g. Не забываем про метод добавления фрукта в коробку.
 */
public class HWL1 {

    public static void main(String[] args) {

        Integer[] arLi = {12, 12, 3, 5, 51, 5};
        String[] arLi2 = {"12", "bb", "mamme", "plate", "capital", "enough"};

        ImplementsCollection<Integer> firstTest = new ImplementsCollection<Integer>(12,13,15,16,20,21);
        ImplementsCollection<Integer> secondTest = new ImplementsCollection<Integer>(arLi);
        ImplementsCollection<String> thirdTest = new ImplementsCollection<String>(arLi2);

        System.out.println("First test");
        System.out.println(firstTest.toString());
        firstTest.swapsTwoElements(4,1);
        System.out.println(firstTest);
        System.out.println(firstTest.refactorToArrayList());

        System.out.println("Second test");
        System.out.println(secondTest.toString());
        secondTest.swapsTwoElements(4,1);
        System.out.println(secondTest);
        System.out.println(secondTest.refactorToArrayList());

        System.out.println("Third test");
        System.out.println(thirdTest.toString());
        thirdTest.swapsTwoElements(4,1);
        System.out.println(thirdTest);
        System.out.println(thirdTest.refactorToArrayList());

        Fruit orange = new Orange();
        Fruit apple = new Apple();

        Box appleBox = new Box(apple);
        Box orangeBox = new Box(orange);

        Box otherAppleBox = new Box(apple);
        Box otherOrangeBox = new Box(orange);

        orangeBox.addFruit(5);
        otherOrangeBox.addFruit(3);

        appleBox.addFruit(73);
        System.out.println(appleBox.getWeight());
        otherAppleBox.addFruit(8);
        System.out.println(otherAppleBox.getWeight());
        appleBox.pourItHere(otherAppleBox);
        System.out.println(appleBox.getWeight());
        System.out.println(otherAppleBox.getWeight());

        System.out.println(otherAppleBox.pourItHere(orangeBox));
        otherAppleBox.pourItHere(otherOrangeBox);
        System.out.println(otherAppleBox.getWeight());

        otherAppleBox.addFruit(12);
        orangeBox.pourItHere(otherOrangeBox);
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox.compare(otherAppleBox));

        /**
         * Вообще эта реализация без дженериков, но задача выполнена!
         */
    }
}
