package Entity;

import Chess.ChessCase;
import Chess.Constant;
import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author T4g1
 */
@Entity
public class Cavalier extends Piece implements Serializable {
    private static final List<Point> correctMoves = new ArrayList<>();
    static {
        correctMoves.add(new Point( 2,  1));
        correctMoves.add(new Point( 2, -1));
        correctMoves.add(new Point(-2,  1));
        correctMoves.add(new Point(-2, -1));
        correctMoves.add(new Point( 1,  2));
        correctMoves.add(new Point( 1, -2));
        correctMoves.add(new Point(-1,  2));
        correctMoves.add(new Point(-1, -2));
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //<editor-fold defaultstate="collapsed" desc="Constructeur">

    public Cavalier() {
    }
    
    /**
     * Constructeur du fou
     * 
     * @param x         Absice de la piece
     * @param y         Ordonnée de la piéce
     * @param color     Couleur de la piece
     */
    public Cavalier(int x, int y, Color color)
    {
        super(x, y, color);
    }
    
    //</editor-fold>
    
    /**
     * Donne les déplacements possible de la piéce
     * @param l_case        Liste des cases
     * @return              Liste des position possible
     */
    @Override
    public List<Point> whereCanItGo(ChessCase[][] l_case) {
        List<Point> l_where = new ArrayList<>();
        
        for(Point p: correctMoves) {
            int dx = (int)p.getX();
            int dy = (int)p.getY();
            
            int x = getPieceX() + dx;
            int y = getPieceY() + dy;
            
            if (x >= 0 && y >= 0 &&
                x < Constant.GRID_WIDTH && y < Constant.GRID_HEIGHT &&
                   (l_case[x][y].getPiece() == null ||
                    l_case[x][y].getPiece().getColor().getRGB() != getColor().getRGB())
                )
            {
                l_where.add(new Point(x, y));
            }
        }
        
        return l_where;
    }
    
    /**
     * Donne le nom de fichier de la piéce
     * @return              Nom du fichier contenant la piéce
     */
    @Override
    public String getFilename()
    {
        if(color.getRGB() == Color.WHITE.getRGB()) {
            return "7b.gif";
        }
        else {
            return "0b.gif";
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cavalier)) {
            return false;
        }
        Cavalier other = (Cavalier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Cavalier[ id=" + id + " ]";
    }
    
}
