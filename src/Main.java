public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Hi, Denis!");

        System.out.println(thirdTask(1, 0, 5, 4));
        System.out.println(thirdTask(10, 1, 50, 40));

        System.out.println(fourthTask(1, 0));
        System.out.println(fourthTask(10, 5));

        fifthTask(10);
        fifthTask(-1);

        System.out.println(sixthTask(-1));
        System.out.println(sixthTask(10));

        seventhTask("Denis");
        seventhTask("Mike");

        System.out.println(eighthTask(-1));
        System.out.println(eighthTask(10));
        System.out.println(eighthTask(12));
        System.out.println(eighthTask(100));
        System.out.println(eighthTask(1600));

    }

    /**
     * Создать переменные всех пройденных типов данных, и инициализировать их значения
     */
    static void secondTask (){

        byte s = 12;
        short ss = 325;
        int ssi = 5000;
        float d = 3F;
        double dd = 3D;

        String str = "Hi GB";

    }

    /**
     * Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода
     * @param a int
     * @param b int
     * @param c int
     * @param d int
     * @return double
     */
    static double thirdTask (int a, int b, int c, int d){
        return a * (b + ((double)c / d));
    }

    /**
     * Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах
     * от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
     * @return boolean
     */
    static boolean fourthTask (int a, int b){
        return (a + b) >= 10 && (a + b) <= 20;
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число,
     * метод должен напечатать в консоль положительное ли число передали,
     * или отрицательное; Замечание: ноль считаем положительным числом.
     */
    static void fifthTask (int a){
        if (a < 0){
            System.out.println("отрицательное");
        } else {
            System.out.println("положительное");
        }
    }

    /**
     * Написать метод, которому в качестве параметра передается целое число,
     * метод должен вернуть true, если число отрицательное;
     * @return mixed
     */
    static boolean sixthTask (int a){
        if (a < 0) {
            return true;
        }
        return false;
    }

    /**
     *  Написать метод, которому в качестве параметра передается строка, обозначающая имя,
     *  метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    static void seventhTask (String name){
        System.out.println("Привет, " + name);
    }

    /**
     * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
     * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     * @return boolean
     */
    static boolean eighthTask (int year){

        if(year <= 0) {
            return false;
        }

        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        }

        return (year % 4) == 0;

    }



}
