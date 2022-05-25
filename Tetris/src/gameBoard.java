import javax.swing.*;
import java.awt.*;

public class gameBoard extends JPanel{
    // the tile size of each grid block
    private final int tileSize = 40;
    // # of rows
    private final int rows = 12;
    // # of columns
    private final int columns = 20;
    // keeps track of the score of the player
    private int score;
    private int line;
    private int level;

    public gameBoard() {
        //sets the dimensions of the board
        setPreferredSize(new Dimension(tileSize * columns, tileSize * rows));
        //set background color, right now it is set to black
        setBackground(new Color(0, 0, 0));
        //initialize the state of the game
        score = 0;
        line = 0;
        level = 0;
    }
}
