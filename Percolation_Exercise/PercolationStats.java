import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/******************************************************************************
 *  Compilation:  javac PercolationStats.java
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

public class PercolationStats {

    // private Percolation per; // private union class initialised

    private static final double PI = 1.96;

    private final int trials;
    private final double deviateI;
    private final double meanI;

    // private static int  nSites;


    /**
     * Constructor
     *
     * @param commandline arg0 , arg1
     */
    public PercolationStats(int n, int trials)    // perform trials independent experiments on an n-by-n grid

    {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("value " + " is not a positive integer. Bad input argument.");
        }
        this.trials = trials;
        // this.nSites = n;

        int rand1 = 0;
        int rand2 = 0;
        int openSites = 0;
        double temp = 0.0;
        double total = n * n;
        double[] meanVal = new double[trials];


        if (n == 1 && this.trials == 1) {
            Percolation per = new Percolation(1);
            // rand1 = StdRandom.uniform(1, n+1);
            // rand2 = StdRandom.uniform(1, n+1);

            per.open(n, n);
            openSites = per.numberOfOpenSites();
            temp = (double) openSites / total;
            meanVal[0] = temp;
        }
        else if (n == 1 && this.trials > 1) {

            for (int i = 0; i < this.trials; i++) {
                Percolation per = new Percolation(n);

                // rand1 =  StdRandom.uniform(1, n+1);
                // rand2 =  StdRandom.uniform(1, n+1);
                per.open(n, n);

                openSites = per.numberOfOpenSites();
                temp = (double) openSites / total;
                meanVal[i] = temp;
                }

        }
        else
            {
            for (int i = 0; i < this.trials; i++) {
                Percolation per = new Percolation(n);
                while (!per.percolates()) {
                    rand1 =  StdRandom.uniform(1, n+1);
                    rand2 =  StdRandom.uniform(1, n+1);
                    per.open(rand1, rand2);
                    if (per.percolates()) {
                        openSites = per.numberOfOpenSites();
                        temp = (double) openSites / total;
                        meanVal[i] = temp;
                        break;
                    }

                }
            }
        }

        this.deviateI = StdStats.stddev(meanVal);
        this.meanI = StdStats.mean(meanVal);
    }

    /**
     * Unit tests {@code Percolation}.
     * Convert command-line arguments to array of doubles and call various methods.
     *
     * @param args the command-line arguments
     */

    public static void main(String[] args)        // test client (described below)
    {
        if (args.length < 2) {

            throw new IllegalArgumentException("Please provide 2 valid input arguments");
        }

        int nI = Integer.parseInt(args[0]);
        int trialsI = Integer.parseInt(args[1]);
        if (nI <= 0 || trialsI <= 0) {
            throw new IllegalArgumentException("value " + " is not a positive integer. Bad input argument.");
        }


        PercolationStats uf = new PercolationStats(nI, trialsI);

        System.out.println(uf.mean() + "\n");
        System.out.println(uf.stddev() + "\n");
        System.out.println("["+ uf.confidenceHi() + ","+ uf.confidenceLo() + "]" + "\n");


    }

    /**
     * Returns mean of percolation values
     *
     * @param
     * @return boolean
     */
    public double mean()   // sample mean of percolation threshold
    {



         return  meanI;

    }

    /**
     * Returns stddev of values
     *
     * @param
     * @return double stddev
     */
    public double stddev()  // sample standard deviation of percolation threshold
    {
        if (trials == 1) {

            return Double.NaN;
        }
        else {

            return deviateI;
        }
    }

    /**
     * Returns confidence lower interval
     *
     * @param
     * @return double
     */
    public double confidenceLo()  // low  endpoint of 95% confidence interval
    {
        if (trials == 1) {
            return Double.NaN;
        } else {
            return meanI - ((PI * deviateI) / Math.sqrt(trials));
        }


    }

    /**
     * Returns double
     *
     * @param
     * @return confidence upper interval
     */
    public double confidenceHi()                  // high endpoint of 95% confidence interval
    {

        if (trials == 1) {
            return Double.NaN;
        }
        else {
            return meanI + ((PI * deviateI) / Math.sqrt(trials));
        }

    }


}
