import java.awt.*;
import javax.swing.*;

public class scoreBoard extends JPanel {
    // keeps track of the score of the player

    private JLabel scoreBox;

    public scoreBoard() {
        scoreBox = new JLabel("Score: " + Source.SCORE);
        this.add(scoreBox);
        //sets the dimensions of the board
        setPreferredSize(new Dimension(200, 441));
        setBackground(Color.LIGHT_GRAY);
    }

    public void updateScore(){
        scoreBox.setText("Score: " + Source.SCORE);
    }
}
