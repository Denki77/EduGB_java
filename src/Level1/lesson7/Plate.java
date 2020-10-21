package Level1.lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("In the plate: " + food + " units food.");
    }

    public boolean reduceAmountFood (int appetite) {
        if (appetite <= this.food){
            this.food -= appetite;
            return true;
        }
        return false;
    }

    public void addFoodIntoPlate (int food) {
        this.food += food;
        System.out.println("We added " + food + " units food.");
        info();
    }

}