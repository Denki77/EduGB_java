package Level1;

import java.util.Random;
import java.util.Scanner;

public class HWL3 {
    /**
     * Должен быть цвет в консоле
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(ANSI_RESET);
            System.out.println("Предлагаю сыграть в 2 игры!");
            System.out.println(ANSI_RED + "В первой:" + ANSI_RESET + " \t ** ты будешь угадывать число от 0 до 9 за 3 попытки **");
            System.out.println(ANSI_GREEN + "Во второй" + ANSI_RESET + ":\t ** ты угадаешь загаданное мною слово **");
            System.out.print("Введи " + ANSI_RED + "1" + ANSI_RESET + ", " + ANSI_GREEN + "2" + ANSI_RESET + " или 0, если захочешь уйти: ");
            if (!scanner.hasNextInt()) {
                System.out.println();
                System.out.println(ANSI_RED + "Аварийное завершение программы!" + ANSI_RESET);
                return;
            }
            int userChoose = scanner.nextInt();
            System.out.println();
            if (userChoose == 1) {
                runGame1();
            } else if(userChoose == 2) {
                runGame2();
            } else if(userChoose == 0) {
                System.out.println("Прощай мой верный друг.");
                break;
            }

        } while (true);

    }

    /**
     *Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки
     * угадать это число. При каждой попытке компьютер должен сообщить больше ли указанное пользователем
     * число чем загаданное, или меньше. После победы или проигрыша выводится запрос –
     * «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)
     */
    public static void runGame1(){

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int repeatGame = 0;

        do {
            int magicNumber = random.nextInt(10);
            System.out.println(ANSI_RED);
            System.out.println("Внимание! Я Великий ИИ загадал число от 0 до 9 включительно!");
            System.out.println("О, человечьшко! Тебе придётся отгадать его за 3 попытки.");
            System.out.println("Я скажу тебе про твоё число: больше оно, меньше или равно моему.");
            int attempt = 0;
            while (attempt < 3) {
                System.out.printf("Итак, введи своё число (попытка № %s): ", ++attempt);
                int userVar = scanner.nextInt();
                System.out.println();
                if (userVar == magicNumber) {
                    System.out.println("Мда, ты угадал. Прощай.");
                    break;
                } else if(attempt == 3){
                    System.out.printf("Ха-ха-ха! Ты проиграл! А я загадал: %s. \n", magicNumber);
                } else if (userVar > magicNumber) {
                    System.out.println("Твоё число больше моего.");
                } else {
                    System.out.println("Твоё число меньше моего.");
                }
            }

            System.out.print("Повторить игру еще раз? 1 – да / 0 – нет ");
            repeatGame = scanner.nextInt();

        } while (repeatGame == 1);
    }

    /**
     * 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot",
     * "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
     * "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
     * Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
     */
    public static void runGame2() {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println(ANSI_GREEN + "Я загадал одно из следующих слов:");
        for (int i = 0; i < words.length; i++){
            System.out.printf("%s, ", words[i]);
            if (i > 0 && i % 5 == 0){
                System.out.println();
            }
            if (i == words.length - 2){
                System.out.println(words[words.length - 1]);
                break;
            }
        }
        // Это позиция в массиве нашего загаданного числа
        int posInWordArr = random.nextInt(words.length);
        String secretWord = words[posInWordArr];
        while (true){
            System.out.println();
            System.out.print("Напиши мне слово, которое я загадал: ");
            String userWord = scanner.next();
            System.out.println();
            if(userWord.equals(secretWord)){
                System.out.println("Да, ты угадал!");
                break;
            }
            System.out.println("Пока не правильно, но я открою тебе буквы, которые ты угадал и если они есть:");
            for (int i = 0; i < 15; i++) {
                if (i >= secretWord.length() || i >= userWord.length() || secretWord.charAt(i) != userWord.charAt(i)){
                    System.out.print("#");
                }else {
                    System.out.print(secretWord.charAt(i));
                }
            }
        }
    }

}
