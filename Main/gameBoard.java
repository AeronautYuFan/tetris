import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class gameBoard extends JPanel implements ActionListener, KeyListener {
    // the tile size of each grid block
    private final int tileSize = Source.TILESIZE;
    // # of rows
    private final int columns = Source.COLUMNS;
    // # of columns
    private final int rows = Source.ROWS;
    //2D array for the colors of the board
    private Color[][] color;
    //Block object
    private Block tetrisBlock;

    public gameBoard(){
        //sets the dimensions of the board
        setPreferredSize(new Dimension(columns*tileSize, rows*tileSize));
        //initialize the state of the game
        init();
        //The pieces
        tetrisBlock = new Block();
        addKeyListener(this);
        setFocusable(true);

        //Moves the pieces down every second
        new Thread() {
            @Override public void run() {
                while (true) {
                    try {
                        Thread.sleep(850);
                        if(!collisionFloor()) {
                            tetrisBlock.moveDown();
                            repaint();
                        }
                        else {
                            setPiece();
                            Source.setFillValue(tetrisBlock.getOriginY(), tetrisBlock.getOriginX(), true);
                            tetrisBlock = new Block();
                        }
                    } catch ( InterruptedException e ) {}
                }
            }
        }.start();

    }

    public void setColor(int x, int y, Color c) {
        color[x][y] = c;
    }

    public Color getColor(int x, int y) {
        return color[x][y];
    }

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
    }

    //Uses the init() method to set up the background
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
        //Draws the piece
        tetrisBlock.drawPiece(g);
    }
    public void setPiece(){
        color[tetrisBlock.getOriginX()][tetrisBlock.getOriginY()] = tetrisBlock.getRealColor();
    }

    public boolean collisionFloor(){
        if(color[tetrisBlock.getOriginX()][tetrisBlock.getOriginY() + 1] == Color.GRAY || (Source.FILL[tetrisBlock.getOriginY() + 1][tetrisBlock.getOriginX()]))
            return true;
        else
            return false;
    }

    public boolean collisionRightWall(){
        if(color[tetrisBlock.getOriginX() + 1][tetrisBlock.getOriginY()] == Color.GRAY || (Source.FILL[tetrisBlock.getOriginY()][tetrisBlock.getOriginX() + 1]))
            return true;
        else
            return false;
    }

    public boolean collisionLeftWall(){
        if(color[tetrisBlock.getOriginX() - 1][tetrisBlock.getOriginY()] == Color.GRAY || (Source.FILL[tetrisBlock.getOriginY()][tetrisBlock.getOriginX() - 1]))
            return true;
        else
            return false;
    }

    // need a way to remove a row of tetris pieces
    public void removeRow(){
    }

    // checks if there is a filled row, if so, the method removeRow() is used and the score is increased
    public void clearRow(){
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e){
        // New key press
        int  key = e.getKeyCode();

        //right arrow key pressed
        if (key == KeyEvent.VK_RIGHT) {
            if(!collisionFloor() && !collisionRightWall())
                tetrisBlock.moveHorizontal(1);
        }
        //left arrow key pressed
        if (key == KeyEvent.VK_LEFT) {
            if(!collisionFloor() && !collisionLeftWall())
                tetrisBlock.moveHorizontal(-1);
        }
        //down arrow key pressed
        if (key == KeyEvent.VK_DOWN) {
            //TO DO
        }
        //up arrow key pressed
        if (key == KeyEvent.VK_UP) {
            //TO DO
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
