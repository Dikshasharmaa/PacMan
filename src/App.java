import javax.swing.JFrame;
public class App {
    public static void main(String[] args) throws Exception {
        int rows = 21;
        int columns = 19;
        int tileSize = 32;
        int boardWidth = columns *tileSize;
        int boardHeight = rows* tileSize;

        JFrame frame = new JFrame("Pac Man"); // Creating a new frame with name Pac Man
        // frame.setVisible(true); //To make the frame visible
        frame.setSize(boardWidth, boardHeight); // seting the size of the board
        frame.setLocationRelativeTo(null); // to keep the frame in center
        frame.setResizable(false); // so that the user can't resize the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so that the user can exit after clicking close

        //Createing instance og Pac Man class
        PacMan pacmanGame = new PacMan();
        //Adding panel to Window
        frame.add(pacmanGame);
         // To get full size of panel within the window 
        frame.pack();
        frame.setVisible(true);
        pacmanGame.requestFocus();




    }
}
