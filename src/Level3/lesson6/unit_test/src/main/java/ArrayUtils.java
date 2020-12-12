public final class ArrayUtils {

    //private ArrayUtils() {}

    public static int[] giveMeSliceArrayAfterFour(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new RuntimeException("Error - empty array");
        }

        int idx = -1;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == 4) {
                idx = i + 1;
                break;
            }
        }

        if (idx == -1) {
            throw new RuntimeException("Empty array");
        }

        int size = numbers.length - idx;
        int[] foundValues = new int[numbers.length - idx];
        System.arraycopy(numbers, idx, foundValues, 0, size);

        return foundValues;
    }

    public static boolean findNumsInArray(int[] numbers) {
        boolean findOne = false, findFour = false;
        for (int number : numbers) {
            if (number == 4) {
                findFour = true;
            }
            if (number == 1) {
                findOne = true;
            }
            if (findOne && findFour) {
                return true;
            }
        }
        return false;
    }

}
