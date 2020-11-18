package Level2;

public class HWL5 {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arrForFast = new float[size];

    public static void main(String[] args) {

        doSlowRunArray();
        try {
            doFastRunArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void doSlowRunArray() {
        long a = System.currentTimeMillis();
        System.out.println("Start slow method!");
        float[] arr = createMegaArray();

        for (int i = 0; i < size; i++) {
            arr[i] = execValue(arr[i], i);
        }

        doFinishString("slow", arr[h - 1], arr[size - 1], (System.currentTimeMillis() - a));
    }

    private static void doFastRunArray() throws InterruptedException {
        long a = System.currentTimeMillis();
        System.out.println("Start fast method!");
        arrForFast = createMegaArray();
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arrForFast, 0, a1, 0, h);
        System.arraycopy(arrForFast, h, a2, 0, h);

        Thread t1 = new Thread(() -> createFinishArrayForFastMethod(a1, 0));

        Thread t2 = new Thread(() -> createFinishArrayForFastMethod(a2, h));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        doFinishString("fast", arrForFast[h - 1], arrForFast[size - 1], (System.currentTimeMillis() - a));
    }

    private static void createFinishArrayForFastMethod(float[] a, int stepValue) {
        for (int i = 0; i < a.length; i++) {
            a[i] = execValue(a[i], i + stepValue);
        }
        System.arraycopy(a, 0, arrForFast, stepValue, h);
    }

    private static float[] createMegaArray() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        return arr;
    }

    private static float execValue(float value1, float value2) {
        return (float) (value1 * Math.sin(0.2f + value2 / 5) * Math.cos(0.2f + value2 / 5) * Math.cos(0.4f + value2 / 2));
    }

    private static void doFinishString(String nameMethod, float middleValue, float lastValue, float timeToExec) {
        System.out.printf("Middle element for check: %s.%n", middleValue);
        System.out.printf("Last element for check: %s.%n", lastValue);
        System.out.printf("Time %s method: %sms.%n", nameMethod, timeToExec);
    }

}
