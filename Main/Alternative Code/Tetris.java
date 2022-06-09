import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {
    private gameBoard board;
    public Tetris(){
        board = new gameBoard();

        add(board, BorderLayout.WEST);
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