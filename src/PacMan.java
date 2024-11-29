import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashSet;

public class PacMan extends JPanel{
    private int rows = 21;
    private int columns = 19;
    private int tileSize = 32;
    private int boardWidth = columns *tileSize;
    private int boardHeight = rows* tileSize;

    PacMan(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);
        
    }

}
