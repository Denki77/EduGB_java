package Level3.lesson7;

import java.lang.reflect.Method;
import java.util.*;

public class TesterClass {
    private Class<?> class_for_test;

    public void start(String class_name) throws Exception {
        start(Class.forName(class_name));
    }

    public void start(Class<?> class_for_test) throws Exception {
        this.class_for_test = class_for_test;

        System.out.println("Run test class: " + class_for_test.getSimpleName());
        Method[] baArrMethods = checkUniqAnnotations();

        /**
         * run method with before annotation
         */
        if (baArrMethods[0] != null) {
            System.out.println("Run Before Annotation:");
            baArrMethods[0].invoke(this.class_for_test.getDeclaredConstructor().newInstance());
        }

        System.out.println("Run tester methods class.");
        runTestMethods();

        /**
         * run method with after annotation
         */
        if (baArrMethods[1] != null) {
            System.out.println("Run After Annotation:");
            baArrMethods[1].invoke(this.class_for_test.getDeclaredConstructor().newInstance());
        }

        System.out.println("Stop class: " + class_for_test.getSimpleName());
        System.out.println();
        System.out.println();
    }

    /**
     * Проверка уникальности афтер и бефоре аннотаций
     */
    private Method[] checkUniqAnnotations() {
        Method[] methods = this.class_for_test.getDeclaredMethods();
        boolean checkBeforeAnnotation = false,
                checkAfterAnnotation = false;

        Method[] returnBAMethods = {null, null};

        for (Method o : methods) {
            if (o.getAnnotation(BeforeSuite.class) != null) {
                if (checkBeforeAnnotation) {
                    throw new RuntimeException("We have more then one BeforeSuite Annotations");
                }
                checkBeforeAnnotation = true;
                returnBAMethods[0] = o;
            }
            if (o.getAnnotation(AfterSuite.class) != null) {
                if (checkAfterAnnotation) {
                    throw new RuntimeException("We have more then one AfterSuite Annotations");
                }
                checkAfterAnnotation = true;
                returnBAMethods[1] = o;
            }
        }

        return returnBAMethods;
    }

    /**
     * запуск тестовых методов по их приоритету
     */
    private void runTestMethods() throws Exception {
        Map<Integer, ArrayList<Method>> sortedMethodsArr = new TreeMap<>();

        Method[] methods = this.class_for_test.getDeclaredMethods();

        for (Method o : methods) {
            if (o.getAnnotation(Test.class) != null) {
                Test annotation = o.getAnnotation(Test.class);
                int priority = annotation.priority();
                sortedMethodsArr.computeIfAbsent(priority, k -> new ArrayList<>());
                sortedMethodsArr.get(priority).add(o);
            }
        }
        for (Map.Entry<Integer, ArrayList<Method>> entry : sortedMethodsArr.entrySet()) {

            System.out.println("Priority ot test: " + entry.getKey());
            for (Method methodForInvoke : entry.getValue()) {
                methodForInvoke.invoke(this.class_for_test.getDeclaredConstructor().newInstance());
            }
        }
    }


}
