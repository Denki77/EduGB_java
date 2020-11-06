package Level2;

import java.util.Map;
import java.util.HashMap;

import Level2.lesson3.TelephoneDirectory;

public class HWL3 {
    /**
     * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
     * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
     * Посчитать сколько раз встречается каждое слово.
     * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
     * В этот телефонный справочник с помощью метода add() можно добавлять записи.
     * С помощью метода get() искать номер телефона по фамилии. Следует учесть,
     * что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
     * тогда при запросе такой фамилии должны выводиться все телефоны.
     *
     * @param args аргументы коммандной строки
     */
    public static void main(String[] args) {

        String[] arrayWords = {
                "mango", "potato", "car", "man", "white", "Washington", "Dog", "wash", "wish", "hope",
                "mango", "potato", "boy", "man", "white", "Washington", "Cat", "wash", "wash", "love",
        };

        HashMap<String, Integer> hm = new HashMap<>(32);

        for (String one_word: arrayWords){
            if (hm.containsKey(one_word)){
                hm.put(one_word, hm.get(one_word) + 1);
            } else {
                hm.put(one_word, 1);
            }
        }

        System.out.println("Список уникальных слов, из которых состоит массив, и их количество:");
        for (Map.Entry<String, Integer> one_value : hm.entrySet()) {
            System.out.println(one_value.getKey() + ": " + one_value.getValue());
        }

        System.out.println();
        System.out.println("Телефонный справочник деревни Рыбино:");
        TelephoneDirectory telephoneDir = new TelephoneDirectory();
        telephoneDir.add("Petrova", "79161234560");
        telephoneDir.add("Petrova", "79161234561");
        telephoneDir.add("Petrova", "79161234562");
        telephoneDir.add("Ivanova", "79161234563");
        telephoneDir.add("Sidorov", "79161234564");
        telephoneDir.add("Sidorov", "79161234565");
        telephoneDir.add("Sidorov", "79161234566");
        telephoneDir.add("Petrova", "79161234567");
        telephoneDir.add("Ivanova", "79161234568");
        telephoneDir.add("Sidorov", "79161234569");

        System.out.println("Petrova: " + telephoneDir.get("Petrova"));
        System.out.println("Ivanova: " + telephoneDir.get("Ivanova"));
        System.out.println("Sidorov: " + telephoneDir.get("Sidorov"));
        System.out.println("Matveev: " + telephoneDir.get("Matveev"));

    }
}
