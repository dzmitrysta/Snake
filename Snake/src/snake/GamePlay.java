package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

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
	
	//Fruit Position
	
		private int [] fruitXpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,250,375,400,425,450,475,500,525,550,575,600,
				625,650,675,700,725,750,775,800,825,850};
		
		private int [] fruitYpos = {75,100,125,150,175,200,225,250,275,300,325,250,375,400,425,450,475,500,525,550,575,600,
				625};

		
		private ImageIcon fruitimage;
		
		private Random random = new Random();
		
		private int xpos = random.nextInt(34);
		private int ypos = random.nextInt(23);
	
	
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
		
		//Part5
				fruitimage = new ImageIcon("fruit.png");
				if(fruitXpos[xpos] == snakeXLenght[0] && fruitYpos[ypos] == snakeYLenght[0])
				{
					score= score+5;
					lengthOfSnake++;
					xpos = random.nextInt(34);
					ypos = random.nextInt(23);
				}
				
				fruitimage.paintIcon(this,g,fruitXpos[xpos], fruitYpos[ypos]);
		
		g.dispose();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.restart();
		if(right) 
		{
			for(int n = lengthOfSnake-1; n>=0;n--)
			{
				snakeYLenght[n+1] = snakeYLenght[n];
			}
			for(int n = lengthOfSnake; n>=0; n--) 
			{
				if (n==0) 
				{
					snakeXLenght[n] = snakeXLenght[n]+25;
				}
				else 
				{
					snakeXLenght[n] = snakeXLenght[n-1];
				}
				if(snakeXLenght[n] >850)
				{
					snakeXLenght[n] = 25;
				}
				
			}
			repaint();
		}
		
		if(left) 
		{
			for(int n = lengthOfSnake-1; n>=0;n--)
			{
				snakeYLenght[n+1] = snakeYLenght[n];
			}
			for(int n = lengthOfSnake; n>=0; n--) 
			{
				if (n==0) 
				{
					snakeXLenght[n] = snakeXLenght[n]-25;
				}
				else 
				{
					snakeXLenght[n] = snakeXLenght[n-1];
				}
				if(snakeXLenght[n] < 25)
				{
					snakeXLenght[n] = 850;
				}
				
			}
			repaint();			
			
		}
		if(up) 
		{
			for(int n = lengthOfSnake-1; n>=0;n--)
			{
				snakeXLenght[n+1] = snakeXLenght[n];
			}
			for(int n = lengthOfSnake; n>=0; n--) 
			{
				if (n==0) 
				{
					snakeYLenght[n] = snakeYLenght[n]-25;
				}
				else 
				{
					snakeYLenght[n] = snakeYLenght[n-1];
				}
				if(snakeYLenght[n] < 75)
				{
					snakeYLenght[n] = 625;
				}
				
			}
			repaint();
			
		}
		if(down) 
		{
			for(int n = lengthOfSnake-1; n>=0;n--)
			{
				snakeXLenght[n+1] = snakeXLenght[n];
			}
			for(int n = lengthOfSnake; n>=0; n--) 
			{
				if (n==0) 
				{
					snakeYLenght[n] = snakeYLenght[n]+25;
				}
				else 
				{
					snakeYLenght[n] = snakeYLenght[n-1];
				}
				if(snakeYLenght[n] > 625)
				{
					snakeYLenght[n] = 75;
				}
				
			}
			
			repaint();
		}
		
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			moves = 0;
			score = 0;
			lengthOfSnake=3;
			repaint();
		}
		
		
		//Key response
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			moves++;
			right = true;
			if(!left) {
				right = true;
			}
			else
			{
				right = false;
				left = true;
			}
			
			up = false;
			down = false;
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			moves++;
			left = true;
			if(!right) {
				left = true;
			}
			else
			{
				left = false;
				right = true;
			}
			
			up = false;
			down = false;
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			moves++;
			up = true;
			if(!down) {
				up = true;
			}
			else
			{
				up = false;
				down = true;
			}
			
			left = false;
			right = false;
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			moves++;
			down = true;
			if(!up) {
				down = true;
			}
			else
			{
				up = true;
				down = false;
				
			}
			
			left = false;
			right = false;
			
			
		}
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
