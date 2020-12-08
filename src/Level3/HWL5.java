package Level3;

import Level3.lesson5.Bus;
import Level3.lesson5.Car;
import Level3.lesson5.Truck;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Создать классы Car, Truck, Bus. Каждый обладает объемом топлива и расходом (Car - 20\2.5, Truck - 60\15,
 * Bus - 40\7.5) и уникальных значением для определения среди разных транспортных средств.
 * Для каждого транспортного средства оставшиеся в баке количество топлива вычисляется раз в 3 сек.
 * Создать до 10 экземпляров разных транспортных средств и запустить их в работу.
 * Создать класс GasPool. Обладает максимальными запасом топлива 200f и методами: request(float amount) -
 * для получения необходимого кол-ва топлива и info() - для выведения информации о фактическом состоянии.
 * Создать класс FuelStaion. Обладает свойством GasPool.
 * FuelStaion одновременно может заправлять только 3 автомобиля, остальные должны пока не освободится место
 * (порядок не имеет значения).
 * При заправке автомобиля запрашивается необходимое количество топливо, которое поступает из GasPool.
 * Необходимое топливо для автомобиля вычисляется на основании формулы R = C - F, где С это объем бака,
 * а F - фактическое состояние бака
 * Заправка занимает 5 сек, зачем транспортное средство освобождает место
 * * Транспортные средства должны выстраиваться в очередь, если нет свобожных мест для заправки и начинать заправку
 * в строгом порядке своей очередь
 * * Транспортные средства после заправки возвращаются на дорогу и продолжают свое движение
 *
 */

public class HWL5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Truck("truck1", 50F));
        executorService.submit(new Truck("truck2", 48F));
        executorService.submit(new Car("Car1", 10F));
        executorService.submit(new Car("Car2", 8F));
        executorService.submit(new Car("Car3", 10F));
        executorService.submit(new Car("Car4", 8F));
        executorService.submit(new Car("Car5", 10F));
        executorService.submit(new Bus("Bus3", 25F));
        executorService.submit(new Bus("Bus1", 10F));
        executorService.submit(new Bus("Bus2", 35F));
        executorService.shutdown();
    }
}
