import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {
    private gameBoard board;
    private scoreBoard sBoard;
    public Tetris(){
        board = new gameBoard();
        sBoard = new scoreBoard();

        add(board, BorderLayout.WEST);
        add(sBoard, BorderLayout.EAST);
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
