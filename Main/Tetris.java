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
            Piece piece = board.getGamePiece();
            board.fullRowCheck();
            sBoard.updateScore();

            if (!board.collisionFloor()) {
                board.getGamePiece().moveDown();
                repaint();
            }

            else if(board.rowCheck(0) || board.rowCheck(1)) {
                sBoard.showGameOver();
                System.out.println("game over");
            }

            else {
                board.colorPiece();
                piece.setRotation(0);
                Source.setFillValue(piece.getBlock1().getOriginX() - 1, piece.getBlock1().getOriginY(), true);
                Source.setFillValue(piece.getBlock2().getOriginX() - 1, piece.getBlock2().getOriginY(), true);
                Source.setFillValue(piece.getBlock3().getOriginX() - 1, piece.getBlock3().getOriginY(), true);
                Source.setFillValue(piece.getBlock4().getOriginX() - 1, piece.getBlock4().getOriginY(), true);
                board.setGamePiece();
            }
        }
    }


    private class restartListener implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            remove(board);
            board = new gameBoard();
            add(board);
            Source.restart();
            setVisible(true);
            sBoard.removeGameOver();
            board.requestFocusInWindow();
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
