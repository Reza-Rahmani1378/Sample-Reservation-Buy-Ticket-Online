package ir.maktab56;

import com.github.javafaker.App;
import ir.maktab56.airline.util.ApplicationContext;
import ir.maktab56.airline.util.HibernateUtil;
import ir.maktab56.airline.util.menu.RunMenu;

public class AirLineApp {
    public static void main(String[] args) throws Exception {
        HibernateUtil.getEntityManagerFactory().createEntityManager();

        new RunMenu().run();


    }
}
