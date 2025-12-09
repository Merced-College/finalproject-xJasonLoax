//Jason Loa 12/9/25
//Create a drum program, plays drum sounds when clicked. 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//implements ActionListener interface, overrides actionPerformed 
public class LaunchPage implements ActionListener{
	
	//HashMap for Drums sounds (kick, snare, and tom)
	HashMap<JButton, DrumSounds> drumMap = new HashMap<>();
	
	//assigns the sound files to names for the drums
	DrumSounds snareSound = new DrumSounds("src/assets/snaresound1.wav");
	DrumSounds floortomSound = new DrumSounds("src/assets/floortom.wav");
	DrumSounds kickdrumSound = new DrumSounds("src/assets/kickdrum.wav");
	
	//HashMap for Cymbal sounds (crash 1 and 2, hihat, and ride)
	HashMap<JButton, CymbalSounds> cymbalMap = new HashMap<>();
	
	//assigns the sound files to names for the cymbals
	CymbalSounds cymbal1Sound = new CymbalSounds("src/assets/crashcymbal10.wav");
	CymbalSounds cymbal2Sound = new CymbalSounds("src/assets/crashcymbal20.wav");
	CymbalSounds hihatSound = new CymbalSounds("src/assets/hihat10.wav");
	CymbalSounds rideSound = new CymbalSounds("src/assets/ridecymbal10.wav");
	
	//HashMap for keyboard input to JButton to play all sounds
	HashMap<Integer, JButton> cymbalkeyMap = new HashMap<>();
	HashMap<Integer, JButton> drumkeyMap = new HashMap<>();
	
	/***************************************************************************************
	*    Title: "Java open a new GUI window"
	*    Author: Bro Code
	*    Date: June 5, 2020
	*    Availability: https://www.youtube.com/watch?v=HgkBvwgciB4
	***************************************************************************************/
	
	// this opens the window and the button for the snare and snare image
	JFrame frame = new JFrame();
	ImageIcon snareIcon = new ImageIcon(getClass().getResource("/assets/snare1.png"));
	JButton snareButton = new JButton(snareIcon);
	
	//crash cymbal 1
	ImageIcon cymbaloneIcon = new ImageIcon(getClass().getResource("/assets/cymbal1.png"));
	JButton cymbaloneButton = new JButton(cymbaloneIcon);
	
	//crash cymbal 2
	ImageIcon cymbaltwoIcon = new ImageIcon(getClass().getResource("/assets/cymbal2.png"));
	JButton cymbaltwoButton = new JButton(cymbaltwoIcon);
	
	//hihat cymbal
	ImageIcon hihatIcon = new ImageIcon(getClass().getResource("/assets/hithat.png"));
	JButton hihatButton = new JButton(hihatIcon);

	//ride cymbal
	ImageIcon rideIcon = new ImageIcon(getClass().getResource("/assets/ridecymbal.png"));
	JButton rideButton = new JButton(rideIcon);
	
	//floor tom
	ImageIcon floortomIcon = new ImageIcon(getClass().getResource("/assets/floortom.png"));
	JButton floortomButton = new JButton(floortomIcon);
	
	//bass drum
	ImageIcon bassIcon = new ImageIcon(getClass().getResource("/assets/bassdrum.png"));
	JButton bassButton = new JButton(bassIcon);
	
	//LaunchPage constructor
	LaunchPage(){

		//link keyboard keys to the jbuttons of the drums
		drumkeyMap.put(KeyEvent.VK_A, bassButton);
		drumkeyMap.put(KeyEvent.VK_S, snareButton);
		drumkeyMap.put(KeyEvent.VK_D, floortomButton);
		
		//link keyboard keys to the jbuttons of the cymbals
		cymbalkeyMap.put(KeyEvent.VK_L, hihatButton);
		cymbalkeyMap.put(KeyEvent.VK_I, cymbaloneButton);
		cymbalkeyMap.put(KeyEvent.VK_P, cymbaltwoButton);
		cymbalkeyMap.put(KeyEvent.VK_O, rideButton);
			
		//algorithm 3
		//add a KeyListener to the frame to detect keyboard input
		frame.addKeyListener(new KeyAdapter() {
			
			//override the keyPressed method to define what happens when a key is pressed
		    public void keyPressed(KeyEvent e) {
		    	
		    	//look up the button mapped to this key in the drum key map
		        JButton button = drumkeyMap.get(e.getKeyCode());
		        
		        //look up the button mapped to this key in the cymbal key map
		        JButton button2 = cymbalkeyMap.get(e.getKeyCode());

		        //if a drum button exists for this key, simulate a button click
		        if (button != null) {
		        	
		        	//click the button from the key code
		            button.doClick();
		        }
		        
		        //if a cymbal button exists for this key, simulate a button click
		        if (button2 != null) {
		        	
		        	//click the button from the key code
		            button2.doClick();
		        }
		    }
		});
		
		//link the drum buttons to the sounds
		drumMap.put(snareButton, snareSound);
		drumMap.put(floortomButton, floortomSound);
		drumMap.put(bassButton, kickdrumSound);
		
		//link the cymbal buttons to the sounds
		cymbalMap.put(cymbaloneButton, cymbal1Sound);
		cymbalMap.put(cymbaltwoButton, cymbal2Sound);
		cymbalMap.put(hihatButton, hihatSound);
		cymbalMap.put(rideButton, rideSound);

		/***************************************************************************************
		*    Title: "Java open a new GUI window"
		*    Author: Bro Code
		*    Date: June 5, 2020
		*    Availability: https://www.youtube.com/watch?v=HgkBvwgciB4
		***************************************************************************************/
		
		//first two coordinates set where on the screen is the button, last two set the size of the button
		snareButton.setBounds(630,300,200,200);
		
		//setFocusable(false) allows each button in the window to be clicked by individual key, 
		//setting to true allows only this button to be clicked by key, Copilot says otherwise
		snareButton.setFocusable(false);
		
		//makes button playable only in the window
		snareButton.requestFocusInWindow();
		
		//connects snareButton to 'this' object, which will handle its actions
		snareButton.addActionListener(this);
		
		//adds the frame SnareButton to the window
		frame.add(snareButton);
		
		//cymbalone (left)
		cymbaloneButton.setBounds(430,100,200,200);
		cymbaloneButton.setFocusable(false);
		cymbaloneButton.requestFocusInWindow();
		cymbaloneButton.addActionListener(this);
		
		frame.add(cymbaloneButton);
		
		//cymbaltwo (right)
		cymbaltwoButton.setBounds(830,100,200,200);
		cymbaltwoButton.setFocusable(false);
		cymbaltwoButton.requestFocusInWindow();
		cymbaltwoButton.addActionListener(this);
				
		frame.add(cymbaltwoButton);
		
		//hihat cymbal
		hihatButton.setBounds(430,300,200,200);
		hihatButton.setFocusable(false);
		hihatButton.requestFocusInWindow();
		hihatButton.addActionListener(this);
				
		frame.add(hihatButton);
		
		//ride cymbal
		rideButton.setBounds(630,100,200,200);
		rideButton.setFocusable(false);
		rideButton.requestFocusInWindow();
		rideButton.addActionListener(this);
						
		frame.add(rideButton);
		
		//floor tom
		floortomButton.setBounds(830,300,200,200);
		floortomButton.setFocusable(false);
		floortomButton.requestFocusInWindow();
		floortomButton.addActionListener(this);
								
		frame.add(floortomButton);
				
		//bass drum
		bassButton.setBounds(630,500,200,200);
		bassButton.setFocusable(false);
		bassButton.requestFocusInWindow();
		bassButton.addActionListener(this);
								
		frame.add(bassButton);
		
		/***************************************************************************************
		*    Title: "Java open a new GUI window"
		*    Author: Bro Code
		*    Date: June 5, 2020
		*    Availability: https://www.youtube.com/watch?v=HgkBvwgciB4
		***************************************************************************************/
		
		//closes window upon ending program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//sets the size of the window
		frame.setSize(1000,1000);
		
		//setting to null allows the ability to arrange the buttons and other components 
		frame.setLayout(null);
		
		//makes frame visible
		frame.setVisible(true);
	}
	
	//playing sounds method
	//actionevent is type of object passed, e represents that object
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//new Jbutton "source" 
		JButton source = (JButton) e.getSource();
		
		//DrumSounds and CymbalSounds = source of their indicated maps
		DrumSounds sound = drumMap.get(source);
		CymbalSounds sound1 = cymbalMap.get(source);
		
		//if the sound/source isn't null, then play that sound and type in console
	    if (sound != null) {
	    	
	    	//calls play clip method in DrumSounds class
	        sound.play(source);
	        System.out.println("You played the button"); 
	    }
	    
	    if (sound1 != null) {
	    	
	    	//calls play clip method in CymbalSounds class
	        sound1.play();
	        System.out.println("You played the button");
	    }
	}	
}
