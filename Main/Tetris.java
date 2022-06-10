import javax.swing.*;
import java.awt.*;
import java.awt.event;

public class Tetris extends JFrame {
    private gameBoard board;
    private scoreBoard sBoard;
    private JButton bigRedButton;
    
    public Tetris(){
        board = new gameBoard();
        sBoard = new scoreBoard();
        bigRedButton = new JButton("Restart");
        bigRedButton.addActionListener(new restartListener() );

        add(board, BorderLayout.WEST);
        add(sBoard, BorderLayout.EAST);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable (true);
        setVisible (true);
    }
    
    private class restartListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            refresh();
        }
    }

    public static void main(String[] args) {
        new Tetris();
    }

    public void refresh() {
        board = new gameBoard();
        sBoard = new scoreBoard();
        Source.restart();
        
        add(board, BorderLayout.WEST);
        add(sBoard, BorderLayout.EAST);
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable (true);
        setVisible (true);
    }
    
}
