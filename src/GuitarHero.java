/******************************************************************************
 * TODO: 
 * 		 GUI : Visualize notes played; [show strings/frets]
 * 		 Record music into a file - (is there a way to use Scanner to record keystrokes?  ~Daniel)
 *       Read a file to play notes
 *       Self-play/compose musical pieces
 *
 ******************************************************************************/
import java.util.HashMap;

public class GuitarHero {

    public static void main(String[] args) {

        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] piano = new GuitarString[38];

        for(int i = 0; i < piano.length; i++) {

            piano[i] = new GuitarString( 440 * Math.pow( 1.05956, (i - 24) ));
        }

        double sample = 0;

        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();
                if(keyboard.indexOf(key) != -1) {

                    piano[keyboard.indexOf(key)].pluck();
                }
            }

            // compute the superposition of the samples
            for(int i = 0; i < piano.length; i++){

                sample += piano[i].sample();
            }

            // send the result to standard audio
            StdAudio.play( sample );

            // advance the simulation of each guitar string by one step
            for(int i = 0; i < piano.length; i++){
                piano[i].tic();
            }
            sample = 0;

        } //end while
    }//end main
}//end class
