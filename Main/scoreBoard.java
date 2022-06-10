import java.awt.*;
import javax.swing.*;

public class scoreBoard extends JPanel {
    // keeps track of the score of the player

    private Score realScore;
    private JLabel scoreBox;

    public scoreBoard() {
        realScore = new Score();
        scoreBox = new JLabel("Score: " + realScore.getPoints());
        //scoreBox.setVisible(true);

        this.add(scoreBox);

        //sets the dimensions of the board
        setPreferredSize(new Dimension(200, 441));
        setBackground(Color.LIGHT_GRAY);
    }

    @Override // JTextField
    public void paintComponents(Graphics g) {

    }



}
