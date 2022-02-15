import com.eainde.assignment.EmployeeService;

import java.io.IOException;
import java.util.WeakHashMap;

public class EmployeeMain {

    public static void main(String args[]) throws IOException {
        EmployeeService es1 = new EmployeeService();
        System.out.println(es1.getAverageSalary());
    }
}
