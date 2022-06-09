import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class gameBoard extends JPanel   {
    // the tile size of each grid block
    private final int tileSize = Source.TILESIZE;
    // # of rows
    private final int columns = Source.COLUMNS;
    // # of columns
    private final int rows = Source.ROWS;
    //2D array for the colors of the board
    private Color[][] color;
    //2D array of booleans for each tile

    public gameBoard(){
        //sets the dimensions of the board
        setPreferredSize(new Dimension(columns*tileSize, rows*tileSize));
        //initialize the state of the game
        init();
        //The pieces
        Block a = new Block(6, 0);

        this.addKeyListener(new input_1());

        //Moves the pieces down every second
        /*
        new Thread() {
            @Override public void run() {
                while (true) {
                    try {
                        Thread.sleep(850);
                        moveDown();
                        //repaint();
                    } catch ( InterruptedException e ) {}
                }
            }
        }.start();

*/
    }

    public void setColor(int x, int y, Color c) {
        color[y][x] = c;
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
    public void drawPiece(Graphics g, Block b){
        g.setColor(Color.RED);
        g.fillRect(b.getOriginX()*Source.TILESIZE, b.getOriginY()*Source.TILESIZE,Source.TILESIZE-1, Source.TILESIZE-1);
    }


    public void setPiece(Block b){
        Tetris.alterColor(origin.x, origin.y);
    }

    public void moveDown(){

        if(origin.y < Source.ROWS - 2 && Source.FILL[origin.y + 1][origin.x] == false ) {
            int oldY = origin.y;
            origin.y+=1;
            repaint();
        }
        else{
            setPiece();

        }
    }


    // Creates a new piece at the origin. Need to randomize piece type


    // Draws the piece on the board. Need to randomize color



    public void moveRight(){
        origin.x++;
        repaint();
    }

    // need a way to remove a row of tetris pieces
    public void removeRow(){
    }

    // checks if there is a filled row, if so, the method removeRow() is used and the score is increased
    public void clearRow(){
    }


    private class input_1 implements ActionListener, KeyListener
    {
        @Override
        public void keyTyped(KeyEvent e) {
            return;

        }

        public void keyPressed(KeyEvent e){
            // New key press
            //int  key = e.getKeyCode();
            //right arrow key pressed
            System.out.println("pressed");
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                System.out.println("right");
                moveRight();
            }
            //left arrow key pressed
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                //TO DO
            }
            //down arrow key pressed
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                //TO DO
            }
            //up arrow key pressed
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                //TO DO
            }
            repaint();

        }

        /*public void init() {
            gameBoard.addKeyListener(this);
        }*/

        @Override
        public void keyReleased(KeyEvent e) {
            return;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            return;
        }
    }


}
