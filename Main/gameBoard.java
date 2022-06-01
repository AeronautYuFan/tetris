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
    private final int columns = 14;
    // # of columns
    private final int rows = 21;
    // keeps track of the score of the player
    private int score;
    private int line;
    private int level;
    //2D array for the colors of the board
    private Color[][] color;
    //2D array of booleans for each tile
    private boolean[][] fill;
    //a coordinate of where the origin of the piece is
    private Point origin;

    //Creates the 2D array of colors for the background in a grid pattern
    private void init() {
        color = new Color[columns][rows];
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == 0 || i == columns-1 || j == rows-1) {
                    color[i][j] = Color.GRAY;
                } else {
                    color[i][j] = Color.BLACK;
                }
            }
        }

        fill = new boolean[rows - 1][columns - 2];
    }

    //Uses the init() method to setup the background
    @Override
    public void paintComponent(Graphics g) {
        // Paint the well
        g.fillRect(0, 0, tileSize * columns, tileSize * rows);
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                g.setColor(color[i][j]);
                g.fillRect(tileSize * i, tileSize * j, tileSize - 1, tileSize - 1);
            }
        }
        drawPiece(g);

    }

    public gameBoard(){
        //sets the dimensions of the board
        setPreferredSize(new Dimension(columns*tileSize, rows*tileSize));
        //initialize the state of the game
        init();
        newPiece();
        score = 0;
        line = 0;
        level = 0;
    }

    public boolean isFilled(int x, int y){
        return(fill[y][x]);
    }

    public void newPiece(){
        origin = new Point(6, 1);
    }

    public void drawPiece(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(origin.x*tileSize, origin.y*tileSize,tileSize-1, tileSize-1);
    }

    // need a way to remove a row of tetris pieces
    public void removeRow(){
    }

    // checks if there is a filled row, if so, the method removeRow() is used and the score is increased
    public void clearRow(){
    }


}
