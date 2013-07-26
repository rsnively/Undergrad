package undergrad;

import javax.swing.JFrame;

public class Undergrad extends JFrame
{
  public Undergrad()
	{
		Board board = new Board(this);
		add(board);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 400);
		setLocationRelativeTo(null);
		setTitle("Undergrad");
		
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new Undergrad();
	}
}
