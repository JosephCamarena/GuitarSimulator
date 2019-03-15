/******************************************************************************
 *  Name:    
 *  NetID:   
 *  Precept: 
 *
 *  Partner Name:    
 *  Partner NetID:   
 *  Partner Precept: 
 * 
 *  Description:  Plays two guitar strings (concert A and concert C)
 *                when the user types the lowercase letters 'a' and 'c',
 *                respectively in the standard drawing window.
 *
 *
 * TODO: Record music into a file
 *       Read a file to play notes
 *       Self-play/compose musical pieces
 *       GUI : show strings and frets by drawing on the screen
 *       2 apps: keyboards (1)w/ and (2)w/o numpads
 *
 ******************************************************************************/

public class GuitarHeroLite {

    public static void main(String[] args) {

        // Create two guitar strings, for concert A and C
        GuitarString string1 = new GuitarString(329.63);
        GuitarString string2 = new GuitarString(246.94);
        GuitarString string3 = new GuitarString(196);
        GuitarString string4 = new GuitarString(146.83);
        GuitarString string5 = new GuitarString(110);
        GuitarString string6 = new GuitarString(82.41);


        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                if (key == '1') { string1.pluck(); }
                if (key == '2') { string2.pluck(); }
                if (key == '3') { string3.pluck(); }
                if (key == '4') { string4.pluck(); }
                if (key == '5') { string5.pluck(); }
                if (key == '6') { string6.pluck(); }
            }

            // compute the superposition of the samples
            double sample = string1.sample() +
                    string2.sample() +
                    string3.sample() +
                    string4.sample() +
                    string5.sample() +
                    string6.sample();
        	//System.out.println(sample);
            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            string1.tic();
            string2.tic();
            string3.tic();
            string4.tic();
            string5.tic();
            string6.tic();
        }
    }

}
