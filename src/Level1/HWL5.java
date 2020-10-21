package Level1;

public class HWL5 {

    /**
     * Создать массив из 5 сотрудников;
     * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
     * @param args args
     */
    public static void main(String[] args) {

        Employee[] personsArray = new Employee[5];
        personsArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 200000, 30);
        personsArray[1] = new Employee("Petrov Petr", "SEO", "ivian@mailbox.com", "892325312", 150000, 30);
        personsArray[2] = new Employee("Sidorov Ivan", "Manager", "iivan@mailbox.com", "8923512312", 3000, 43);
        personsArray[3] = new Employee("Matveev Izi", "Java developer", "ivi@mailbox.com", "89234412312", 300000, 50);
        personsArray[4] = new Employee("Fomenkov Denis", "CEO", "noreply@mail.gov", "892312312", 30000, 38);

        System.out.println("Предпенсионные сотрудники (кому за 40):");
        System.out.println();
        for (int i = 0; i < personsArray.length; i++){
            if (personsArray[i].getAge() > 40) {
                personsArray[i].toSOutString();
            }
        }
    }
}
