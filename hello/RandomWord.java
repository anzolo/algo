/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


// java -cp .:./.lift/algs4.jar RandomWord
//win. java -cp "C:\Users\alzol\Documents\GitHub\algo\hello\.lift\algs4.jar;." RandomWord
//win 2. java -cp ".\.lift\algs4.jar;." RandomWord
// Get-Content .\animals8.txt | & java -cp ".\.lift\algs4.jar;." RandomWord

public class RandomWord {
    public static void main(String[] args) {

        var championWord = "";
        var index = 0;

        while (!StdIn.isEmpty()){
            var word = StdIn.readString();
            index++;
            // StdOut.println("Echo: "+abc);
            double probability = 1.0/index;
            // StdOut.println("Word:"+word+"; Probability:"+probability+"; index:"+index+"; championWord:"+championWord);
            if (StdRandom.bernoulli(probability)) championWord = word;
        }

        StdOut.println(championWord);
    }
}
