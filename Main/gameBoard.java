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
    private Piece tetrisBlock;

    //private Thread timer;

    public gameBoard(){
        //sets the dimensions of the board
        setPreferredSize(new Dimension(Source.COLUMNS*Source.TILESIZE, Source.ROWS*Source.TILESIZE));
        //initialize the state of the game
        init();
        //The pieces
        tetrisBlock = new Piece(5);
        addKeyListener(this);
        setFocusable(true);

        //Moves the pieces down every second

    }


    public void setColor(int x, int y, Color c) {
        color[x][y] = c;
    }

    public Color getColor(int x, int y) {
        return color[x][y];
    }

    public Piece getGamePiece() { return tetrisBlock; }

    public void setGamePiece(Piece p) { tetrisBlock = p; }

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
    public void colorPiece(){
        Block block1 = tetrisBlock.getBlock1();
        Block block2 = tetrisBlock.getBlock2();
        Block block3 = tetrisBlock.getBlock3();
        Block block4 = tetrisBlock.getBlock4();

        color[block1.getOriginX()][block1.getOriginY()] = tetrisBlock.getPieceColor();
        color[block2.getOriginX()][block2.getOriginY()] = tetrisBlock.getPieceColor();
        color[block3.getOriginX()][block3.getOriginY()] = tetrisBlock.getPieceColor();
        color[block4.getOriginX()][block4.getOriginY()] = tetrisBlock.getPieceColor();
    }

    public boolean collisionFloor(){
        Block block1 = tetrisBlock.getBlock1();
        Block block2 = tetrisBlock.getBlock2();
        Block block3 = tetrisBlock.getBlock3();
        Block block4 = tetrisBlock.getBlock4();

        boolean result = false;

        if (color[block1.getOriginX()][block1.getOriginY() + 1] == Color.GRAY ||
                ((Source.FILL[block1.getOriginX() - 1][block1.getOriginY() + 1]) &&
                        !(block2.checkPoint(block1.getOriginX(), block1.getOriginY() + 1) ) &&
                        !(block3.checkPoint(block1.getOriginX(), block1.getOriginY() + 1) ) &&
                        !(block4.checkPoint(block1.getOriginX(), block1.getOriginY() + 1) )
                        )
        ) result = true;

        if (color[block2.getOriginX()][block2.getOriginY() + 1] == Color.GRAY ||
                ((Source.FILL[block2.getOriginX() - 1][block2.getOriginY() + 1]) &&
                        !(block1.checkPoint(block2.getOriginX(), block2.getOriginY() + 1) ) &&
                        !(block3.checkPoint(block2.getOriginX(), block2.getOriginY() + 1) ) &&
                        !(block4.checkPoint(block2.getOriginX(), block2.getOriginY() + 1) )
                )
        ) result = true;

        if (color[block3.getOriginX()][block3.getOriginY() + 1] == Color.GRAY ||
                ((Source.FILL[block3.getOriginX() - 1][block3.getOriginY() + 1]) &&
                        !(block1.checkPoint(block3.getOriginX(), block3.getOriginY() + 1) ) &&
                        !(block2.checkPoint(block3.getOriginX(), block3.getOriginY() + 1) ) &&
                        !(block4.checkPoint(block3.getOriginX(), block3.getOriginY() + 1) )
                )
        ) result = true;

        if (color[block4.getOriginX()][block4.getOriginY() + 1] == Color.GRAY ||
                ((Source.FILL[block4.getOriginX() - 1][block4.getOriginY() + 1]) &&
                        !(block1.checkPoint(block4.getOriginX(), block4.getOriginY() + 1) ) &&
                        !(block2.checkPoint(block4.getOriginX(), block4.getOriginY() + 1) ) &&
                        !(block3.checkPoint(block4.getOriginX(), block4.getOriginY() + 1) )
                )
        ) result = true;

        return result;
    }

    public boolean collisionRightWall(){ /*
        if(color[tetrisBlock.getOriginX() + 1][tetrisBlock.getOriginY()] == Color.GRAY || (Source.FILL[tetrisBlock.getOriginX()][tetrisBlock.getOriginY()]))
            return true;
        else */
            return false;

    }

    public boolean collisionLeftWall(){ /*
        if(color[tetrisBlock.getOriginX() - 1][tetrisBlock.getOriginY()] == Color.GRAY || (Source.FILL[tetrisBlock.getOriginX() - 2][tetrisBlock.getOriginY()]))
            return true;
        else */
            return false;

    }

    // need a way to remove a row of tetris pieces
    public void removeRow(int row){
        for(int r = row; r > 1; r--) {
            for(int c = 1; c < color.length - 1; c++) {
                color[c][r] = color[c][r - 1];
                Source.setFillValue(c-1, r, Source.FILL[c - 1][r - 1]);
            }
        }
        repaint();
    }

    // checks if there is a filled row, if so, the method removeRow() is used and the score is increased
    public void fullRowCheck(){
        boolean temp = true;
        int tempRow = 0;
        for(int r = Source.FILL[0].length - 1; r > 0; r--) {
            for(int c = 0; c < Source.FILL.length; c++) {
                if(Source.FILL[c][r] == false) {
                    temp = false;
                }
            }
            if(temp) {
                tempRow = r;
            }
            temp = true;
        }
        if(tempRow > 0) {
            removeRow(tempRow);
            Source.addSCORE(12);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e){
        // New key press
        int  key = e.getKeyCode();

        //right arrow key pressed

        if (key == KeyEvent.VK_RIGHT) {
            if(!collisionFloor() && !collisionRightWall())
                tetrisBlock.moveLeftRight(1);
        }
        //left arrow key pressed
        if (key == KeyEvent.VK_LEFT) {
            if(!collisionFloor() && !collisionLeftWall())
                tetrisBlock.moveLeftRight(-1);
        }
        //down arrow key pressed


        if (key == KeyEvent.VK_DOWN) {
            if(!collisionFloor())
                tetrisBlock.moveDown();
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
