import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Side {
	
	public static enum sideTaste { PASTELES, MOGONGO, TEMBLEQUE, AMARILLOS, BACALAITOS, ALCUPURRIA, LECHON, MORCILLA }
	public static sideTaste id;
	public String myId=null;
	public ImageIcon gemIcon;
	public static int n; 
	
	
	protected int row;
    protected int col;
    protected int anim_row;
    protected int anim_col;
    protected boolean focus;
    
    protected static int xTop=135;
    protected static int yLeft=50;
    protected static int size;
   
    
    
    

	public Side(sideTaste id, int row, int col, int n){
		//this.id = id;
		this.myId= String.valueOf(id);
		this.n = n;
		this.row = row;
        this.col = col;
        this.anim_row = row*(80*4/n)+yLeft;
        this.anim_col = col*(80*4/n)+xTop;//80 cambiarlo a....(tenia92)
        setFocus(false);
		this.gemIcon = new ImageIcon();
		size = Fed.food.getImage(id).getWidth()*4/n;
		Image newimg = Fed.food.getImage(id).getScaledInstance(Fed.food.getImage(id).getWidth()*4/n, Fed.food.getImage(id).getHeight()*4/n,  java.awt.Image.SCALE_SMOOTH);  
        this.gemIcon.setImage(newimg);
        
	}
	public String getID(){
		return this.myId;
	}
	
	public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        gemIcon.paintIcon(null, g, anim_col, anim_row);
  
    }
	
    public void setAnimRow(int row){
        this.row = row;
        this.anim_row = row*(80*4/n)+60;
    }
    public void setAnimCol(int col){ 
        this.col = col;
        this.anim_col = col*(92*4/n)+120;
    }
    public void setFocus(boolean flag){
    	this.focus=flag;
    
    }
    public boolean isFocus(){
    	return focus;
    }
   
}
