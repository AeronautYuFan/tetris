import javax.swing.*;
import java.awt.*;

public class Tetris extends JFrame {
    public Tetris(){
        add(new gameBoard());
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        pack();

        setLocationRelativeTo(null);
        setIgnoreRepaint(true);
        setResizable (true);
        setVisible (true);
    }

    public static void main(String[] args){
        new Tetris();
    }
}