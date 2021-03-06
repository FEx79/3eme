/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chessclient;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T4g1
 */
public class Main {
    private static IntroUI introUI;
    private static LobbyUI lobbyUI;
    private static GameUI gameUI;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            introUI = new IntroUI();
            lobbyUI = new LobbyUI();
            gameUI = new GameUI();
        
            showIntro();
            //showGame();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Affiche l'intro du jeu
     */
    public static void showIntro()
    {
        introUI.setVisible(true);
        lobbyUI.setVisible(false);
        gameUI.setVisible(false);
    }
    
    /**
     * Affiche le lobby du jeu
     */
    public static void showLobby()
    {
        lobbyUI.init();
        lobbyUI.refresh();
                
        introUI.setVisible(false);
        lobbyUI.setVisible(true);
        gameUI.setVisible(false);
    }
    
    /**
     * Affiche le jeu
     * @param echiquierId       Id de l'echiquier
     * @param joueurId          Id du joueur
     */
    public static void showGame(Long echiquierId, Long joueurId)
    {
        gameUI.initGame(echiquierId, joueurId);
        
        introUI.setVisible(false);
        lobbyUI.setVisible(false);
        
        gameUI.setVisible(true);
    }
}
