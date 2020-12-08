package Level3.lesson5;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static float capacity_fuel = 200F;

    public static boolean request(float amount) {
        lock.writeLock().lock();
        try {
            Thread.sleep(1500);

            if (amount <= capacity_fuel) {
                capacity_fuel -= amount;
                return true;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
        return false;
    }

    public static void info(){
        System.out.println("Capacity gas fuel = " + capacity_fuel);
    }
}
