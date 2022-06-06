import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.*;

public class gameBoard extends JPanel{
    // the tile size of each grid block
    private final int tileSize = 21;
    // # of rows
    private final int columns = 14;
    // # of columns
    private final int rows = 21;
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
        // Draws the falling piece
        drawPiece(g);


    }

    public gameBoard(){
        //sets the dimensions of the board
        setPreferredSize(new Dimension(columns*tileSize, rows*tileSize));
        //initialize the state of the game
        init();
        //The pieces
        newPiece();

        //Moves the pieces down every second
        new Thread() {
            @Override public void run() {
                while (true) {
                    try {
                        Thread.sleep(850);
                        moveDown();
                        repaint();
                    } catch ( InterruptedException e ) {}
                }
            }
        }.start();

    }

    public boolean isFilled(int x, int y){
        return(fill[y][x]);
    }

    // Creates a new piece at the origin. Need to randomize piece type
    public void newPiece(){
        origin = new Point(6, 0);
        fill[0][6] = true;
    }

    // Draws the piece on the board. Need to randomize color
    public void drawPiece(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(origin.x*tileSize, origin.y*tileSize,tileSize-1, tileSize-1);
    }

    // Fixes the block in its place (Makes the block a part of the background
    public void setPiece(){
        color[origin.x][origin.y] = Color.RED;
    }

    // Moves the current block down 1 grid until it collides with the border of another block
    public void moveDown(){

        if(origin.y < rows - 2 && fill[origin.y + 1][origin.x] == false ) {
            int oldY = origin.y;
            origin.y+=1;
            fill[origin.y][origin.x] = true;
            fill[oldY][origin.x] = false;
        }
        else{
            setPiece();
            newPiece();
        }
    }

    // need a way to remove a row of tetris pieces
    public void removeRow(){
    }

    // checks if there is a filled row, if so, the method removeRow() is used and the score is increased
    public void clearRow(){
    }




}
