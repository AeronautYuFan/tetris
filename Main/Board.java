import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel{
	public static final int BOARD_WIDTH = 10;
	public static final int BOARD_HEIGHT = 20;
	public static final int BLOCK_SIZE = 30;
	public Color[][] board = new Color[BOARD_WIDTH][BOARD_HEIGHT];
	private Timer looper; 
	
	public Board() {
		looper = new Timer(500, new ActionListener() {
			int n = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(n++);
			}
		});
		looper.start();
			
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getWidth());
		
		g.setColor(Color.white);
		for(int r = 0; r < BOARD_HEIGHT; r++) {
			g.drawLine(0, BLOCK_SIZE * r, BLOCK_SIZE * BOARD_WIDTH, r);
		}
		
		for(int c = 0; c < BOARD_WIDTH + 1; c++) {
			g.drawLine(c * BLOCK_SIZE, 0, BLOCK_SIZE * c, BLOCK_SIZE * BOARD_HEIGHT);
		}
	}

}
