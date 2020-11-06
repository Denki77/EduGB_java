package Level2.lesson4;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private String mark;
    private String model;
    private int age;

    public Car(String mark, String model, int age) {
        this.mark = mark;
        this.model = model;
        this.age = age;
    }

    @Override
    public int compareTo(Car o) {
        if (o.hashCode() < hashCode()) {
            return -1;
        } else if (o.hashCode() > hashCode()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return age == car.age &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, model, age);
    }
}
