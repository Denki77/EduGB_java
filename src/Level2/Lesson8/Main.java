package Level2.Lesson8;

import Level2.Lesson8.impl.SingleLinkedList;

/**
 ** Разобраться с кодом. Односвязные список - это такое список, который хранит специальном внутреннем контейнере (узел)
 * значение и ссылку на следующий элемент. Важно отметить, что у последнего элемента ссылка будет пустая,
 * поскольку ссылаться ему попросту некуда. Это помогает динамически располагаться в памяти и не быть привязанным
 * к строго определенному участку памяти, как в случае с массивом
 ** Реализовать метод GBList#get(int index): String. Метод получает на вход значение N >= 0, где N - это
 * индекс элемента и если N находится в диапазоне фактической длины списка, то находит соответствующий элемент и
 * возвращает его, если нет - возращает NULL
 ** Реализовать двусвязный список. Двусвязный список - это такое список, который хранит специальном внутреннем
 * контейнере значение и ссылки на предыдущий и следующий элементы. Важно отметить, что ссылка первого элемента на
 * предыдущий всегда пустая, а для последнего - на следующий, поскольку в таких случая данным узлам не на что ссылаться
 * ** Реализовать итератор для связанного списка. Итератор - это механизм итерации по списку, который позволяет
 * переключаться от одного элемента к другому, пока не дойдет до конца, словно цикл. Важно отметить, что итератор
 * представляет собой экземпляр класса, а значит может быть создан несколько раз, и в каждом случае
 * старт будет начинаться с самого начала. Важно: Нельзя прибегать в циклам.
 * *** Итератор должен быть частью связанного списка, но при этом с легкостью может быть использован для реализации
 * в другом классе. К примеру, итератор для ArrayList или HashSet. Рекомендуется использовать интерфейсы с набором
 * абстрактных методов и\или абстрактные классы
 */
public class Main {
    public static void main(String[] args) {
        GBList list = new SingleLinkedList();
        list.add("BMW");
        list.add("TOYOTA");
        list.add("GAZ");
        list.add("TOYOTA");
        list.add("TOYOTA");
        list.add("TOYOTA");
        list.add("Mercedes");
        list.add("Mini");
        list.add("VW");
        list.add("Ferrari");
        list.add("Ferrari");
        list.add("Mercedes");
        list.add("Mini");
        list.add("VW");//index 13, and 12 after delete element
        list.add("Ferrari");
        list.add("Ferrari");

        System.out.println("Value element with index 13: " + list.get(13));

        System.out.println();
        System.out.println("*****Forward iterator:");
        GBIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }

        System.out.println();
        System.out.println("*****Backward iterator:");
        GBIterator backwardIterator = list.backwardIterator();
        while (backwardIterator.hasPrev()) {
            String prev = backwardIterator.prev();
            System.out.println(prev);
        }

        System.out.println();
        System.out.println(list);

        System.out.println();
        System.out.println("Size before remove " + list.size());

        boolean isToyotaRemoved = list.remove("TOYOTA");
        System.out.println("Is toyota removed? " + isToyotaRemoved);
        System.out.println("Size after remove " + list.size());
        System.out.println();
        System.out.println(list);

        System.out.println();
        System.out.println("Value element with index 12: " + list.get(12));
    }
}
