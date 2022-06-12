import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tetris extends JFrame {
    private gameBoard board;
    private scoreBoard sBoard;
    private JButton bigRedButton;
    private Timer gameTimer;
    
    public Tetris() {
        board = new gameBoard();
        sBoard = new scoreBoard();
        bigRedButton = new JButton("Restart");
        bigRedButton.setLayout(null);
        bigRedButton.addActionListener(new restartListener());
        bigRedButton.setBounds(160, 401, 30, 30); // 454
        sBoard.add(bigRedButton);
        add(board, BorderLayout.WEST);
        add(sBoard, BorderLayout.EAST);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

        gameTimer = new Timer(850, new timerListener() );
        gameTimer.start();


    }

    private class timerListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            board.fullRowCheck();

            if (!board.collisionFloor()) {
                board.getGamePiece().moveDown();
                repaint();
            } else {
                board.colorPiece();
                Source.setFillValue(board.getGamePiece().getOriginY(), board.getGamePiece().getOriginX(), true);
                board.setGamePiece(new Block());
            }
        }
    }


    private class restartListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            Source.restart();

        }
    }

    public static void main(String[] args) {
        new Tetris();
    }

    public void refresh() {
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
    
} // 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
