package Level3;

import Level3.lesson7.*;

/**
 * Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов с
 * аннотациями @Test. Для этого у него должен быть статический метод start(), которому в качестве параметра
 * передается или объект типа Class, или имя класса.
 * Из «класса-теста» вначале должен быть запущен метод с
 * аннотацией @BeforeSuite, если такой имеется, далее запущены методы с аннотациями @Test, а по завершению
 * всех тестов – метод с аннотацией @AfterSuite.
 * К каждому тесту необходимо также добавить приоритеты (int
 * числа от 1 до 10), в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый,
 * то порядок не имеет значения.
 * Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном
 * экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».
 */
public class HWL7 {
    public static void main(String[] args) throws Exception {

        TesterClass testerClass = new TesterClass();

        testerClass.start("Level3.lesson7.ClassForTest");

        Class<?> class_name = Level3.lesson7.ClassForTest2.class;
        testerClass.start(class_name);

    }
}
