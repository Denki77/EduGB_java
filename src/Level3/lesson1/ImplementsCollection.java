package Level3.lesson1;

import java.util.*;

/**
 * 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
 * 2. Написать метод, который преобразует массив в ArrayList;
 */
public class ImplementsCollection<T extends Object>  {

    private T[] simpleIterableObject;

    public ImplementsCollection(T ... simpleIterableObject) {
        this.simpleIterableObject = simpleIterableObject;
    }

    public T[] swapsTwoElements(int firstElement, int SecondElement){

        T element = this.simpleIterableObject[SecondElement];
        this.simpleIterableObject[SecondElement] = this.simpleIterableObject[firstElement];
        this.simpleIterableObject[firstElement] = element;
        return simpleIterableObject;

    }

    public ArrayList<T> refactorToArrayList() {
        ArrayList<T> returnArr = new ArrayList<T>();
        Collections.addAll(returnArr, this.simpleIterableObject);
        return returnArr;
    }

    @Override
    public String toString() {
        return "ImplementsCollection{" +
                "simpleIterableObject=" + Arrays.toString(simpleIterableObject) +
                '}';
    }
}
