import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int[] grid;
    private final int dimension;
    private final int topSetIndex; // virtual top
    private final int bottomSetIndex; // virtual bottom
    private int openCount = 0;
    private final WeightedQuickUnionUF union;

    private int getIdByIndexes(int row, int col) {
        return (row - 1) * dimension + col - 1;
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException();

        topSetIndex = n * n;
        bottomSetIndex = n * n + 1;

        dimension = n;

        grid = new int[n * n];

        for (int i = 0; i < n * n; i++) {
            grid[i] = 0;
        }

        union = new WeightedQuickUnionUF(n * n + 2);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if ((row <= 0) || (row > dimension)) throw new IllegalArgumentException();
        if ((col <= 0) || (col > dimension)) throw new IllegalArgumentException();

        openCount++;

        grid[getIdByIndexes(row, col)] = 1;

        // update union
//        union.union(getIdByIndexes(row, col), getIdByIndexes(row, col));

        if (row == 1) union.union(getIdByIndexes(row, col), topSetIndex);
        if (row == dimension) union.union(bottomSetIndex, getIdByIndexes(row, col));

        if ((row - 1 > 0) && isOpen(row - 1, col)) union.union(getIdByIndexes(row, col), getIdByIndexes(row - 1, col));

        if ((row + 1 <= dimension) && isOpen(row + 1, col))
            union.union(getIdByIndexes(row, col), getIdByIndexes(row + 1, col));

        if ((col - 1 > 0) && isOpen(row, col - 1)) union.union(getIdByIndexes(row, col), getIdByIndexes(row, col - 1));

        if ((col + 1 <= dimension) && isOpen(row, col + 1))
            union.union(getIdByIndexes(row, col), getIdByIndexes(row, col + 1));


    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if ((row <= 0) || (row > dimension)) throw new IllegalArgumentException();
        if ((col <= 0) || (col > dimension)) throw new IllegalArgumentException();

        return grid[getIdByIndexes(row, col)] == 1;

    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if ((row <= 0) || (row > dimension)) throw new IllegalArgumentException();
        if ((col <= 0) || (col > dimension)) throw new IllegalArgumentException();

        return union.find(getIdByIndexes(row, col)) == union.find(topSetIndex);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return union.find(bottomSetIndex) == union.find(topSetIndex);
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}