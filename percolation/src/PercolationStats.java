import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {

    }

    // sample mean of percolation threshold
//    public double mean(){
//
//    }

    // sample standard deviation of percolation threshold
//    public double stddev(){
//
//    }

    // low endpoint of 95% confidence interval
//    public double confidenceLo(){
//
//    }

    // high endpoint of 95% confidence interval
//    public double confidenceHi(){
//
//    }

    private int[] getDimensionsByIndex(int index, int dimension) {
        int row = (index / dimension)+1;
        int col = (index % dimension)+1;
        return new int[]{row, col};
    }

    // test client (see below)
    public static void main(String[] args) {
        int dimension = 10;
        int[] slotOpenOrder = new int[dimension * dimension];
        for (int i = 0; i < dimension * dimension; i++) {
            slotOpenOrder[i] = i;
        }
        StdRandom.shuffle(slotOpenOrder);

        Percolation computation = new Percolation(dimension);

//        int
//        while (!computation.percolates()) {
//
//        }
    }
}
