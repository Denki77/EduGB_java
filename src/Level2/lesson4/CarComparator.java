package Level2.lesson4;

import java.util.Comparator;
import java.util.Map;

public class CarComparator implements Comparator<Car> {
    private final Map<Car, Integer> map;

    public CarComparator(Map<Car, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(Car o1, Car o2) {

        return map.get(o1) - map.get(o2);
    }
}
