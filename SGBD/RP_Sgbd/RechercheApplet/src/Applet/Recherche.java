/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Applet;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author freddy
 */
public class Recherche extends javax.swing.JApplet {
    private URL servletURL;

    /**
     * Initializes the applet Recherche
     */
    @Override
    public void init() {
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
            java.util.logging.Logger.getLogger(Recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recherche.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                    // URL de contact pour le servlet
                    URL currentPage = getDocumentBase();
                    
                    String protocol = currentPage.getProtocol();
                    String host = currentPage.getHost();
                    int port = currentPage.getPort();
                    
                    try {
                        servletURL = new URL(
                                protocol, host, port,
                                "/Web_Applic_Reservations/Search"
                        );
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(Recherche.class.getName()).log(
                                Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        heuresSceances_CB = new javax.swing.JComboBox();
        placesRestantesMin = new javax.swing.JSpinner();
        placesRestantesMax = new javax.swing.JSpinner();
        numeroSalle = new javax.swing.JSpinner();
        searchSceancesButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        titreFilm_TB = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        DateBorneInf_TB = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        dateBorneSup_TB = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        panelFilm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Titre_TF = new javax.swing.JTextField();
        duree_SP = new javax.swing.JSpinner();
        dateSortie_TF = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        searchFilmButton = new javax.swing.JButton();

        jLabel5.setText("Heure Scéance:");

        jLabel6.setText("Places restantes(min):");

        jLabel7.setText("Places restantes(max):");

        jLabel8.setText("Numéro de salle:");

        heuresSceances_CB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "aucune", "14h00", "16h00", "20h00", "22h00" }));

        searchSceancesButton.setText("Rechercher");
        searchSceancesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSceancesButtonActionPerformed(evt);
            }
        });

        jLabel11.setText("Titre:");

        jLabel12.setText("du:");

        DateBorneInf_TB.setText("jj/mm/aaaa");

        jLabel13.setText("au:");

        dateBorneSup_TB.setText("jj/mm/aaaa");

        jLabel14.setText("V1.2.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(46, 46, 46)
                            .addComponent(heuresSceances_CB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(searchSceancesButton)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(95, 95, 95)
                            .addComponent(titreFilm_TB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(numeroSalle, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(placesRestantesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(placesRestantesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DateBorneInf_TB, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateBorneSup_TB, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(heuresSceances_CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(placesRestantesMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(placesRestantesMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(numeroSalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(titreFilm_TB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(DateBorneInf_TB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(dateBorneSup_TB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchSceancesButton)
                .addGap(61, 61, 61))
        );

        jTabbedPane1.addTab("Scéances", jPanel1);

        jLabel1.setText("Titre:");

        jLabel2.setText("durée(min):");

        jLabel3.setText("Date de sortie:");

        jLabel4.setText("Cote:");

        dateSortie_TF.setText("jj/mm/aaaa");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        searchFilmButton.setText("Rechercher");
        searchFilmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFilmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFilmLayout = new javax.swing.GroupLayout(panelFilm);
        panelFilm.setLayout(panelFilmLayout);
        panelFilmLayout.setHorizontalGroup(
            panelFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFilmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelFilmLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(dateSortie_TF))
                        .addGroup(panelFilmLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(55, 55, 55)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelFilmLayout.createSequentialGroup()
                            .addGroup(panelFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(26, 26, 26)
                            .addGroup(panelFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(duree_SP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Titre_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(searchFilmButton))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        panelFilmLayout.setVerticalGroup(
            panelFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFilmLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Titre_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(duree_SP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dateSortie_TF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(searchFilmButton)
                .addGap(292, 292, 292)
                .addGroup(panelFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Film", panelFilm);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchFilmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFilmButtonActionPerformed
        
        
        try {
            String param = "?action=recherche";
            param += "&criteres=films";
            if(!Titre_TF.getText().equals("")){
                param += "&titre="+URLEncoder.encode(Titre_TF.getText());
            }
            else{
                param += "&titre=na";
            }
            if( Integer.parseInt(duree_SP.getValue().toString())!= 0){
                param += "&duree="+URLEncoder.encode(duree_SP.getValue().toString());
            }
            else{
                param += "&duree=na";
            }
            if( dateSortie_TF.getText().equals("") || dateSortie_TF.getText().equals("jj/mm/aaaa")){
                param += "&sortie=na";
            }
            else{
                param += "&sortie="+URLEncoder.encode(dateSortie_TF.getText());
                
            }
            
            //Appel à la servlet
            getAppletContext().showDocument(
                    new URL(servletURL + param));
        } catch (MalformedURLException ex) { 
            System.out.println("URL mal formattée");
        }
    }//GEN-LAST:event_searchFilmButtonActionPerformed

    private void searchSceancesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSceancesButtonActionPerformed
        try {
            String param = "?action=recherche";
            param += "&criteres=sceances";
            if(!heuresSceances_CB.getSelectedItem().toString().equals("aucune")){
                int sceances = -1;
                switch(heuresSceances_CB.getSelectedItem().toString()){
                    case "14h00":
                        sceances = 1;
                        break;
                    case "16h00":
                        sceances = 2;
                        break;
                    case "20h00":
                        sceances = 3;
                        break;
                    case "22h00":
                        sceances = 4;
                        break;                
                }
                param += "&heure="+URLEncoder.encode(sceances+"");
            }
            else{
                param += "&heure=na";
            }
            if( Integer.parseInt(placesRestantesMin.getValue().toString()) != 0){
                param += "&placemin="+URLEncoder.encode(placesRestantesMin.getValue().toString());
            }
            else{
                param += "&placemin=na";
            }
            if(Integer.parseInt(placesRestantesMax.getValue().toString()) != 0){
                param += "&placemax="+URLEncoder.encode(placesRestantesMax.getValue().toString());
            }
            else{
                param += "&placemax=na";
            }
            if(Integer.parseInt(numeroSalle.getValue().toString()) != 0){
                param += "&salle="+URLEncoder.encode(placesRestantesMax.getValue().toString());
            }
            else{
                param += "&salle=na";
            }
            if(!titreFilm_TB.getText().equals("")){
                param += "&titre="+titreFilm_TB.getText();
            }
            else{
                param += "&titre=na";            
            }
            if(!DateBorneInf_TB.getText().equals("") && !DateBorneInf_TB.getText().equals("jj/mm/aaaa") &&
                !dateBorneSup_TB.getText().equals("") && !dateBorneSup_TB.getText().equals("jj/mm/aaaa")){
                param+="&dateinf="+DateBorneInf_TB.getText()+"&datesup="+dateBorneSup_TB.getText();
            }
            else{
                param+="&dateinf=na&datesup=na";
            }
            
            //Appel à la servlet
            getAppletContext().showDocument(
                    new URL(servletURL + param));
        } catch (MalformedURLException ex) { 
            System.out.println("URL mal formattée");
        }
    }//GEN-LAST:event_searchSceancesButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateBorneInf_TB;
    private javax.swing.JTextField Titre_TF;
    private javax.swing.JTextField dateBorneSup_TB;
    private javax.swing.JTextField dateSortie_TF;
    private javax.swing.JSpinner duree_SP;
    private javax.swing.JComboBox heuresSceances_CB;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner numeroSalle;
    private javax.swing.JPanel panelFilm;
    private javax.swing.JSpinner placesRestantesMax;
    private javax.swing.JSpinner placesRestantesMin;
    private javax.swing.JButton searchFilmButton;
    private javax.swing.JButton searchSceancesButton;
    private javax.swing.JTextField titreFilm_TB;
    // End of variables declaration//GEN-END:variables
}