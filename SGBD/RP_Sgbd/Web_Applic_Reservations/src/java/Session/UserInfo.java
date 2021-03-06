package Session;

import Bean.BeanDBAccessMySQL;
import Bean.BeanDBAccessORA;
import Vues.Vues;
import java.beans.Beans;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Informations de l'utilisateur
 * 
 * @author T4g1
 */
public class UserInfo {
    public static final String USER_INFO_KEY = "USER_INFO_KEY";
    private boolean logged;
    private int id;
    private String page;
    
    /**
     * Initialisation du bean
     */
    @PostConstruct
    private void initialize() {
        logged = false;
        page = "";
        id = 0;
    }
    
    /**
     * Récupére les informations utilisateur
     * 
     * @param request       Requete recue par le servlet
     * 
     * @return              Les informations utilisateur
     */
    public static UserInfo getUserInfo(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        UserInfo userInfo = (UserInfo)httpSession.getAttribute(UserInfo.USER_INFO_KEY);
        if (userInfo == null) {
            userInfo = new UserInfo();
            
            httpSession.setAttribute(UserInfo.USER_INFO_KEY, userInfo);
        }
        
        return userInfo;
    }
    
    /**
     * Ajoute la chambre dont le numéro est donné au caddie
     * 
     * @param numero        Numero de la chambre voulue
     * 
     * @return              true si chambre commandée, false sinon
     */
    public boolean commander(int idsalle, int numsceance, int idfilm, String datejour, int paye, int nbplace) {
        try {
            BeanDBAccessORA dba = (BeanDBAccessORA)Beans.instantiate(
                    null, "Bean.BeanDBAccessORA");
            
            if(dba.init()) {
                // Si la chambre est déjà réservée
                /*
                if(dba.count("caddie", "chambre='" + numero + "'") != 0)
                {
                    return false;
                }
                */
                // Insére la reservation
                String query = "insert into caddie values ("+ id+","+ idsalle+", "+numsceance+", "+idfilm+", '"+datejour+"', "+paye+","+nbplace+")";
                return dba.executeUpdate(query);
            }
        }
        catch (IOException ex) { }
        catch (ClassNotFoundException ex) { }
       return false;
    }
    
    /**
     * Annule le caddie actuel du client
     */
    public boolean cancelCaddie() {
        // Annule chaque commande non payée du client
        try {
            BeanDBAccessMySQL dba = (BeanDBAccessMySQL)Beans.instantiate(
                    null, "Bean.BeanDBAccessMySQL");
            
            if(!dba.init())
            {
                return false;
            }
            
            // Annule chaque commande
            String query = "DELETE FROM reservations WHERE paye=0 AND ";
            query += "titulaire=" + id + ";";
/*
            if(!dba.executeUpdate(query))
            {
                return false;
            }
            */
            
        }
        catch (IOException ex)
        {
            return false;
        }
        catch (ClassNotFoundException ex)
        {
            return false;
        }
        
        return true;
    }
    
    /**
     * Paye le caddie actuel du client
     */
    public boolean payerCaddie() {
        try {
            BeanDBAccessMySQL dba = (BeanDBAccessMySQL)Beans.instantiate(
                    null, "Bean.BeanDBAccessMySQL");
            
            if(!dba.init())
            {
                return false;
            }
            
            // Paye toutes les commandes
            String query = "UPDATE reservations SET paye=1";
            query += " WHERE paye=0 AND titulaire=" + id + ";";
/*
            if(!dba.executeUpdate(query))
            {
                return false;
            }
            */
        } catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
        
        return true;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Accesseurs">
    /**
     * retourne l'id de session
     * @return 
     */
    public int getId(){
        return id;
    }
    
    
    /**
     * Indique si l'utilisateur est loggué
     * 
     * @return      true s'il est loggué, false sinon
     */
    public boolean isLogged() {
        return logged;
    }
    
    /**
     * Donne la page actuelle
     * 
     * @return      Page actuelle
     */
    public String getPage() {
        return page;
    }
    
    /**
     * Donne le titre de la page actuelle
     * 
     * @return      Titre de la page
     */
    public String getPageTitle() {
        return Vues.getPageTitle(page);
    }
    
    /**
     * Donne le caddie du joueur
     *  TODO: modify
     * @return      Caddie du joueur
     */
    public List<Integer> getCaddie() {
        List<Integer> caddie = new ArrayList<Integer>();
        
        // Ajoute les réservation non payées au caddie
        try {
            BeanDBAccessORA dba = (BeanDBAccessORA)Beans.instantiate(
                    null, "Bean.BeanDBAccessORA");
            
            if(dba.init()) {
                ResultSet result = dba.selectAll(
                        "caddie", "paye=0 AND idsession=" + id);
                
                while(result.next())
                {
                    int sceances = result.getInt("chambre");
                    caddie.add(result.getInt("chambre"));
                }
            }
        }
        catch (SQLException ex) { }
        catch (IOException ex) { }
        catch (ClassNotFoundException ex) { }
        
        return caddie;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Mutateurs">
    
    /**
     * Modifie la valeur de logged
     * 
     * @param value         Nouvelle valeur
     */
    public void setLogged(boolean value) {
        logged = value;
    }
    
    /**
     * Modifie la page actuelle
     * 
     * @param value         Nouvelle page
     */
    public void setPage(String value) {
        page = value;
    }
    
    /**
     * Modifie l'id du client
     * 
     * @param value         Nouvel id
     */
    public void setId(int value) {
        id = value;
    }
    
    //</editor-fold>
}
