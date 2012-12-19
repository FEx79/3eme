
import Bean.*;
import java.beans.Beans;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author T4g1
 */
public class TestBean {
    public static void main(String[] args){
        try {
            BeanDBAccessORA dbaORA;
            System.out.println("instanciation du bean");
            dbaORA = (BeanDBAccessORA)Beans.instantiate(
                    null, "Bean.BeanDBAccessORA");


            // Connexion a la BDD
            System.out.println("init dbora");
            dbaORA.init();
            System.out.println("comptage des sceances.");
            System.out.println("Chambres: " + dbaORA.count("sceances"));
        } catch (IOException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestBean.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
