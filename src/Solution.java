import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN.
        Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        double[] n = new double[x];

        for (int i = 0; i < x; i++) {
            n[i] = sc.nextDouble();
        }

        Arrays.sort(n);
        System.out.println(getMean(n, x));
        System.out.println(getMedian(n, x));
        System.out.println(getMode(n, x));
    }

    public static double getMean(double[] n, int x) {

        double mean = 0;

        for (int i = 0; i < x; i++) {
            mean += n[i];
        }
        return mean / x;
    }

    public static double getMedian(double[] n, int x) {

        // if odd
        if (n.length % 2 == 1) {
            return n[n.length / 2];
        } else {
            return (n[n.length / 2] + n[(n.length / 2) - 1]) / 2;
        }
    }

    // get mode: the highest number of occurrences of each element in the array
    // then print the smallest number if mode is 1;
    public static int getMode(double[] n, int x) {

        int frequency = 0; //count the occurrences of ele
        int mode = 1;
        int modeValue = (int) n[0]; // a value of an element

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (n[i] == n[j]) { //if same ele is found, make ele mode.
                    frequency++; // = 2
                }
            }

            if (frequency > mode) {
                modeValue = (int) n[i];
                mode = frequency;
                frequency = 0; // resets frequency
            } else {
                frequency = 0;
            }
        }
        return modeValue;
    }
}

/*
10
64630 11735 14216 99233 14470 4978 73429 38120 51135 67060
*/