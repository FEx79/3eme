package Vues;

import Bean.BeanDBAccessMySQL;
import java.beans.Beans;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author T4g1
 */
public class Vues {
    /**
     * Affiche la page de login echoué
     * 
     * @param out   Sortie du code HTML
     */
    public static void showLoginFailed(PrintWriter out) {
        out.println("<p>Login échoué</p>");
    }
    
    /**
     * Affiche une erreur d'ajout d'utilisateur
     * 
     * @param out   Sortie du code HTML
     */
    public static void showAddUserFailed(PrintWriter out) {
        out.println("<p>Ajout d'utilisateur impossible, nom déjà prit</p>");
    }
    
    /**
     * Ajoute un message sur la page
     * 
     * @param out           La page sur laquelle on affiche
     * @param message       Message désiré
     */
    public static void addMessage(PrintWriter out, String message) {
        out.println("<p>Trace Message: "+message+ "</p>");    
    }
    
    /**
     * Place les entête HTML du début de la page
     * 
     * @param out           La page sur laquelle on affiche
     */
    public static void begin(PrintWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");        
    }
    
    /**
     * Place les fermetures des balises HTML pour terminer la
     * génération de la page.
     * 
     * @param out           La page sur laquelle on affiche
     */
    public static void end(PrintWriter out) {
        out.println("</body>");
        out.println("</html>");        
    }
    
    /**
     * Redirige sur la page donnée
     * 
     * @param request       Requete recue
     * @param response      Reponse recue
     * @param page          Page voulue
     */
    public static void redirect(
            HttpServletRequest request, HttpServletResponse response, 
            String page) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(page + ".jsp");
        rd.forward(request, response);
    }
    
    /**
     * Donne le titre de la page donnée
     * 
     * @param page          Page dont on veut le titre
     * 
     * @return              Titre de la page
     */
    public static String getPageTitle(String page) {
        return "Mon super site de vacance";
    }
    
    /**
     * Donne la liste des produits disponnible
     * 
     * @return              Code HTML du listing
     */
    public static String getListing() {
        String html = "<table>\n" +
        "    <tr>\n" +
        "        <th>Douche(s)</th>\n" +
        "        <th>Baignoire(s)</th>\n" +
        "        <th>Cuvette(s)</th>\n" +
        "        <th>Place(s)</th>\n" +
        "        <th>Prix HTVA</th>\n" +
        "        <th></th>\n" +
        "    </tr>";
            
        try {
            // Ouvre la BDD
            BeanDBAccessMySQL dba = (BeanDBAccessMySQL)Beans.instantiate(
                        null, "Bean.BeanDBAccessMySQL");
                
            if(dba.init()) {
                // Requete
                String request = "SELECT * FROM chambres WHERE numero NOT IN ("
                        + "SELECT chambre FROM reservations)";
                
                // Sélectionne les chambres non réservées
                ResultSet result = dba.executeQuery(request);
                
                while(result != null && result.next())
                {
                    html += "<tr>";
                    html += "<td>" + result.getInt("douche") + "</td>";
                    html += "<td>" + result.getInt("baignoire") + "</td>";
                    html += "<td>" + result.getInt("cuvette") + "</td>";
                    html += "<td>" + result.getInt("nb_occupants") + "</td>";
                    html += "<td>" + result.getInt("prix_htva") + "</td>";
                    html += "<td><a href=\"controlServlet?action=commander&";
                    html += "numero=" + result.getInt("numero") + "\">";
                    html += "Commander</a></td>";
                    html += "</tr>";
                }
            }
            else
            {
                html = "dba.init() error";
            }
        } catch (SQLException ex) {
            html = "SQLException";
        } catch (IOException ex) {
            html = "IOException";
        } catch (ClassNotFoundException ex) {
            html = "ClassNotFoundException";
        }
        
        html += "</table>";
            
        return html;
    }
    
    /**
     * Donne le code HTML du contenu du caddie donné
     * 
     * @param caddie        Caddie voulu
     * 
     * @return              Code HTML du contenu
     */
    public static String getCaddieContent(List<Integer> caddie) {
        String html = "<table>\n" +
        "    <tr>\n" +
        "        <th>Douche(s)</th>\n" +
        "        <th>Baignoire(s)</th>\n" +
        "        <th>Cuvette(s)</th>\n" +
        "        <th>Place(s)</th>\n" +
        "        <th>Prix HTVA</th>\n" +
        "    </tr>";
            
        try {
            // Ouvre la BDD
            BeanDBAccessMySQL dba = (BeanDBAccessMySQL)Beans.instantiate(
                        null, "Bean.BeanDBAccessMySQL");
                
            if(dba.init()) {
                // Parcourt le caddie
                for(int numero: caddie)
                {
                    // Sélectionne la chambre donnée
                    ResultSet result = dba.selectAll("chambres",
                            "numero='" + numero + "'");

                    if(result != null && result.next())
                    {
                        html += "<tr>";
                        html += "<td>" + result.getInt("douche") + "</td>";
                        html += "<td>" + result.getInt("baignoire") + "</td>";
                        html += "<td>" + result.getInt("cuvette") + "</td>";
                        html += "<td>" + result.getInt("nb_occupants") + "</td>";
                        html += "<td>" + result.getInt("prix_htva") + "</td>";
                        html += "</tr>";
                    }
                }
            }
            else
            {
                html = "dba.init() error";
            }
        } catch (SQLException ex) {
            html = "SQLException";
        } catch (IOException ex) {
            html = "IOException";
        } catch (ClassNotFoundException ex) {
            html = "ClassNotFoundException";
        }
        
        html += "</table>";
            
        return html;
    }
}
