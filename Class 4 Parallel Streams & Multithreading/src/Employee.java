public class Employee {

    int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    String name;
    int salary;

}
