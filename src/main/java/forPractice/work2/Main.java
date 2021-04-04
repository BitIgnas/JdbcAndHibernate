package forPractice.work2;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class Main {

    public static void main(String[] args) {


        Bank bankSeb = new Bank(1,"SEB", 4534, "denmark");
        ExecutingService.addBank(bankSeb);

        ExecutingService.updateBankName(bankSeb, "Panevezio bankas");

  



    }
}
