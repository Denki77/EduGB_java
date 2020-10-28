package Level2.lesson1;

public class Cat implements Behavior {

    private final String name;
    private final int maxRun;
    private final int maxJump;
    private Boolean iInPlay = true;

    public Cat(String name, int maxRun, int maxJump) {

        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;

    }

    @Override
    public void run(int distance) {

        if (this.maxRun < distance && this.iInPlay) {
            System.out.println(this.WhoIAm() + ": Sorry I can`t do it. I`m fail.");
            this.iInPlay = false;
        } else if (this.iInPlay) {
            System.out.println(this.WhoIAm() + " do run");
        }

    }

    @Override
    public void jump(int height) {

        if (this.maxJump < height && this.iInPlay) {
            System.out.println(this.WhoIAm() + ": Sorry I can`t do it. I`m fail.");
            this.iInPlay = false;
        } else if (this.iInPlay) {
            System.out.println(this.WhoIAm() + " do jump");
        }

    }

    @Override
    public String WhoIAm() {

        return this.name + " is a " + this.getClass().getSimpleName();

    }

    @Override
    public Boolean getiInPlay() {

        return this.iInPlay;

    }

}
