import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double[] results;


    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if ((n <= 0) || (trials <= 0)) throw new IllegalArgumentException();

        results = new double[trials];

        for (int j = 0; j < trials; j++) {
//            StdOut.println("Start trial #" + (j + 1));

            int[] slotOpenOrder = new int[n * n];
            for (int i = 0; i < n * n; i++) {
                slotOpenOrder[i] = i;
            }
            StdRandom.shuffle(slotOpenOrder);

            Percolation computation = new Percolation(n);

            int currentIndex = -1;
            while (!computation.percolates()) {
                currentIndex++;
                int[] coordinates = getDimensionsByIndex(slotOpenOrder[currentIndex], n);
                int row = coordinates[0];
                int col = coordinates[1];

                computation.open(row, col);
            }
            results[j] = computation.numberOfOpenSites() * 1.0 / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return StdStats.min(results);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return StdStats.max(results);
    }

    private static int[] getDimensionsByIndex(int index, int dimension) {
        int row = (index / dimension) + 1;
        int col = (index % dimension) + 1;
        return new int[]{row, col};
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(n, t);

        StdOut.println("mean = " + percolationStats.mean());
        StdOut.println("stddev = " + percolationStats.stddev());
        StdOut.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", " + percolationStats.confidenceHi() + "]");

    }
}
