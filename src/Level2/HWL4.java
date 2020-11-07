package Level2;

import Level2.lesson4.Car;
import Level2.lesson4.CarComparator;
import Level2.lesson4.MiniChat;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class HWL4 {
    /**
     * 1. Создать окно для клиентской части чата: большое текстовое поле для отображения переписки в центре окна.
     * Однострочное текстовое поле для ввода сообщений и кнопка для отсылки сообщений на нижней панели.
     * Сообщение должно отсылаться либо по нажатию кнопки на форме, либо по нажатию кнопки Enter.
     * При «отсылке» сообщение перекидывается из нижнего поля в центральное.
     * * 2. Создать TreeMap<String, Integer>. Данная коллекция по-умолчанию сортирует по ключу.
     * Сделать так, чтобы сортировка производилась на значению.
     * К примеру, при значениях 3, 10, 1 (значения ключений могут быть любыми) toString будет выводить всю структуру
     * отсортированную по значениями {"4"=1}, {"101"=3}, {"-1"=10}
     * @param args аргументы коммандной строки
     */
    public static void main(String[] args) {
        new MiniChat();

        Car bmw = new Car("BMW", "M235", 4);
        Car volga = new Car("VOLGA", "2303", 5);
        Car toyota = new Car("TOYOYA", "Camry", 1);
        Car mazda = new Car("MAZDA", "CX-5", 8);

        Map<Car, Integer> carMap = new TreeMap();

        carMap.put(bmw, 10);
        carMap.put(volga, 3);
        carMap.put(toyota, 14);
        carMap.put(mazda, 5);

        Comparator cppm = new CarComparator(carMap);
        Map<Car, Integer> sortedCarMap = new TreeMap(cppm);
        sortedCarMap.putAll(carMap);

        System.out.println(sortedCarMap);
    }
}
