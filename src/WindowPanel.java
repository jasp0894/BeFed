import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.Border;

public class WindowPanel extends JPanel{

	public static Date currentDate;
	public static JMenu TimeButton;
	public static int playTime;
	public static boolean stopTime;
	public static JMenuBar dateTimebar;
	public static String time;
	public static Timer t;


	public static Fed homeFed;
	public static Fed guestFed;
	public static JTextField homeName;
	public static JTextField guestName;
	public static JTextField homeScore;
	public static JTextField guestScore;
	private static final String initialMessage = "SCORE: ";
	
	public WindowPanel(Fed homefed, Fed guestFed){

		this.homeFed = homefed;
		this.guestFed = guestFed;

		homeName = new JTextField("Home name");
		guestName = new JTextField("Guest name");
		homeScore = new JTextField(initialMessage);
		guestScore = new JTextField(initialMessage);

		dateTimebar = new JMenuBar();
		dateTimebar.setLayout(new GridBagLayout());
		TimeButton = new JMenu();
		this.setLayout(new BorderLayout());
		placePart();
	}
	public static void setGuestName(String name){
		guestName.setText(name);
	}
	public static void setHomeName(String name){
		homeName.setText(name);
	}
	public static void setGuestScore(int score){
		guestScore.setText(initialMessage + score);
	}
	public static void setHomeScore(int score){
		homeScore.setText(initialMessage + score);
	}

	public void placePart(){

		TimeButton.setFont(new Font("Monospaced", Font.PLAIN, 35));
		TimeButton.setBackground(new Color(29, 250, 255));

		dateTimebar.setBackground(new Color(29, 250, 255));
		dateTimebar.add(TimeButton);
		dateTimebar.setVisible(true);
		
		//tiempo de jugada
		playTime = Main.n*10;
		stopTime = false;
		TimeButton.setText("TIME: " + playTime);
		t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WindowPanel.currentDate = new Date();
				// TODO Auto-generated method stub

				if (playTime == 10){
					TimeButton.setBackground(new Color(255, 0, 0));
					dateTimebar.setBackground(new Color(255, 0, 0));
				}
				TimeButton.setText("TIME: "+ playTime);
				if (playTime == 0) {
					stopTime = true;
				}
				else{
					playTime--;
				}
			}
		});
		t.start();
		
		add(dateTimebar, BorderLayout.NORTH);
		
		JPanel box = new JPanel();
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
		
		JPanel centerBox = new JPanel();
		centerBox.setLayout(new BoxLayout(centerBox, BoxLayout.X_AXIS));
		JPanel home = new JPanel(new BorderLayout());
		home.addMouseListener(new SideClickListener());
		JPanel guest = new JPanel(new BorderLayout());

		home.add(homeFed, BorderLayout.CENTER);
		guest.add(guestFed, BorderLayout.CENTER);

		Border borderPic = BorderFactory.createLineBorder(new Color(34,124,55), 2);
		home.setBorder(borderPic);
		guest.setBorder(borderPic);

		centerBox.add(home);
		centerBox.add(guest);

		box.add(centerBox);
		
		
		JPanel southBox = new JPanel();
		JPanel leftSouthBox = new JPanel(new GridLayout(0,1, 0,1));
		JPanel rightSouthBox = new JPanel(new GridLayout(0,1, 0,1));
		southBox.setLayout(new BoxLayout(southBox, BoxLayout.X_AXIS));
		
		homeName.setFont(new Font(homeName.getFont().getFontName(), Font.PLAIN, 20));
		homeName.setColumns(5);
		//homeName.setPreferredSize(new Dimension(5,20));
		homeName.setBackground(new Color(244, 255, 255));
		homeName.setHorizontalAlignment(JTextField.CENTER);
		homeName.setEditable(false);
		
		homeScore.setFont(new Font(homeScore.getFont().getFontName(), Font.PLAIN, 25));
		//homeScore.setPreferredSize(new Dimension(50,20));
		homeScore.setBackground(new Color(234, 255, 235));
		homeScore.setHorizontalAlignment(JTextField.LEFT);
		homeScore.setEditable(false);

		leftSouthBox.add(homeName);
		leftSouthBox.add(homeScore);	
		
		guestName.setFont(new Font(guestName.getFont().getFontName(), Font.PLAIN, 20));
		guestName.setColumns(5);
		//guestName.setPreferredSize(new Dimension(5,20));
		guestName.setBackground(new Color(244, 255, 255));
		guestName.setHorizontalAlignment(JTextField.CENTER);
		guestName.setEditable(false);

		guestScore.setFont(new Font(guestScore.getFont().getFontName(), Font.PLAIN, 25));
		//guestScore.setPreferredSize(new Dimension(50, 20));
		guestScore.setBackground(new Color(234, 255, 235));
		guestScore.setHorizontalAlignment(JTextField.LEFT);
		guestScore.setEditable(false);
		
		rightSouthBox.add(guestName);
		rightSouthBox.add(guestScore);
		
		southBox.add(leftSouthBox);
		southBox.add(rightSouthBox);
		
		box.add(southBox);
		
		add(box, BorderLayout.CENTER);

		//northBox.add(upNorthBox);
		//northBox.add(downNorthBox);

	}
}
