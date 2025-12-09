//Jason Loa 12/9/25
//Create a drum program, plays drum sounds when clicked. 

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class CymbalSounds {

	//create private clip "clip", only accessible within CymbalSounds class
    private Clip clip;
    
    //constructor for CymbalSounds
    //this is called when you create a new CymbalSounds object
	public CymbalSounds(String filePath) {
		
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

    //play clip method
	public void play() {
		
		//if the clip has a value, then,
        if (clip != null) {
        	
        	//reset the frame to beginning
            clip.setFramePosition(0);
            
            //start the clip
            clip.start();
        }
    }
}