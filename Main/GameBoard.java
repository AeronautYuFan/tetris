
import javax.swing.JFrame;

public class GameBoard {
	public static final int WIDTH = 445, HEIGHT = 629;
	private Board board;
	private JFrame window;

	public GameBoard() {
		window = new JFrame("Tetris");
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		board = new Board();
		window.add(board);
		window.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new GameBoard();
	}
}
