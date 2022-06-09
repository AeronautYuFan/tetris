import java.awt.*;
import javax.swing.JPanel;

public class scoreBoard extends JPanel {
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