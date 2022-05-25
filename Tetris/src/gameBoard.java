import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class gameBoard extends JPanel{
    // the tile size of each grid block
    private final int tileSize = 21;
    // # of rows
    private final int rows = 14;
    // # of columns
    private final int columns = 21;
    // keeps track of the score of the player
    private int score;
    private int line;
    private int level;
    private Color[][] color;

    //Creates the 2D array of colors for the background in a grid pattern
    private void init() {
        color = new Color[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 || i == rows-1 || j == columns-1) {
                    color[i][j] = Color.GRAY;
                } else {
                    color[i][j] = Color.BLACK;
                }
            }
        }
    }

    //Uses the init() method to setup the background
    @Override
    public void paintComponent(Graphics g)
    {
        // Paint the well
        g.fillRect(0, 0, tileSize*rows, tileSize*columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                g.setColor(color[i][j]);
                g.fillRect(tileSize*i, tileSize*j, tileSize-1, tileSize-1);
            }
        }
    }

    public gameBoard() {
        //sets the dimensions of the board
        setPreferredSize(new Dimension(rows*tileSize, columns*tileSize));
        //set background color, right now it is set to black
        //setBackground(new Color(0, 0, 0));
        //initialize the state of the game
        init();
        score = 0;
        line = 0;
        level = 0;
    }

}
