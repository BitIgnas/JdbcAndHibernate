package example2;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CompanyRepository companyRepository = new CompanyRepository();

        try {
            List<Company> companies = companyRepository.findAll();
            for (Company company : companies) {
                System.out.println(company);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        //find company by id

        try {
            Company maxima = companyRepository.findById(1);
            System.out.println("Company found under id 1: " + maxima);

            Company hesburger = companyRepository.findById(4);
            System.out.println("Company found under id 1: " + hesburger);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        //insert company by given id

        Company company = new Company("Circle K", "Lapo g. 5", 55600, 25);
        try {
            companyRepository.save(company);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        /**
         * Delete company by id
         */
        try {
            Company company1 = companyRepository.findById(1);
            if(company1 != null) {
                companyRepository.deleteById(1);
            } else {
                System.out.println("Nothing to delete");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        try {
            List<Company> companies = companyRepository.findByName("Pigu");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        /**
         * Update company
         */
        try {
            companyRepository.update(new Company(1, "Maxima", "Naujoji g. 5", 99999, 25));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
