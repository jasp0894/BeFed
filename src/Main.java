import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Main extends JFrame{

	public static int n;
	/**
	 */
	private static final long serialVersionUID = 1L;
	public Main(){
		windowSize();
		
		setTitle("BeFed");
        setLayout(new BorderLayout());
        setDefaultCloseOperation (EXIT_ON_CLOSE);
        
        // Content Pane Setup
        Fed homeFed = new Fed();
        Fed guestFed = new Fed();
        WindowPanel wPanel = new WindowPanel(homeFed, guestFed);
        add(wPanel,BorderLayout.CENTER);
        
        //set visible
        setVisible(true);
        
	}

	public static void setServerConstant(int server_n){
		n=server_n;
	}
	public void windowSize(){
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = (int) (screenSize.height/1.37);
        int screenWidth  = (int) (screenSize.width/1.1);
        setSize((int)screenWidth,(int)screenHeight);
        setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main();
        
	}

}
