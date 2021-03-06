package Level1;

import java.util.Scanner;

public class HWL4{

    static boolean firstStep = true;
    static int fieldLen = 3;
    static int r = 0;
    static int[][] finalScope;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        play(scanner);
    }

    static void play(Scanner scanner) {

        //System.out.print("Введи размерность поля: ");
        //fieldLen = scanner.nextInt();
        //System.out.println();

        char[][] field = getField(fieldLen);
        drawField(field);

        do {
            doPlayerMove(scanner, field);
            if (isFinal(field, 'X')) {
                break;
            }

            doAIMove(field);
            if (isFinal(field, 'O')) {
                break;
            }
            drawField(field);
        } while (true);

        System.out.println("Final score");
        drawField(field);
    }


    static boolean isFinal(char[][] field, char sign) {
        if (isWin(field, sign)) {
            String name = sign == 'X' ? "Player" : "AI";
            System.out.printf("%s won%n", name);
            return true;
        }
        if (isDraw(field)) {
            System.out.println("There is draw detected. Thanks god no one won!");
            return true;
        }
        return false;
    }

    /**
     * Проверка на победу
     */
    static boolean isWin(char[][] field, char sign) {

        int sumVert, sumGor, sumMainDi = 0, sumNotMainDi = 0;

        for (int i = 0; i < fieldLen; i++) {

            sumVert = 0;
            sumGor = 0;

            for (int j = 0; j < fieldLen; j++) {
                if (field[i][j] == sign) {
                    sumVert++;
                }
                if (field[j][i] == sign) {
                    sumGor++;
                }
                if (field[i][j] == sign && i == j) {
                    sumMainDi++;
                }
                if (field[i][j] == sign && fieldLen - 1 - j == i) {
                    sumNotMainDi++;
                }
            }

            if (sumVert == fieldLen || sumGor == fieldLen){
                return true;
            }
        }

        return sumMainDi == fieldLen || sumNotMainDi == fieldLen;
    }

    /**
     * Проверка на ничью
     * @param field array поле
     * @return bool draw
     */
    static boolean isDraw(char[][] field) {
        int count = fieldLen * fieldLen;

        for (int i = 0; i < fieldLen; i++) {
            for (int j = 0; j < fieldLen; j++) {
                if (field[i][j] != '-') {
                    count--;
                }
            }
        }
        return count == 0;
    }

    /**
     * Ход ИИ
     * В этот момент у нас по-любому есть хоть одна клетка свободная
     * @param field поле
     */
    static void doAIMove(char[][] field) {

        finalScope = new int[fieldLen][fieldLen];

        if (firstStep){
            firstStep = false;
            for (int i = 0; i < fieldLen; i++) {
                for (int j = 0; j < fieldLen; j++) {
                    finalScope[i][j] = 0;
                }
            }
        }

        int maxPer = -1, x = 0, y = 0;

        for (int i = 0; i < fieldLen; i++){
            for (int j = 0; j < fieldLen; j++){
                if (field[i][j] != '-' || finalScope[i][j] == -1){
                    finalScope[i][j] = -1;
                    continue;
                }

                finalScope[i][j] = getCombi(field, i, j, 'O', 0);
                System.out.println(r);

                if (maxPer <= finalScope[i][j]){
                    maxPer = finalScope[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        field[x][y] = 'O';
    }

    /**
     * Реализуем ИИ - попытка просчитать все варианты рекурсией
     * @param temporyField поле
     * @param i рассматриваемая строка
     * @param j рассматриваемый стоблец
     * @param symbol Х или 0
     * @return вес ячейки
     */
    private static int getCombi(char[][] temporyField, int i, int j, char symbol, int depth) {
        ++r;
        char[][] field = temporyField.clone();
        for(int k = 0; k < fieldLen; k++)
            field[k] = temporyField[k].clone();

        field[i][j] = symbol;

        if(isWin(field, symbol)){
            if (symbol == 'O') {
                return 2 + fieldLen - depth;
            } else {
                return 0;
            }
        }
        if(isDraw(field)){
            return 1;
        }

        int sumper = 0;

        for (int x = 0; x < fieldLen; x++){
            for (int y = 0; y < fieldLen; y++){
                if (-1 == finalScope[x][y] || '-' != field[x][y]){
                    continue;
                }
                if (symbol == 'O') {
                    symbol = 'X';
                } else {
                    symbol = 'O';
                }
                sumper += getCombi(field, x, y, symbol, depth - 1);
            }
        }

        return sumper;

    }

    /**
     * Ход пользователя
     * @param scanner сканер
     * @param field поле
     */
    static void doPlayerMove(Scanner scanner, char[][] field) {
        int x, y;
        do {
            x = getCoordinate(scanner, 'X', fieldLen);
            y = getCoordinate(scanner, 'Y', fieldLen);
        } while (field[x][y] != '-');
        field[x][y] = 'X';
    }

    static int getCoordinate(Scanner scanner, char coordName, int n) {
        int coord;
        do {
            System.out.print("Please input " + coordName + "-coordinate in range [1, " + n + "] ... ");
            coord = scanner.nextInt() - 1;
            System.out.println();
        } while (coord < 0 || coord > n - 1);
        return coord;
    }

    /**
     * Получить начально поле
      * @return поле
     */
    static char[][] getField(int n) {
        char[][] fields = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                fields[i][j] = '-';
            }
        }
        return fields;
    }

    /**
     * Рисуем поле
     * @param field поле
     */
    static void drawField(char[][] field) {
        System.out.println("Игровое поле: ");
        for (int i = 0; i < fieldLen; i++) {
            for (int j = 0; j < fieldLen; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
    static void drawField1(int[][] field) {
        System.out.println("Цифровое поле: ");
        for (int i = 0; i < fieldLen; i++) {
            for (int j = 0; j < fieldLen; j++) {
                System.out.print(field[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
