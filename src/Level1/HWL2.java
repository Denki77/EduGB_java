package Level1;

import java.util.Random;

public class HWL2 {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();

        System.out.println("Ответ на задачу №6:");
        System.out.println("[2, 2, 2, 1, 2, 2, || 10, 1]: " + task6(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println("[1, 1, 1, || 2, 1]: " + task6(new int[]{1, 1, 1, 2, 1}));
        System.out.println("[100, 1, 1, 2, 1]: " + task6(new int[]{100, 1, 1, 2, 1}));
        System.out.println("[100, 1, 1,|| 2, 100]: " + task6(new int[]{100, 1, 1, 2, 100}));
        System.out.println();

        System.out.println("Ответ на задачу №7:");
        task7(new int[]{2, 2, 2, 1, 2, 2, 10, 1}, 2);
        task7(new int[]{2, 5, 2, 1, 8, 20, 18, 10, 4, 8, 55, 9}, 5);

    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    static void task1() {
        int[] arr = new int[10];
        System.out.println("Ответ на задачу №1:");
        Random random = new Random();
        System.out.print("Начальный массив: \t[");

        for(int i = 0; i < 10; ++i) {
            arr[i] = random.nextInt(2);
            System.out.printf("%2d", arr[i]);
        }

        System.out.println("]");
        System.out.print("Изменённый массив: \t[");

        for(int i = 0; i < 10; ++i) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }

            System.out.printf("%2d", arr[i]);
        }

        System.out.println("]");
        System.out.println();
    }

    /**
     * 2. Задать пустой целочисленный массив размером 8.
     * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    static void task2() {
        int[] arr = new int[8];
        System.out.println("Ответ на задачу №2:");
        System.out.print("Заполнение массива: ");

        for(int i = 0; i < 8; ++i) {
            arr[i] = i * 3;
        }

        System.out.println("Ok");
        System.out.print("Выводим массив: [");

        for(int i = 0; i < 8; ++i) {
            System.out.print(arr[i]);
            if (i < 7) {
                System.out.print(" ");
            }
        }

        System.out.println("]");
        System.out.println();
    }

    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
     * и числа меньшие 6 умножить на 2;
     */
    static void task3() {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Ответ на задачу №3:");
        System.out.print("Начальный массив: \t[");

        int i;
        for(i = 0; i < arr.length; ++i) {
            System.out.printf("%3d", arr[i]);
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }

        System.out.println("]");
        System.out.print("Выводим массив: \t[");

        for(i = 0; i < arr.length; ++i) {
            System.out.printf("%3d", arr[i]);
        }

        System.out.println("]");
        System.out.println();
    }

    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    static void task4() {
        final int n = 9;
        int[][] arr = new int[n][n];
        System.out.println("Ответ на задачу №4:");

        for(int i = 0; i < arr.length; ++i) {
            for(int j = 0; j < arr[i].length; ++j) {
                if (i == j || arr[i].length - 1 - j == i) {
                    arr[i][j] = 1;
                }

                System.out.printf("%2d", arr[i][j]);
            }

            System.out.println();
        }

        System.out.println();
    }

    /**
     * 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    static void task5() {
        int[] arr = new int[10];
        System.out.println("Ответ на задачу №5:");
        Random random = new Random();

        System.out.print("Начальный массив: \t[");
        for(int i = 0; i < arr.length; ++i) {
            arr[i] = random.nextInt(100);
            System.out.printf("%3d", arr[i]);
        }
        System.out.println("]");

        int min = arr[0];
        int max = arr[0];
        System.out.print("Ищем значения в массиве: ");

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("OK");
        System.out.printf("Минимальное значение в массиве равно\t%s\n", min);
        System.out.printf("Максимальное значение в массиве равно\t%s", max);
        System.out.println();
        System.out.println();
    }

    /**
     * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
     * если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     * граница показана символами ||, эти символы в массив не входят.
     * @param arr Входной массив
     * @return Результат
     */
    static boolean task6(int[] arr) {
        int s = arr[0];

        for(int i = 1; i < arr.length; ++i) {
            int interSum = 0;

            for(int j = i; j < arr.length; ++j) {
                interSum += arr[j];
            }

            if (s == interSum) {
                return true;
            }

            s += arr[i];
        }

        return false;
    }

    /**
     * 7. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     * при этом метод должен сместить все элементы массива на n позиций.
     * Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    static void task7(int[] arr, int n) {

        System.out.printf("Необходимо сместить элементы на %s позиций вправо.\n", n);

        System.out.print("Начальный массив: \t\t[");
        for(int i = 0; i < arr.length; ++i) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println("]");


        // Будем смещать по одному элементу n раз
        for (int i = 0; i < n; ++i){
            // Сохраним последний элемент
            int lastElem = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; --j){
                arr [j] = arr[j - 1];
            }
            arr[0] = lastElem;
        }
        System.out.print("Результирующий массив: \t[");
        for(int i = 0; i < arr.length; ++i) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println("]");
    }


}
