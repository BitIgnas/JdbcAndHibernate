package forPractice.work1;

import forPractice.work1.Cars;
import forPractice.work1.DatabaseExecutingService;

import java.sql.SQLException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws SQLException {

       DatabaseExecutingService databaseExecutingService = new DatabaseExecutingService();
       databaseExecutingService.getConnection();
       databaseExecutingService.printAll();
       Cars mustang = new Cars("Audi", "Mustang", 15500, "USA");
       databaseExecutingService.updateByBrand(mustang);

        List<Cars> carsList = databaseExecutingService.findAll();
        for (Cars cars : carsList) {
            System.out.println(cars);
        }

        databaseExecutingService.selectBrand();










    }


}
