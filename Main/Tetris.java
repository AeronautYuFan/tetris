import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {
    public Tetris(){
        add(new gameBoard(), BorderLayout.WEST);
        add(new scoreBoard(), BorderLayout.EAST);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable (true);
        setVisible (true);

    }

    public static void main(String[] args) {
        new Tetris();
    }
}
