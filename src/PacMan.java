import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashSet;

public class PacMan extends JPanel{
    class Block{
        int x;
        int y;
        int width;
        int height;
        Image image;

        int startX;
        int startY;

        Block(Image image, int x, int y, int width, int height){
            this.image = image;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.startX = x;
            this.startY = y;
        }
    }
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

    //Tile Map X-> Wall, P-> pacman, ''-> food
    // Ghosts: b-> blue ghost, o-> Orange ghost, p-> pink ghost, r-> red ghost
    // Creating a array of String for tile map
    private String[] tileMap ={
        "XXXXXXXXXXXXXXXXXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXrXX X XXXX",
        "O       bpo       O",
        "XXXX X XXXXX X XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X  X     P     X  X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX" 
    };

    //Craeting HashSets : Representation of objects in a game.
    HashSet<Block> walls;
    HashSet<Block> food;
    HashSet<Block> ghosts;
    Block pacman;


    PacMan(){
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);

        //load Images
        wallImage = new ImageIcon(getClass().getResource("./wall.png")).getImage(); //getClass refers to PacMan class
        blueGhostImage = new ImageIcon(getClass().getResource("./blueGhost.png")).getImage();
        orangeGhostImage = new ImageIcon(getClass().getResource("./orangeGhost.png")).getImage();
        pinkGhostImage = new ImageIcon(getClass().getResource("./pinkGhost.png")).getImage();
        redGhostImage = new ImageIcon(getClass().getResource("./redGhost.png")).getImage();

        pacmanUpImage = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
        pacmanDownImage = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
        pacmanLeftImage = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
        pacmanRightImage = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage(); 

        loadMap();
        
    }
    public void loadMap(){
        walls = new HashSet<Block>();
        food = new HashSet<Block>();
        ghosts = new HashSet<Block>();

        for(int i =0; i<rows; i++){
            for(int j =0; j<columns; j++){
                String row = tileMap[i]; // getting curent row
                char tileChar = row.charAt(j); //getting current char 

                int x = j* tileSize;
                int y = i*tileSize;

                if(tileChar == 'X'){
                    Block wall = new Block(wallImage, x, y, tileSize, tileSize);
                    walls.add(wall);
                }
                else if (tileChar == 'b') {
                    Block ghost = new Block(blueGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(ghost);
                }
                else if (tileChar == 'o') {
                    Block oGhost = new Block(orangeGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(oGhost);
                }
                else if (tileChar == 'r') {
                    Block rGhost = new Block(redGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(rGhost);
                }
                else if (tileChar == 'p') {
                    Block pGhost = new Block(pinkGhostImage, x, y, tileSize, tileSize);
                    ghosts.add(pGhost);
                }
                else if (tileChar == 'P') {
                    pacman = new Block(pacmanRightImage, x, y, tileSize, tileSize);
                    
                }
                else if (tileChar == ' ') {
                    Block foods = new Block(null, x+14, y+14, 4, 4);   
                    food.add(foods);
                }

            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);

    }
    public void draw(Graphics g){
        g.drawImage(pacman.image, pacman.x, pacman.y, pacman.width, pacman.height, null);

        for(Block ghost: ghosts){
            g.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height, null);
        }

    }

}
