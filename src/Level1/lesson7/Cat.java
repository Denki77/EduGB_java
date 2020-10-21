package Level1.lesson7;

public class Cat {

    private final String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean eat (Plate plate) {

        System.out.print(this.name + ": ");

        if (plate.reduceAmountFood(this.appetite)){
            System.out.println("Ok, the food in plate enough for me. I`m lucky.");
            this.appetite = 0;
            return true;
        }

        System.out.println("Unfortunately, I didn't have enough food.");
        return false;

    }

    public void imFull () {

        System.out.print(this.name + " ");

        if (this.appetite == 0) {
            System.out.println("is full.");
        } else {
            System.out.println("is hungry.");
        }
    }

    public String getName (){
        return this.name;
    }
}
