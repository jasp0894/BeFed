import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;


public class Food {

	private HashMap<Side.sideTaste,BufferedImage> traditionalFood;
	private static BufferedImage img;
	
    public Food() {
        traditionalFood= new HashMap(5);

        try {
        	img = ImageIO.read(new File("pasteles.png"));
        	traditionalFood.put(Side.sideTaste.PASTELES, img);
        } 
        catch (IOException e) { }
        
        try {
        	img = ImageIO.read(new File("amarillos.png"));
        	traditionalFood.put(Side.sideTaste.AMARILLOS, img);
        } 
        catch (IOException e) { }
        
        try {
        	img = ImageIO.read(new File("tembleque.png"));
        	traditionalFood.put(Side.sideTaste.TEMBLEQUE, img);
        } 
        catch (IOException e) { }
        
        try {
        	img = ImageIO.read(new File("bacalaitos.png"));
        	traditionalFood.put(Side.sideTaste.BACALAITOS, img);
        } 
        catch (IOException e) { }
        
        try {
        	img = ImageIO.read(new File("mofongo.png"));
        	traditionalFood.put(Side.sideTaste.MOGONGO, img);
        } 
        catch (IOException e) { }
        
        try {
        	img = ImageIO.read(new File("alcapurria.png"));
        	traditionalFood.put(Side.sideTaste.ALCUPURRIA, img);
        } 
        catch (IOException e) { }
        
        try {
        	img = ImageIO.read(new File("lechon.png"));
        	traditionalFood.put(Side.sideTaste.LECHON, img);
        } 
        catch (IOException e) { }
        
        try {
        	img = ImageIO.read(new File("morcilla.png"));
        	traditionalFood.put(Side.sideTaste.MORCILLA, img);
        } 
        catch (IOException e) { }
        
    }
    BufferedImage getImage(Side.sideTaste id) {
        return traditionalFood.get(id);
    }
}
