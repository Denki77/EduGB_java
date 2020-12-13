package Level3.lesson7;

public class ClassForTest2 {
    @BeforeSuite
    public int beforeTest() {
        System.out.println("B test");
        return 0;
    }

    @Test
    public int doFirstTest() {
        System.out.println("1 test");
        return 1;
    }

    @Test(priority = 2)
    public int doSecondTest() {
        System.out.println("2 test");
        return 2;
    }

    @Test(priority = 2)
    public int doThirdTest() {
        System.out.println("3 test");
        return 3;
    }

    @Test(priority = 2)
    public int doFourthTest() {
        System.out.println("4 test");
        return 4;
    }

    @Test
    public int doFifthTest() {
        System.out.println("5 test");
        return 5;
    }


}
