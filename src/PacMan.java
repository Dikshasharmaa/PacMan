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

    //Creating variable for images
    private Image wallImage;
    private Image blueGhostImage;
    private Image orangeGhostImage;
    private Image pinkGhostImage;
    private Image redGhostImage;

    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image pacmanRightImage;



    PacMan(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);

    }

}
