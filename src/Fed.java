import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class Fed extends JComponent{
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	public static Food food = new Food();
	public static Dish dish;
	public BufferedImage tableImage;
	public ImageIcon tableIcon;
	public int n = 9;//esta variable debe tener el valor que escoja el servidor
	

	public Fed(){
		try {
			tableImage = ImageIO.read(new File("table.png"));
		} catch (IOException e) { }
		
		this.tableIcon = new ImageIcon();
		this.tableIcon.setImage(this.tableImage);
		dish = new Dish(n);
	}
	
	 public void paintComponent(Graphics g){
	        this.tableIcon.paintIcon(null, g, 0, 0);
	        drawGems(g);
	    }
	    private void drawGems(Graphics g){
	        int row,col;
	        for (row=0;row<n;row++){
	            for (col=0;col<n;col++){
	                Side side = dish.getPuertoRican(row, col);
	                side.draw(g);
	            }
	        }
	    }
}
