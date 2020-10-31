package Level2;

import Level2.lesson2.MyArrayDataException;
import Level2.lesson2.MySizeArrayException;

public class HWL2 {
    /**
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
     * при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ
     * или текст вместо числа), должно быть брошено исключение MyArrayDataException,
     * с детализацией в какой именно ячейке лежат неверные данные.
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
     * MyArrayDataException, и вывести результат расчета.
     */
    public static void main(String[] args) {

        String[][] newArray = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "15", "1"},
                {"1", "O", "1", "1"},
        };

        System.out.println(checkArray(newArray));

    }

    public static int checkArray(String[][] arrayForCheck) {

        if (arrayForCheck.length != 4) {
            throw new MySizeArrayException("Error count rows are not 4");
        }

        for (int i = 0; i < 4; i++) {
            if (arrayForCheck[i].length != 4) {
                throw new MySizeArrayException("Error count cols are not 4 in line " + (i + 1));
            }
        }

        int sum = 0;

        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                try{
                    sum += Integer.parseInt(arrayForCheck[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Error data in [" + (i + 1) + "][" + (j + 1) + "] not integer", e);
                }
            }
        }

        return sum;

    }
}
