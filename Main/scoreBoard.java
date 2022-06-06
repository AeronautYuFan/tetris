import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.event.*;

public class scoreBoard extends JPanel {
    // the tile size of each grid block
    private final int tileSize = 21;
    // # of rows
    private final int columns = 7;
    // # of columns
    private final int rows = 21;
    // keeps track of the score of the player
    private int score;
    private int line;
    private int level;

    public scoreBoard() {
        //sets the dimensions of the board
        setPreferredSize(new Dimension(200, 441));
        setBackground(Color.LIGHT_GRAY);

    }

    @Override // JTextField
    public void paintComponents(Graphics g) {

    }
}
