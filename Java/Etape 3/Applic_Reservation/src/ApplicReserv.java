import Entity.Order;
import Entity.Room;
import Entity.Voyageur;
import TableModel.OrderTableModel;
import TableModel.RoomTableModel;
import TableModel.VoyageursTableModel;
import Utils.Common;
import Utils.Request;
import Utils.Sign;
import Utils.TextAreaOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

/**
 * Application de réservation
 */
public class ApplicReserv extends javax.swing.JFrame {
    private Socket sock;
    
    /**
     * Creates new form ApplicReserv
     */
    public ApplicReserv() {
        initComponents();
        
        TextAreaOutputStream taos = TextAreaOutputStream.getInstance(output);
        
        // Selecteur de date
        Calendar calendar = Calendar.getInstance();
        
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        
        yearField.setModel(new SpinnerNumberModel(year, year, year + 10, 1));
        monthField.setModel(new SpinnerNumberModel(month + 1, 1, 12, 1));
        dayField.setModel(new SpinnerNumberModel(day, 1, 31, 1));
        dureeField.setModel(new SpinnerNumberModel(1, 1, 50, 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jRoomTable = new javax.swing.JTable();
        refreshRoom = new javax.swing.JButton();
        commmanderButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        dureeField = new javax.swing.JSpinner();
        yearField = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        monthField = new javax.swing.JSpinner();
        dayField = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jOrderTable = new javax.swing.JTable();
        refreshRoom1 = new javax.swing.JButton();
        payOrderButton = new javax.swing.JButton();
        cancelOrderButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cardNumberField = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jUserTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        connectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        refreshUserButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reservations");

        jSplitPane2.setDividerLocation(150);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        output.setColumns(20);
        output.setRows(5);
        jScrollPane1.setViewportView(output);

        jSplitPane2.setTopComponent(jScrollPane1);

        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane.setPreferredSize(new java.awt.Dimension(700, 300));
        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneStateChanged(evt);
            }
        });

        jRoomTable.setModel(new RoomTableModel());
        jScrollPane2.setViewportView(jRoomTable);

        refreshRoom.setText("Rafraîchir");
        refreshRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshRoomActionPerformed(evt);
            }
        });

        commmanderButton.setText("Commander");
        commmanderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commmanderButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Durée:");

        dureeField.setValue(1);

        jLabel8.setText("/");

        jLabel9.setText("/");

        jLabel10.setText("Date (JJ/MM/AAA):");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(refreshRoom)
                        .addGap(83, 83, 83)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dureeField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commmanderButton)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshRoom)
                    .addComponent(commmanderButton)
                    .addComponent(jLabel7)
                    .addComponent(dureeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(291, 291, 291))
        );

        jTabbedPane.addTab("Chambres disponnible", jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(695, 400));

        jOrderTable.setModel(new OrderTableModel());
        jScrollPane3.setViewportView(jOrderTable);

        refreshRoom1.setText("Rafraîchir");
        refreshRoom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshRoom1ActionPerformed(evt);
            }
        });

        payOrderButton.setText("Valider le paiement");
        payOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payOrderButtonActionPerformed(evt);
            }
        });

        cancelOrderButton.setText("Annuler");
        cancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Carte de crédit:");

        cardNumberField.setText("6060-7007-0880-20");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(refreshRoom1)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(payOrderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelOrderButton)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshRoom1)
                    .addComponent(payOrderButton)
                    .addComponent(jLabel5)
                    .addComponent(cardNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelOrderButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Réservations", jPanel2);

        jScrollPane4.setViewportView(jTabbedPane);

        jSplitPane2.setRightComponent(jScrollPane4);

        jUserTable.setModel(new VoyageursTableModel());
        jScrollPane5.setViewportView(jUserTable);

        jLabel1.setText("IP:");

        ipField.setText("127.0.0.1");

        jLabel2.setText("Port:");

        portField.setText("40000");

        jLabel3.setText("Login:");

        loginField.setText("admin");

        jLabel4.setText("Password:");

        connectButton.setText("Connection");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Deconnection");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        passwordField.setText("admin");

        jLabel6.setText("Voyageurs:");

        refreshUserButton.setText("Rafraîchir");
        refreshUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(connectButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(disconnectButton))
                    .addComponent(jScrollPane5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(refreshUserButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton)
                    .addComponent(disconnectButton)
                    .addComponent(jLabel3)
                    .addComponent(loginField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refreshUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // Deconnection
        if(sock != null) {
            disconnectButtonActionPerformed(evt);
        }
        
        String ip = ipField.getText();
        int port = Integer.parseInt(portField.getText());
        
        // Vérifie le port
        if(port < 40000) {
            System.out.append("Le port entre n'est pas valide (< 4000)");
            return;
        }
        
        System.out.println("Tentative de connection au serveur " + ip + ":" + port);
        
        try {
            sock = new Socket(ip, port);
        } catch (UnknownHostException ex) {
            System.out.println("L'ip " + ip + " n'est pas valide");
            return;
        } catch (IOException ex) {
            System.out.println("Impossible de joindre le serveur a l'adresse " + ip + ":" + port);
            return;
        }
        
        System.out.println("Connection reussie");
        
        String login = loginField.getText();
        String password = passwordField.getText();
        if(doLogin(login, password)) {
            System.out.println("Authentification reussie");
            
            jTabbedPaneStateChanged(null);
            refreshUserList();
        }
        else {
            System.out.println("Authentification impossible, abandon de la connexion");
            disconnectButtonActionPerformed(evt);
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        if(sock == null) {
            System.out.println("Aucune connection en cours ...");
            return;
        }
        
        try {
            sock.close();
            sock = null;
            System.out.println("Deconnecte du serveur");
        } catch (IOException ex) {
            System.out.println("Impossible de se deconnecter");
        }
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void jTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneStateChanged
        int i = jTabbedPane.getSelectedIndex();
        String paneTitle = jTabbedPane.getTitleAt(i);
        
        // Onglet de reservation
        if(i == 0) {
            refreshRoomList();
        }
            
        // Onglet de payement
        else {
            refreshBookList();
        }
    }//GEN-LAST:event_jTabbedPaneStateChanged

    private void refreshRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshRoomActionPerformed
        refreshRoomList();
    }//GEN-LAST:event_refreshRoomActionPerformed

    private void refreshRoom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshRoom1ActionPerformed
        refreshBookList();
    }//GEN-LAST:event_refreshRoom1ActionPerformed

    private void refreshUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshUserButtonActionPerformed
        refreshUserList();
    }//GEN-LAST:event_refreshUserButtonActionPerformed

    private void commmanderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commmanderButtonActionPerformed
        // Récupére la chambre
        int selectedRoom = jRoomTable.getSelectedRow();
        if(selectedRoom <= -1) {
            JOptionPane.showMessageDialog(
                    new JFrame(), "Aucune chambre n'est séléctionnée",
                    "Réservation échouée ...",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        RoomTableModel roomModel = (RoomTableModel)jRoomTable.getModel();
        Room room = roomModel.getValueAt(selectedRoom);
        
        // Récupére l'utilisateur
        int selectedUser = jUserTable.getSelectedRow();
        if(selectedUser <= -1) {
            JOptionPane.showMessageDialog(
                    new JFrame(), "Aucune utilisateur n'est séléctionnée",
                    "Réservation échouée ...",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        VoyageursTableModel voyageurModel = (VoyageursTableModel)jUserTable.getModel();
        Voyageur user = voyageurModel.getValueAt(selectedUser);
        
        // Récupére la date
        int day = (int)dayField.getValue();
        int month = (int)monthField.getValue();
        int year = (int)yearField.getValue();
        int duree = (int) dureeField.getValue();
        
        if(duree <= 0) {
            JOptionPane.showMessageDialog(
                    new JFrame(), "La durée doit être positive",
                    "Réservation échouée ...",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        // Prépare la requête
        Request reply, requ = new Request("BROOM");
        requ.addArg(Integer.toString(room.getId()));
        requ.addArg(Integer.toString(user.getId()));
        requ.addArg(Integer.toString(day));
        requ.addArg(Integer.toString(month));
        requ.addArg(Integer.toString(year));
        requ.addArg(Integer.toString(duree));
        
        reply = requ.sendAndRecv(sock);
        
        // Résultat
        if(reply.getCommande().compareTo("BROOM_OK") == 0) {
            System.out.println("Reservation enregistree");
            refreshRoomList();
        }
        else {
            System.out.println("Reservation echouee");
        }
    }//GEN-LAST:event_commmanderButtonActionPerformed

    private void payOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payOrderButtonActionPerformed
        // Récupére la commande
        int selectedOrder = jOrderTable.getSelectedRow();
        if(selectedOrder <= -1) {
            JOptionPane.showMessageDialog(
                    new JFrame(), "Aucune réservation n'est séléctionnée",
                    "Payement échoué ...",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        OrderTableModel model = (OrderTableModel)jOrderTable.getModel();
        Order order = model.getValueAt(selectedOrder);
        
        // Récupére le numéro de carte de crédit
        String cardNumber = cardNumberField.getText();
        
        System.out.println("Tentative de paiement ...");
        
        // Création de la requête
        Request reply, requ = new Request("PROOM");
        requ.addArg(Integer.toString(order.getId()));
        requ.addArg(cardNumber);
        
        reply = requ.sendAndRecv(sock);
        
        // Résultat
        if(reply.getCommande().compareTo("PROOM_OK") == 0) {
            System.out.println("Payement valide");
            refreshBookList();
        }
        else {
            System.out.println("Payement echouee");
        }
    }//GEN-LAST:event_payOrderButtonActionPerformed

    private void cancelOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOrderButtonActionPerformed
        // Récupére la commande
        int selectedOrder = jOrderTable.getSelectedRow();
        if(selectedOrder <= -1) {
            JOptionPane.showMessageDialog(
                    new JFrame(), "Aucune réservation n'est séléctionnée",
                    "Annulation échoué ...",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        OrderTableModel model = (OrderTableModel)jOrderTable.getModel();
        Order order = model.getValueAt(selectedOrder);
        
        System.out.println("Tentative d'annulation ...");
        
        // Création de la requête
        Request reply, requ = new Request("CROOM");
        requ.addArg(Integer.toString(order.getId()));
        
        reply = requ.sendAndRecv(sock);
        
        // Résultat
        if(reply.getCommande().compareTo("CROOM_OK") == 0) {
            System.out.println("Reservation annulee");
            refreshBookList();
        }
        else {
            System.out.println("Impossible d'annuler la reservation");
        }
    }//GEN-LAST:event_cancelOrderButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ApplicReserv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicReserv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicReserv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicReserv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ApplicReserv().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelOrderButton;
    private javax.swing.JTextField cardNumberField;
    private javax.swing.JButton commmanderButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JSpinner dayField;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JSpinner dureeField;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTable jOrderTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable jRoomTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jUserTable;
    private javax.swing.JTextField loginField;
    private javax.swing.JSpinner monthField;
    private javax.swing.JTextArea output;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton payOrderButton;
    private javax.swing.JTextField portField;
    private javax.swing.JButton refreshRoom;
    private javax.swing.JButton refreshRoom1;
    private javax.swing.JButton refreshUserButton;
    private javax.swing.JSpinner yearField;
    // End of variables declaration//GEN-END:variables

    /**
     * Tentative d'authentification de l'utilisateur
     * @param login     Login de l'utilisateur
     * @param password  Password de l'utilisateur
     */
    private boolean doLogin(String login, String password) {
        byte[] digest = Request.getDigest(password);
        
        // Construit la requete de LOGIN
        Request reply, requ = new Request("LOGIN");
        requ.addArg(login);
        requ.addArg(digest);
        
        reply = requ.sendAndRecv(sock, false);
        Sign.setKey(Sign.decryptKey(reply.getArg(0)));  // Clé symétrique recue
        
        // Vérifie la réussite de la commande
        String result = reply.getCommande();
        return result.compareTo("LOGIN_SUCCESS") == 0;
    }

    /**
     * Rafraichit la liste des chambres disponnibles
     */
    private void refreshRoomList() {
        System.out.println("Mise a jour de la liste des chambres ...");
        Request.quickSend("GET_AVAILABLE_ROOMS", sock);
        Request reply = Request.recv(sock);
        
        // Réponse érronée
        if(reply.getCommande().compareTo("AVAILABLE_ROOMS") != 0) {
            System.out.println("Impossible de mettre a jour la liste des chambres disponnible");
            return;
        }
        
        System.out.println("Affichage des " + reply.getArgs().size() + " chambres recue(s)");
        
        // Parcourt la réponse
        ArrayList<Room> l_room = new ArrayList<>();
        for(byte[] l_byte : reply.getArgs()) {
            Room room = (Room)Common.fromByte(l_byte);
            l_room.add(room);
        }
        
        // Mise a jour du tableau
        RoomTableModel model = (RoomTableModel)jRoomTable.getModel();
        model.setListing(l_room);
        jRoomTable.invalidate();
        jRoomTable.updateUI();
    }

    /**
     * Rafraichit la liste des commandes réalisées
     */
    private void refreshBookList() {
        System.out.println("Mise a jour de la liste des reservations ...");
        Request.quickSend("LROOM", sock);
        Request reply = Request.recv(sock);
        
        // Réponse érronée
        if(reply.getCommande().compareTo("LROOM") != 0) {
            System.out.println("Impossible de mettre a jour la liste des reservations");
            return;
        }
        
        System.out.println("Affichage des " + reply.getArgs().size() + " reservations recue(s)");
        
        // Parcourt la réponse
        ArrayList<Order> l_order = new ArrayList<>();
        for(byte[] l_byte : reply.getArgs()) {
            Order order = (Order)Common.fromByte(l_byte);
            l_order.add(order);
        }
        
        // Mise a jour du tableau
        OrderTableModel model = (OrderTableModel)jOrderTable.getModel();
        model.setListing(l_order);
        jOrderTable.invalidate();
        jOrderTable.updateUI();
    }

    /**
     * Rafraichit la liste des utilisateurs
     */
    private void refreshUserList() {
        System.out.println("Mise a jour de la liste des voyageurs ...");
        Request.quickSend("GET_LIST_VOYAGEURS", sock);
        Request reply = Request.recv(sock);
        
        // Réponse érronée
        if(reply.getCommande().compareTo("LIST_VOYAGEURS") != 0) {
            System.out.println("Impossible de mettre a jour la liste des voyageurs");
            return;
        }
        
        System.out.println("Affichage des " + reply.getArgs().size() + " voyageurs recu(s)");
        
        // Parcourt la réponse
        ArrayList<Voyageur> l_users = new ArrayList<>();
        for(byte[] l_byte : reply.getArgs()) {
            Voyageur user = (Voyageur)Common.fromByte(l_byte);
            l_users.add(user);
        }
        
        // Mise a jour du tableau
        VoyageursTableModel model = (VoyageursTableModel)jUserTable.getModel();
        model.setListing(l_users);
        jUserTable.invalidate();
        jUserTable.updateUI();
    }
}
