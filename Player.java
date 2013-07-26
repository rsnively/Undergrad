package undergrad;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player 
{
  private Image image;
	private int x, y;
	private float speed;
	private float dx, dy;
	private final int WIDTH = 20;
	private final int HEIGHT = 30;
	private final int GROUND_HEIGHT = 250;
	
	private boolean airborne;
	private long jump_start;
	
	public Player()
	{
		ImageIcon ii = new ImageIcon(this.getClass().getResource("player.png"));
		image = TransparencyUtil.makeColorTransparent(ii.getImage(), Color.WHITE);
		
		x = 300;
		y = 250;
		speed = 5;
		dx = 0;
		dy = 0;
		airborne = false;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public Image getImage()
	{
		return image;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT)
		{
			dx = -1 * speed;
		}
		if (key == KeyEvent.VK_RIGHT)
		{
			dx = speed;
		}
		if (key == KeyEvent.VK_UP)
		{
			if (airborne)
			{
				; // Do nothing
			}
			else
			{
				airborne = true;
				jump_start = System.nanoTime();
				dy = -1 * speed;
			}
			
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT ||
			key == KeyEvent.VK_RIGHT)
		{
			dx = 0;
		}
	}
	
	public void move()
	{
		x += dx;
		
		if (airborne)
		{
			float current_time = (float) ((System.nanoTime() - jump_start) / Math.pow(10, 9));
			
			dy = (float) ((-1 * speed) + current_time * (9.8));
			y += dy;
			
			if (y >= GROUND_HEIGHT)
			{
				y = GROUND_HEIGHT;
				airborne = false;
			}
		}
	}
}
