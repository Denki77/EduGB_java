class Employee {
    /**
     * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст
     */

    private String fio, position, email, phone;
    private int salary, age;

    /**
     * Конструктор класса должен заполнять эти поля при создании объекта;
     */
    public Employee(String fio, String position, String email, String phone, int salary, int age) {

        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    /**
     * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
     * не будем перегружать готовый
     */
    public void toSOutString()
    {

        System.out.println("FIO: " + this.fio + ", position: " + this.position + ", salary: " + this.salary + ";");
        System.out.println("Phone: " + this.phone + ", Email: " + this.email + ", age: " + this.age + ".");
        System.out.println();

    }

}
