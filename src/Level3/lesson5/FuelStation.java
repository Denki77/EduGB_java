package Level3.lesson5;

import java.util.concurrent.Semaphore;

public class FuelStation {
    private Semaphore semaphore = new Semaphore(3);

    public boolean fill(float volumeFuelYouNeed){
        try {
            semaphore.acquire();
            Thread.sleep(5000);
            boolean result = GasPool.request(volumeFuelYouNeed);

            GasPool.info();

            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

        return false;
    }
}
