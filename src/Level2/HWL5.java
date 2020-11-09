package Level2;

public class HWL5 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {

        doSlowRunArray();
        doFastRunArray();

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

    private static void doFastRunArray() {
        long a = System.currentTimeMillis();
        System.out.println("Start fast method!");
        float[] arr = createMegaArray();
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            synchronized (arr) {
                for (int i = 0; i < h; i++) {
                    a1[i] = execValue(a1[i], i);
                }
                System.arraycopy(a1, 0, arr, 0, h);
            }
        });

        t1.setPriority(1);
        t1.start();

        // параллельное вычисление в потоке main
        for (int i = 0; i < h; i++) {
            a2[i] = execValue(a2[i], (i + h));
        }
        System.arraycopy(a2, 0, arr, h, h);

        doFinishString("fast", arr[h - 1], arr[size - 1], (System.currentTimeMillis() - a));
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
