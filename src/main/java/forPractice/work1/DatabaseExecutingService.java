package forPractice.work1;

import forPractice.work1.Cars;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseExecutingService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Lietkabelis123";
    private static Connection connection;
    private static Statement myStatement;
    private static String SQL_SHOW_ALL = "SELECT * FROM car;";
    private static String SQL_SHOW_BRAND = "SELECT brand FROM car;";


    public static void getConnection() {

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch(SQLException exception){
            System.out.println("Database cannot be connected to database");
        }
    }

    public void printAll() throws SQLException{
      getConnection();
      myStatement = connection.createStatement();
      ResultSet rs = myStatement.executeQuery(SQL_SHOW_ALL);

      while(rs.next()){
          String brand = rs.getString("brand");
          String model = rs.getString("model");
          int price = rs.getInt("price");
          String country = rs.getString("country");
          System.out.print(brand + " ");
          System.out.print(model + " ");
          System.out.print(price + " ");
          System.out.println(country);

      }
        rs.close();
        myStatement.close();
        connection.close();
    }

    public void updateByBrand(Cars cars) throws SQLException {
        getConnection();
        String sql = "UPDATE car SET model = ? , price = ?, country = ? WHERE brand = ?;";


        PreparedStatement preSt = connection.prepareStatement(sql);
        preSt.setString(1, cars.getModel());
        preSt.setInt(2, cars.getPrice());
        preSt.setString(3, cars.getCountry());
        preSt.setString(4, cars.getBrand());
        preSt.executeUpdate();
        System.out.println("Database updatated sucessfully");

    }

    public List<Cars> findAll() throws SQLException {
        getConnection();
        myStatement = connection.createStatement();
        ResultSet rs = myStatement.executeQuery(SQL_SHOW_ALL);
        List<Cars> carList = new ArrayList<>();

        while (rs.next()) {
            String brand = rs.getString("brand");
            String model = rs.getString("model");
            int price = rs.getInt("price");
            String country = rs.getString("country");
            carList.add(new Cars(brand, model, price, country));
        }
        return  carList;
    }

    public void selectBrand() throws SQLException{
        getConnection();
        myStatement = connection.createStatement();
        ResultSet rs = myStatement.executeQuery(SQL_SHOW_BRAND);

        while(rs.next()){
            String brand = rs.getString("brand");
            System.out.println(brand);
        }
    }
}
