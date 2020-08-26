package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
	
	private int[] snakeXLenght = new int[750];
	private int[] snakeYLenght = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private ImageIcon headRight;
	private ImageIcon headLeft;
	private ImageIcon headUp;
	private ImageIcon headDown;
	
	private int lengthOfSnake = 3;
	
	private Timer timer;
	private int delay = 100;
	private ImageIcon tail;
	
	private int moves = 0;
	private int score = 0;
	
	
	private ImageIcon titleImage;
	
	public GamePlay () {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		timer = new Timer(delay, this);
		timer.start();
	}
	
	
	public void paint(Graphics g) {
		
		if (moves == 0) {
			snakeXLenght[0]=100;
			snakeXLenght[1]=75;
			snakeXLenght[2]=50;
			
			snakeYLenght[0]=100;
			snakeYLenght[1]=100;
			snakeYLenght[2]=100;
		}
		
		//Display title
		titleImage = new ImageIcon("title.png");
		titleImage.paintIcon(this, g, 25, 5);
		
		//Display gameplay border
		g.setColor(Color.darkGray);
		g.drawRect(24, 74, 851, 577);
		
		//Display gameplay background
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		//Initial position of the head image
		headRight = new ImageIcon("headRight.png");
		headRight.paintIcon(this, g, snakeXLenght[0], snakeYLenght[0]);
		
		for (int i =0; i<lengthOfSnake; i++)
		{
			if(i==0 && right) {
			headRight = new ImageIcon("headRight.png");
			headRight.paintIcon(this, g, snakeXLenght[i], snakeYLenght[i]);
			}
			if(i==0 && left) {
				headLeft = new ImageIcon("headLeft.png");
				headLeft.paintIcon(this, g, snakeXLenght[i], snakeYLenght[i]);
				}
			if(i==0 && down) {
				headDown = new ImageIcon("headDown.png");
				headDown.paintIcon(this, g, snakeXLenght[i], snakeYLenght[i]);
				}
			if(i==0 && up) {
				headUp = new ImageIcon("headUp.png");
				headUp.paintIcon(this, g, snakeXLenght[i], snakeYLenght[i]);
				}
			
			if(i!=0) {
				tail = new ImageIcon("tail.png");
				tail.paintIcon(this, g, snakeXLenght[i], snakeYLenght[i]);
				}
		}
		
		g.dispose();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
