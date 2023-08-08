import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeDatabase {

    public static List<Employee> addEmployee() {
        List<Employee> employees = new ArrayList<>();

        for(int i = 0; i < 100000; i++) {
            employees.add(new Employee(i, "random" + i, i*100));
        }

        return employees;
    }

}
