/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;



// java -cp .:./.lift/algs4.jar RandomWord

public class RandomWord {
    public static void main(String[] args) {

        while (!StdIn.isEmpty()){
            var abc = StdIn.readString();
            StdOut.println("Echo: "+abc);
        }
    }
}
