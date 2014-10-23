import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class SideClickListener implements MouseListener{
	private boolean firstTime=true;
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if(firstTime){
				//***(Side.n*Side.size+ 4) es el tama~o del dish (podria ser una variable en la clase Dish)
			  if(arg0.getX()>=(Side.xTop)&& arg0.getX()<=(Side.xTop+Side.n*Side.size+ 4)
			    && arg0.getY()>=Side.yLeft && arg0.getY()<=(Side.xTop+Side.n*Side.size+ 4)){
				System.out.println("the panel was clicked on position: " + "x: " + (arg0.getX()-Side.xTop)
						+ " y: " + (arg0.getY()-Side.yLeft));
				System.out.println(Side.n*Side.size+ 4 + " " + Side.size);
				
				//tal vez se deben crear dos variables que contengan las restas que se envian de parametro
				 Fed.dish.foodClicked((arg0.getX()-Side.xTop), (arg0.getY()-Side.yLeft));
				 
				 System.out.println("Row: " + Fed.dish.getClickedRow() + " "+ "col: " +  Fed.dish.getClickedCol()
						        + " " + "ID: " + Fed.dish.getClickedPuertoRican().getID());
			  		} else{
			  			System.out.println("click out of food");
			  		} 
			  firstTime=false;
		}else{
			System.out.println("this is the second click!!!");
			//System.out.println(Fed.dish.checkAbove((arg0.getX()-Side.xTop), (arg0.getY()-Side.yLeft)));
			firstTime=true;
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
