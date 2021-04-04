package workInPair;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {
            DatabaseConnection.getConnection();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        DepartmentRepository departmentRepository = new DepartmentRepository();
        List<Department> departments = departmentRepository.findAll();

        for (Department department : departments) {
            System.out.println(department);
        }

        System.out.println(departmentRepository.findById(2));
        departmentRepository.deleteById(5);

        Department departmentToSave = new Department(5, "Research");
        departmentRepository.save(departmentToSave);

        Department departmentToUpdate = new Department(12, "Testing");
        DepartmentRepository.updateByName(departmentToUpdate, 2);

        List<Department> toFindSegment = DepartmentRepository.findByNameSegment("it");

        for (Department departmentings : toFindSegment) {
            System.out.println(departmentings);
        }
    }
}
