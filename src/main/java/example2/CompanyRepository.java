package example2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private Connection connection;

    public List<Company> findAll() throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM company";
        Statement statement = connection.createStatement();
        //ResultSet resultSet = connection.createStatement().executeQuery(sql); //simplified
        ResultSet resultSet = statement.executeQuery(sql);
        List<Company> companies = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String companyName = resultSet.getString("companyName");
            String address = resultSet.getString("address");
            int budget = resultSet.getInt("budget");
            int employeeCount = resultSet.getInt("employeeCount");
            companies.add(new Company(id, companyName, address, budget, employeeCount));
        }
        //Closing logic here
        return companies;
    }

    public Company findById(int companyId) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql_By_Id = "SELECT * FROM company WHERE id = " + companyId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql_By_Id);


        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String companyName = resultSet.getString("companyName");
            String address = resultSet.getString("address");
            int budget = resultSet.getInt("budget");
            int employeeCount = resultSet.getInt("employeeCount");
            return new Company(id, companyName, address, budget, employeeCount);

        }
        return null;
    }

    public void save(Company company) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = String.format("INSERT INTO company VALUES(DEFAULT, '%s', '%s', %d, %d);",
                company.getCompanyName(),
                company.getAddress(),
                company.getBudget(),
                company.getEmployeeCount());
        Statement statement = connection.createStatement();
        int insertedRows = statement.executeUpdate(sql);
        System.out.println("Insert statement status: " + (insertedRows == 1 ? "Ok" : "No inserted"));

    }

    public void deleteById(int companyId) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = "DELETE FROM company WHERE id = " + companyId;
        Statement statement = connection.createStatement();
        int deletedRows = statement.executeUpdate(sql);
        if(deletedRows > 0) {
            System.out.println("Deleted " + deletedRows + " rows.");
        } else {
            System.out.println("Nothing was deleted.");
        }
    }

    public List<Company> findByName(String companyName) throws SQLException {
        connection = DatabaseUtils.getConnection();
        String sql = "SELECT * FROM company WHERE companyName = '" + companyName + "'";
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        List<Company> companies = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("companyName");
            String address = resultSet.getString("address");
            int budget = resultSet.getInt("budget");
            int employeeCount = resultSet.getInt("employeeCount");
            companies.add(new Company(id, name, address, budget, employeeCount));

        }
        return companies;
    }

    public void update(Company company) throws SQLException{
        connection = DatabaseUtils.getConnection();
        Company existingCompany = findById(company.getId());

        if(existingCompany == null){
            save(company);
            System.out.println("New company was created, because nothing was created");
        } else {
            //update cars set brand = 'audi', price 15 WHERE id = 5
            String sql = String.format("UPDATE company SET companyName = '%s', address = '%s', budget =  %d, employeeCount = %d WHERE id = %d;",
                    company.getCompanyName(),
                    company.getAddress(),
                    company.getBudget(),
                    company.getEmployeeCount());
                    company.getId();
            Statement statement = connection.createStatement();
            int updatedRows = statement.executeUpdate(sql);
            System.out.println("Rows update: " + updatedRows);
        }
    }


}
