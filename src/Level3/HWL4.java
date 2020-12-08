package Level3;

import Level3.lesson4.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HWL4 {
    public static void main(String[] args) {
        ABC abc = new ABC();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(abc::printA);
        executorService.submit(abc::printB);
        executorService.submit(abc::printC);

        executorService.shutdown();
    }
}
