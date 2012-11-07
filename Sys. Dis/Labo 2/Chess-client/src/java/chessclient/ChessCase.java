package chessclient;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * G�re une case du plateau de jeu
 * @author T4g1
 */
public class ChessCase extends JPanel {
    private static final int CASE_WIDTH = 50;
    private static final int CASE_HEIGHT = 71;
    private static final Color highlightColor = Color.RED;

    private GameUI parent;
    private int x;
    private int y;
    //private Piece piece;
    
    private Color backgroundColor;
    
    //<editor-fold defaultstate="collapsed" desc="Constructeurs">
    
    /**
     * Initialise une case en lui donnant sa position
     * 
     * @param parent            Classe parent de la case
     * @param x                 Position en x de la case
     * @param y                 Position en y de la case
     * @param backgroundColor   Couleur de fond
     */
    public ChessCase(GameUI parent, int x, int y, Color backgroundColor)
    {
        this.parent = parent;
        
        this.x = x;
        this.y = y;
        //this.piece = null;
        
        this.backgroundColor = backgroundColor;
        
        // Modifie la couleur de fond
        setBackground(backgroundColor);
        
        // Ajoute un mouse listenner pour les clic utilisateurs
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                onClic();
            }
        });
    }
    
    /**
     * Initialise une case
     */
    public ChessCase()
    {
        this.x = 0;
        this.y = 0;
    }
    
    //</editor-fold>
    
    /**
     * Retire les pi�ces sur la case
     */
    public void removePiece()
    {
        removeAll();
        updateUI();
        
        //piece = null;
    }
    
    /**
     * Ajoute une pi�ce sur la case
     * 
     * @param piece     Ajoute la pi�ce sur la case
     */
    /*public void addPiece(Piece piece)
    {
        add(new JLabel(new ImageIcon(
                "C:\\Users\\T4g1\\Desktop\\3eme\\Sys. Dis\\Labo 2\\" +
                "piecesimages\\" + piece.getFilename(piece.getEquipe())
        )));
        updateUI();
        
        this.piece = piece;
    }*/
    
    /**
     * Fonction appell�e lorsqu'on clique sur la case
     */
    public void onClic()
    {
        parent.onClic(this);
    }
    
    /**
     * Met la case en �vidence ou la r�initialise
     * 
     * @param state     true si on veut activer le highlight
     */
    public void highlight(boolean state)
    {
        if(state) {
            setBackground(highlightColor);
        } else {
            setBackground(backgroundColor);
        }
    }
    
    /**
     * Indique si la case est highlighted ou non
     * 
     * @return      true si la case est rouge
     */
    public boolean isHighlighted()
    {
        return getBackground() == highlightColor;
    }

    //<editor-fold defaultstate="collapsed" desc="Accesseurs">
    
    /**
     * Donne la position de la case en x
     * 
     * @return      Position de la case en x
     */
    public int getCaseX() {
        return x;
    }

    /**
     * Donne la position de la case en y
     * 
     * @return      Position de la case en y
     */
    public int getCaseY() {
        return y;
    }

    /**
     * Donne la largeur d'une case
     * 
     * @return      Largeur d'une case
     */
    public static int getCaseWidth() {
        return CASE_WIDTH;
    }

    /**
     * Donne la largeur d'une case
     * 
     * @return      Largeur d'une case
     */
    public static int getCaseHeight() {
        return CASE_HEIGHT;
    }

    /**
     * Donne le type de piece qui est sur la case
     * 
     * @return      Type de la pi�ce qui est sur la case
     */
    /*public Piece getPiece() {
        return piece;
    }*/
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Mutateurs">
    
    /**
     * Modifie la position de la case en x
     * 
     * @param x         Position de la case en x
     */
    public void setCaseX(int x) {
        this.x = x;
    }

    /**
     * Modifie la position de la case en y
     * 
     * @param y         Position de la case en y
     */
    public void setCaseY(int y) {
        this.y = y;
    }
    
    //</editor-fold>
}
