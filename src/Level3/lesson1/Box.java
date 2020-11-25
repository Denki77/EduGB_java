package Level3.lesson1;

import static java.lang.Math.abs;

public class Box {
    private final Fruit boxWithFruit;
    private int countFruitsIntoBox = 0;

    public Box(Fruit boxWithFruit) {
        this.boxWithFruit = boxWithFruit;
    }

    public Fruit getFruitInTheBox(){
        return boxWithFruit;
    }

    public int addFruit(int colFruit){
        countFruitsIntoBox += colFruit;
        return countFruitsIntoBox;
    }

    public int getCountFruit(){
        return countFruitsIntoBox;
    }

    public void setCountFruitToZero(){
        countFruitsIntoBox = 0;
    }

    public float getWeight() {
        return countFruitsIntoBox * boxWithFruit.getOneFruitWeight();
    }

    public boolean compare(Box compareBox) {
        return abs(compareBox.getWeight() - this.getWeight()) < 0.001;
    }

    public boolean pourItHere(Box fromBox){
        if(!boxWithFruit.getClass().toString().equals(fromBox.getFruitInTheBox().getClass().toString())){
            return false;
        }
        this.addFruit(fromBox.getCountFruit());
        fromBox.setCountFruitToZero();
        return true;
    }


}
