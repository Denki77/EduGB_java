package Level3.lesson5;

abstract class Vehicle {

    void drive(String name, float on_board, float consumption, float volume){
        try {
            System.out.println(name + " is drive.");

            while (on_board > consumption) {
                Thread.sleep(3000);
                on_board -= consumption;
                System.out.println(name + " has fuel = " + on_board);
            }

            System.out.println(name + " i need fuel!!!!");

            if (!refuel(volume - on_board)) {
                System.out.println(name + " no fuel for you(((");
                return;
            }

            drive(name, volume, consumption, volume);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    boolean refuel(float volumeFuelYouNeed) {
        FuelStation fuelStation = new FuelStation();
        return fuelStation.fill(volumeFuelYouNeed);
    }
}
