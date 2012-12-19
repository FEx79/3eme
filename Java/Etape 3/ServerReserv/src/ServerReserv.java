import Bean.BeanDBAccessMySQL;
import Entity.Order;
import Entity.Room;
import Entity.Voyageur;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

/**
 * Serveur de réservations
 */
public class ServerReserv extends javax.swing.JFrame {
    private int PORT_VOYAGEURS = 40000;
    private int PORT_VILLAGE = 40001;
    private ThServerRMP serverRMP;
    private ThServerRCP serverRCP;
    private final Properties users;
    private BeanDBAccessMySQL db;

    /**
     * Creates new form ServerReserv
     */
    public ServerReserv() {
        initComponents();
        
        TextAreaOutputStream taos = TextAreaOutputStream.getInstance(output);
        
        users = new Properties();
        
        try {
            users.load(new FileInputStream("src/users.properties"));
            System.out.println("Liste des utilisateurs chargee ...");
            
            startServer();
        } catch (IOException ex) {
            System.out.println("Impossible d'ouvrir le fichier d'utilisateur");
        }
    }
    
    /**
     * Lance le serveur
     * @return  Succes ou non
     */
    public final boolean startServer() {
        System.out.println(
                "Demarrage du serveur sur les ports " +
                PORT_VOYAGEURS + " (VOYAGEURS) et " +
                PORT_VILLAGE + " (VILLAGE)"
        );
        
        // Connection à la base de données
        db = new BeanDBAccessMySQL();
        if(!db.init()) {
            System.out.println("Connexion a la base de donnees impossible, avez-vous demarre votre SGBD ?");
            
            showStatus();
            return false;
        }
        
        System.out.println("Connecte a la base de donnees");
        System.out.println("Lancement des thread ...");
        
        serverRMP = new ThServerRMP(this, PORT_VOYAGEURS);
        serverRCP = new ThServerRCP(this, PORT_VILLAGE);
        
        serverRMP.start();
        serverRCP.start();
        
        showStatus();
        return true;
    }
    
    /**
     * Stoppe le serveur
     */
    public void stopServer() {
        if( serverRMP == null || serverRCP == null ||
            !serverRMP.isAlive() || !serverRCP.isAlive())
        {
            System.out.println("Envois des demande de fermeture impossible, le serveur n'est pas lance");
            return;
        }
            
        System.out.println("Envois des demande de fermeture");
        try {
            serverRMP.requestStop();
        } catch (IOException ex) {
            System.out.println("Fermeture du serveur RMP echouee");
        }

        try {
            serverRCP.requestStop();
        } catch (IOException ex) {
            System.out.println("Fermeture du serveur RCP echouee");
        }
            
        try {
            serverRMP.join();
            System.out.println("Fin de la gestion des reservations");
            
            serverRCP.join();
            System.out.println("Fin de la gestion des consultations");
        } catch (InterruptedException ex) {
            System.out.println("Les thread ne se sont pas termine correctement");
        }
        
        showStatus();
    }
    
    /**
     * Affiche visuellement l'etat du serveur
     */
    private void showStatus() {
        // Serveur eteint
        if( serverRMP == null || serverRCP == null ||
            !serverRMP.isAlive() || !serverRCP.isAlive())
        {
            statusText.setForeground(Color.RED);
            statusText.setText("Not running");
            switchStateButton.setText("Start");
        }
        // Seveur lancé
        else {
            statusText.setForeground(Color.BLACK);
            statusText.setText("Running");
            switchStateButton.setText("Stop");
        }
        
        // Rafraichit
        statusText.invalidate();
        switchStateButton.invalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        statusText = new javax.swing.JLabel();
        switchStateButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Serveur de réservations");

        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        jLabel1.setText("Status:");

        statusText.setText("jLabel2");

        switchStateButton.setText("Stop");
        switchStateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchStateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(switchStateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(statusText)
                    .addComponent(switchStateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void switchStateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchStateButtonActionPerformed
        //Arret
        if(switchStateButton.getText().compareTo("Stop") == 0) {
            stopServer();
        }
        // Demarrage
        else {
            startServer();
        }
    }//GEN-LAST:event_switchStateButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerReserv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerReserv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerReserv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerReserv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ServerReserv().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea output;
    private javax.swing.JLabel statusText;
    private javax.swing.JButton switchStateButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Donne le digest de l'utilisateur donné
     * @param login
     * @return      Digest de l'utilisateur
     */
    public synchronized byte[] getUserDigest(String login) {
        // Fichier bien chargé
        if(users == null) {
            return null;
        }
        
        // Login existant
        if(!users.containsKey(login)) {
            return null;
        }
        
        String password = users.getProperty(login);
        return Request.getDigest(password);
    }
    
    /**
     * Donne la liste des chambres disponnibles
     * @return 
     */
    public synchronized ArrayList<Room> getAvailableRoomList() {
        ArrayList<Room> l_availableRoom = new ArrayList<>();
        
        // Selection des données dans la db
        ResultSet l_room = db.selectAll("chambres");
        ResultSet l_reservation = db.selectAll("reservations");
        
        try {
            // Parcourt le resultat
            l_room.beforeFirst();
            while(l_room.next()) {
                Room room = new Room();
                room.setId(l_room.getInt("numero"));
                room.setBaignoire(l_room.getInt("baignoire"));
                room.setCuvette(l_room.getInt("cuvette"));
                room.setDouche(l_room.getInt("douche"));
                room.setPlaces(l_room.getInt("nb_occupants"));
                room.setPrix(l_room.getInt("prix_htva"));
                room.setCategorie(l_room.getString("categorie"));
                
                // Verifie qu'elle n'est pas reservée
                boolean libre = true;
                l_reservation.beforeFirst();
                while(l_reservation.next()) {
                    if(l_reservation.getInt("chambre") == room.getId()) {
                        libre = false;
                        break;
                    }
                }
                
                // Ajoute la chambre
                if(libre) {
                    l_availableRoom.add(room);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Impossible de recuperer les chambres ...");
        }
        
        return l_availableRoom;
    } 

    /**
     * Donne la liste des réservations
     * @return 
     */
    public synchronized ArrayList<Order> getOrderList() {
        ArrayList<Order> arrayOrder = new ArrayList<>();
        
        // Selection des données dans la db
        ResultSet l_order = db.selectAll("reservations");
        
        try {
            // Parcourt le resultat
            l_order.beforeFirst();
            while(l_order.next()) {
                // Récupére le titulaire
                ResultSet titulaire = db.selectAll(
                        "voyageurs",
                        "id = " + l_order.getInt("titulaire")
                );
                titulaire.next();
                
                // Place la réservations dans un objet
                Order order = new Order();
                order.setId(l_order.getInt("id"));
                order.setNumeroChambre(l_order.getInt("chambre"));
                order.setTitulaire(l_order.getInt("titulaire"));
                order.setUsernameTitulaire(titulaire.getString("username"));
                order.setIsPaye(l_order.getInt("paye") == 1);
                order.setDuree(l_order.getInt("duree"));
                order.setStatus(l_order.getInt("status"));
                
                try { order.setDebut(l_order.getDate("debut")); }
                catch(SQLException ex) {  }
                
                // Ajoute la réservation
                arrayOrder.add(order);
            }
        } catch (SQLException ex) {
            System.out.println("Impossible de recuperer les reservations ...");
        }
        
        return arrayOrder;
    }

    /**
     * Donne la liste des utilisateurs
     * @return 
     */
    public synchronized ArrayList<Voyageur> getUsersList() {
        ArrayList<Voyageur> arrayUsers = new ArrayList<>();
        
        // Selection des données dans la db
        ResultSet l_users = db.selectAll("voyageurs");
        
        try {
            // Parcourt le resultat
            l_users.beforeFirst();
            while(l_users.next()) {
                // Place la réservations dans un objet
                Voyageur user = new Voyageur();
                user.setId(l_users.getInt("id"));
                user.setNom(l_users.getString("nom"));
                user.setPrenom(l_users.getString("prenom"));
                user.setUsername(l_users.getString("username"));
                user.setAdresse(l_users.getString("adresse"));
                user.setEmail(l_users.getString("email"));
                
                // Ajoute la réservation
                arrayUsers.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("Impossible de recuperer les voyageurs ...");
        }
        
        return arrayUsers;
    }

    /**
     * Ajoute une réservation dans la BDD
     * @param roomId
     * @param userId
     * @return 
     */
    public synchronized boolean addReservation(int roomId, int userId, int day, int month, int year, int duree) {
        if(roomId <= -1 || userId <= -1) {
            return false;
        }
        
        Calendar calendar = Calendar.getInstance();
        
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.MONTH);
        
        if(year < currentYear ||
           (year == currentYear && month < currentMonth) ||
           (year == currentYear && month == currentMonth && day < currentDay))
        {
            return false;
        }
        
        // Ajout
        db.executeUpdate("INSERT INTO reservations"
                        + " (id, titulaire, chambre, paye, debut, duree)"
                        + " VALUES (NULL, " + userId + ", " + roomId + ", 0, \""
                        + day + "." + month + "." + year + "\", " + duree + ")"
        );
        
        return true;
    }

    /**
     * Payement d'une reservation
     * @param orderId
     * @param cardNumber
     * @return 
     */
    public synchronized boolean payOrder(int orderId, String cardNumber) {
        if(orderId <= -1) {
            return false;
        }
        
        // Verification de la carte de crédit
        // TODO ?
        
        // Mise à jour
        db.executeUpdate("UPDATE reservations SET paye = 1 WHERE id = " + orderId);
        
        return true;
    }

    /**
     * Annule une commande
     * @param orderId
     * @return 
     */
    public synchronized boolean cancelOrder(int orderId) {
        if(orderId <= -1) {
            return false;
        }
        
        // Suppression
        db.executeUpdate("DELETE FROM reservations WHERE id = " + orderId);
        
        return true;
    }

    /**
     * Modifie le status de la reservation
     * @param orderId
     * @param isPresent
     * @return 
     */
    boolean setOrderStatus(int orderId, boolean isPresent) {
        if(orderId <= -1) {
            return false;
        }
        
        // Valuer du champ
        int status = 0;
        if(isPresent) {
            status = 1;
        }
        System.out.println(orderId + ", " + status);
        // Mise à jour
        db.executeUpdate("UPDATE reservations SET status = " + status + " WHERE id = " + orderId);
        
        return true;
    }
}
