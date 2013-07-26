package undergrad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener
{
  private final int WIDTH = 800;
	private final int HEIGHT = 400;
	
	private Image background;
	private Timer timer;
	private Player player;
	
	public Board(Undergrad parent)
	{
		addKeyListener(new TAdapter());
		setBackground(Color.BLACK);
		
		ImageIcon ii = new ImageIcon(this.getClass().getResource("background.png"));
		background = ii.getImage();
		
		player = new Player();
		
		setFocusable(true);
		initGame();
	}
	
	public void initGame()
	{
		timer = new Timer(40, this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.drawImage(background,100,25,this);
		g.drawImage(player.getImage(),player.getX(),player.getY(),this);
		
		Toolkit.getDefaultToolkit().sync();
		
		g.dispose();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		player.move();
		repaint();
	}
	
	private class TAdapter extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			player.keyPressed(e);
		}
		
		public void keyReleased(KeyEvent e)
		{
			player.keyReleased(e);
		}
	}
}
