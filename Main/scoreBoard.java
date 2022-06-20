import java.awt.*;
import javax.swing.*;

public class scoreBoard extends JPanel {
    // keeps track of the score of the player

    private JLabel scoreBox;
    private JLabel gameOver;

    //private

    public scoreBoard() {
        scoreBox = new JLabel("Score: " + Source.SCORE);
        this.add(scoreBox);
        gameOver = new JLabel("Game over!");
        gameOver.setLocation(100, 100);
        gameOver.setForeground(Color.RED);
        this.add(gameOver);
        gameOver.setVisible(false);

        //sets the dimensions of the board
        setPreferredSize(new Dimension(200, 441));
        setBackground(Color.LIGHT_GRAY);
    }

    public void updateScore(){
        scoreBox.setText("Score: " + Source.SCORE);
    }

    public void showGameOver() {
        gameOver.setVisible(true);
    }

    public void removeGameOver(){
        gameOver.setVisible(false);
    }
}
