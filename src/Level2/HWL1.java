package Level2;

import Level2.lesson1.*;

public class HWL1 {

    /**
     * Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
     * Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
     * Создайте два класса: беговая дорожка и стена, при прохождении через которые,
     * участники должны выполнять соответствующие действия (бежать или прыгать),
     * результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
     * Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
     * * У препятствий есть длина (для дорожки) или высота (для стены),
     * а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий,
     * то дальше по списку препятствий он не идет.
     */
    public static void main(String[] args) {

        Behavior[] someBeing = {
                new Man("Max", 10, 5),
                new Man("Olga", 50, 3),
                new Cat("Kisa", 150, 25),
                new Cat("Murka", 100, 30),
                new Robot("Terminator", 10000, 1),
                new Robot("RoboCop", 1000, 0),
        };

        Barrier[] someMarathon = {
                new Track(5),
                new Wall(1),
                new Track(50),
                new Wall(4),
                new Track(150),
                new Wall(24)
        };

        for (Barrier barier : someMarathon) {

            barier.whatIsIt();

            for (Behavior being : someBeing) {
                if (being.getiInPlay()) {
                    being.WhoIAm();
                    if (barier instanceof Wall) {
                        being.jump(barier.valueBarrier());
                    }
                    if (barier instanceof Track) {
                        being.run(barier.valueBarrier());
                    }
                }
            }

        }
    }
}
