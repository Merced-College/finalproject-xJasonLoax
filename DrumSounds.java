//Jason Loa 12/9/25
//Create a drum program, plays drum sounds when clicked. 

import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class DrumSounds {
	
	//Stack for snare images
	Stack<ImageIcon> snareStack = new Stack<>();
	{
		//push still image first
		snareStack.push(new ImageIcon(getClass().getResource("/assets/snare1.png")));
		
		//push hit image second
		snareStack.push(new ImageIcon(getClass().getResource("/assets/snarehit.png")));
	}
	
	//stack for bass drum images
	Stack<ImageIcon> bassStack = new Stack<>();
	{
		
		//push still image first
		bassStack.push(new ImageIcon(getClass().getResource("/assets/bassdrum.png")));
		
		//push hit image second
		bassStack.push(new ImageIcon(getClass().getResource("/assets/bassdrumHit.png")));
	}
	
	//stack for floor tom images
	Stack<ImageIcon> floortomStack = new Stack<>();
	{
		
		//push still image first
		floortomStack.push(new ImageIcon(getClass().getResource("/assets/floortom.png")));	
		
		//push hit image second
		floortomStack.push(new ImageIcon(getClass().getResource("/assets/floortomHit.png")));	
	}
	
	//create private string filepath
	private String filepath;


	//create private clip "clip", only accessible within DrumSounds class
    private Clip clip;
    
    //constructor for DrumSounds
    //this is called when you create a new DrumSounds object
	public DrumSounds(String filePath) {
		
		//have this.filepath equal to the filepath assigned
		this.filepath = filePath;
		
		//call the loadSound method, passing in the file path
	    //this loads the audio file into the clip so it can be played
        loadSound(filePath);
    }

	//method to load an audio file into clip
	//algorithm 1
    private void loadSound(String filePath) {
        try {
        	
        	//create a File object from the given file path
            File file = new File(filePath);
            
            //obtain an AudioInputStream from the file (reads audio data)
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            
            //get a clip object (represents a sound that can be played)
            clip = AudioSystem.getClip();
            
            //open the clip with the audio from the inputstream
            clip.open(audioInputStream);
            
            // handle if file is not supported, can't be read, or can't be played on computer.
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        	
        	//prints the details
            e.printStackTrace();
        }
    }

    //play the clip method, Jbutton button allows the button used to have changing icon
    //algorithm 2, 
	public void play(JButton button) {
		
		//if clip loaded in correctly, then
		if (clip != null) {
			
			// set clip frame to 0 (beginning)
	        clip.setFramePosition(0);

	        //set stackToUse back to null
	        Stack<ImageIcon> stackToUse = null;
	       
	        //if the filepath of the button contains snare sound file, then
	        if (filepath.contains("snaresound1.wav")) {
	        	
	        	//use this stack
	            stackToUse = snareStack;
	            
	          //else if filepath of button contains kickdrum sound file, then
	        } else if (filepath.contains("kickdrum.wav")) {
	        	
	        	//use this stack
	            stackToUse = bassStack;
	            
	          //else if filepath of button contains floortom sound file, then
	        } else if (filepath.contains("floortom.wav")) {
	        	
	        	//use this stack
	            stackToUse = floortomStack;
	        }

	        //if the stack isn't empty, then
	        if (stackToUse != null) {
	        	
	        	//peek the stack 
	            button.setIcon(stackToUse.peek());
	        }

	        //play the clip
	        clip.start();

	        //create final stack to equal the last stack used
	        Stack<ImageIcon> finalStack = stackToUse;
	        
	        //add line listener to detect when the clip ends
	        clip.addLineListener(event -> {	        	
	        	
	        	//lineevent, event that triggers when the audio stops, reset the image to default
	            if (event.getType() == LineEvent.Type.STOP && finalStack != null) {
	            	
	            	//button set back to default (firstElement)
	                button.setIcon(finalStack.firstElement());
	            }
	        });
		}

    }

}
