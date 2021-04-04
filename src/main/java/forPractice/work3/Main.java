package forPractice.work3;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Employee employeeToSave = new Employee(1L, "Mikas", "Stanevicius", 5000);

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.createEmployee(employeeToSave);
        Employee employeeToFind = employeeDao.findEmployeeByID(1L);



    }
}
