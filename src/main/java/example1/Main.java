package example1;

import java.sql.*;

public class Main {

    /**
     * Predefine connection details
     */
    //JDBC drive name and connection URL
    public static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    //Database credentials
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "Lietkabelis123";


    public static void main(String[] args) {
        Connection connection;
        Statement statement;

        System.out.println("Connecting to database...");
        try {
            //open db connection
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connection successful!");

            //execute query
            System.out.println("Creating statement");
            statement = connection.createStatement();
            String sql = "SELECT brand, model, price, country FROM car";
            ResultSet resultSet = statement.executeQuery(sql);

            //extract data from the result set
            System.out.println("Extracting data from result set...");

            while(resultSet.next()){
                //Retrieve data by column name
                String brand = resultSet.getString(1);
                String model = resultSet.getString("model");
                int price = resultSet.getInt("price");
                String country = resultSet.getString("country");

                //Display the values

                System.out.print("Brand: " + brand);
                System.out.print(" Model: " + model);
                System.out.print(" Price: " + price);
                System.out.println(" Country: " + country);

                //Future logic...

            }

            //clean up logic
            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Everything is closed. BYE!");

        } catch (SQLException exception) {
            System.out.println("Connection to database failed");
            exception.printStackTrace();
        }
    }
}
