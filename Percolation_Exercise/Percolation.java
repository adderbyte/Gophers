import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/******************************************************************************
 *  Compilation:  javac Percolation.java
 *  Execution:    java StdStats < input.txt
 *  Dependencies: StdOut.java
 *
 *  Homework Solution for Percolation.
 *
 *
 *  The functions all throw a java.lang.IllegalArgumentException
 *  if the array passed in as an argument is null.
 *
 *
 ******************************************************************************/

/**
 * The {@code StdStats} class provides static methods for computing
 * Homework Exercise
 * <p>
 * For additional documentation, see
 * <a href="https://introcs.cs.princeton.edu/22library">Section 2.2</a> of
 * <i>Computer Science: An Interdisciplinary Approach</i>
 * by Robert Sedgewick and Kevin Wayne.
 *
 * @author Olagoke Loqman
 */

public class Percolation {
    private final int count;      // number of components
    private int[][] grid;   // parent[i] = parent of i
    private final  WeightedQuickUnionUF un; // private union class initialised
    private final int virtualPoint1;      // virtual point
    private final int virtualPoint2;      // virtual point
    private int open = 0;




    /**
     * Initialises the parameters for percolation
     *
     * @param n size of the grid. Uses 2 virtual points
     */
    public Percolation(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("value " + n + " is not a positive integer greater than zero. Bad input argument.");
        }
        int virtualConnector = 2;
        this.count = n-1;
        grid = new int[n][n];
        un = new WeightedQuickUnionUF(((n * n) + virtualConnector));
        virtualPoint1 = (n * n);
        virtualPoint2 = (n * n) + 1;
    }


    /**
     * Returns boolean to indicate if a site is open or not
     *
     * @param row, col indices
     * @return boolean opened;
     */

    public boolean isOpen(int row, int col) {
        boolean opened;
        col = col -1;
        row = row -1;
         if ((row > count || (col > count) || (row < 0) || (col < 0))) {
            throw new IllegalArgumentException("index  is not between 0 and " + (count) + ". Index out of range");
        }
        if (grid[row][col] == 1) {
            opened = true;
        } else {
            opened = false;
        }
        return opened;
    }

    /**
     * set a site opem
     *
     * @param row, col indices
     *             check if site open
     */
    private void setOpen(int row, int col) {
        if ((row > count || (col > count) || (row < 0) || (col < 0))) {
            throw new IllegalArgumentException("index  is not between 0 and " + (count) + ". Index out of range");
        }
        if (grid[row][col] != 1) {
            grid[row][col] = 1;
            open++;
        }
    }

    /**
     * Returns int that corresponds to grid lables
     *
     * @param col,row indices
     * @return int labels
     */
    private int labelGrid(int row, int col) {

        int nodelabel = 0;
        if (row == 0) {
            nodelabel = col;
        } else if (row > 0) {
            nodelabel = (grid[row].length * (row)) + col;
        }
        return nodelabel;
    }

    /**
     * opens a particular site
     *
     * @param row, col indices
     */
    public void open(int row, int col) {
        int label = 0;
        int local = 0;
        col = col-1;
        row = row-1;
        setOpen(row, col); // set the location to one. open it
        label = labelGrid(row, col); // get the label of the location
        if (row == 0) {
            un.union(label, virtualPoint1);
        }
        if (row == count) {
            un.union(label, virtualPoint2);
        }
        if ((col - 1) <= count && (col - 1) >= 0 && isOpen(row+1, (col))) {
            local = labelGrid(row, (col - 1));
            un.union(label, local);
        }
        if ((col + 1) <= count && isOpen(row+1, col+2)) {
            local = labelGrid(row, (col + 1));
            un.union(label, local);
        }
        if ((row - 1) <= count && (row - 1) >= 0 && isOpen(row, col+1)) {
            local = labelGrid((row - 1), col);
            un.union(label, local);
        }
        if ((row + 1) <= count && isOpen(row+2, col+1)) {
            local = labelGrid((row + 1), col);
            un.union(label, local);
        }
    }

    /**
     * Returns boolean for full site
     *
     * @param row, col indices
     * @return boolean to check fullness
     */
    public boolean isFull(int row, int col) {
        boolean fullcheck;
        if ((row-1 > count || (col-1 > count) || (row-1 < 0) || (col-1 < 0))) {
            throw new IllegalArgumentException("index  is not between 0 and " + (count) + ". Index out of range");
        }

        int checks;

        checks = labelGrid(row-1, col-1);
        // System.out.println(row + " "+ col  + "\n");
        fullcheck = un.connected(checks, virtualPoint1);


        return fullcheck;
    }


    /**
     * Returns int
     *
     * @param
     * @return number of open sites
     */
    public int numberOfOpenSites() {

        return open;

    }


    /**
     * Returns boolean to check if a system percolates
     *
     * @param
     * @return boolean
     */
    public boolean percolates() {
        return un.connected(virtualPoint1, virtualPoint2);
    }


    /**
     * Unit tests {@code Percolation}.
     * Convert command-line arguments to array of doubles and call various methods.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        /* if (args.length < 1) {

            throw new IllegalArgumentException("Please provide 2 valid input arguments");
        }
*/

     /*  int nI = Integer.parseInt(args[0]);
        Percolation uf = new Percolation(nI);

        uf.open(1, 5);
        uf.open(2, 5);
        uf.open(3, 5);
        uf.open(4, 5);
        uf.open(5, 5);
        uf.open(4, 3);
        boolean s = uf.isFull(4, 3);
        boolean l = uf.percolates();
        int k = uf.numberOfOpenSites();
        System.out.println(k + " number\n");
        System.out.println(l + " percolates \n");
        System.out.println(s + " isFull \t");*/
    }


}

