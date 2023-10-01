package lab0;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Variant11 {

    public enum CARDINAL_DIRECTIONS{
        NORTH, EAST, SOUTH, WEST
    }


    /**
     *
     * @param k is a three-digit number
     * @return sum and prod of digits in k
     */

    public int[] integerNumbersTask(int k) {
        assert k > 99 && k < 1000: "parameter should be three-digit number";

        int[] sumAndProd = new int[2];
        int digit1 = k/100;
        int digit2 = (k/10)%10;
        int digit3 = k%10;
        sumAndProd[0] = digit1 + digit2 + digit3;
        sumAndProd[1] = digit1 * digit2 * digit3;

        return sumAndProd;
    }

    /**
     *
     * @param num1, num2
     * @return true, if numbers have same parity
     */
    public boolean booleanTask(int num1, int num2) {
        return num1 % 2 == num2 % 2;
    }


    /**
     *
     * @param paramA, paramB are integer numbers
     * @return transformed numbers
     */
    public int[] ifTask(int paramA, int paramB) {
        int paramC;
        if (paramA == paramB) {
            paramA = 0;
            paramB = 0;
        } else {
            paramC = paramA;
            paramA = Math.max(paramA, paramB);
            paramB = Math.max(paramC, paramB);
        }
        int[] parameters = new int[2];
        parameters[0] = paramA;
        parameters[1] = paramB;

        return parameters;
    }


    /**
     *
     * @param com1, com2 - commands for compass
     * @return compass direction after two commands
     */
    public CARDINAL_DIRECTIONS switchTask(int com1, int com2) {
        int sum = com1 + com2;
        assert com1 == -1 || com1 == 1 || com1 == 2: "directions should be -1, 1 or 2";
        assert com2 == -1 || com2 == 1 || com2 == 2: "directions should be -1, 1 or 2";
        return switch (sum) {
            case 1 -> CARDINAL_DIRECTIONS.EAST;
            case 2, -2 -> CARDINAL_DIRECTIONS.SOUTH;
            case 3, -1 -> CARDINAL_DIRECTIONS.WEST;
            default -> CARDINAL_DIRECTIONS.NORTH;
        };
    }


    /**
     *
     * @param n is integer number
     * @return result of N^2 + (N + 1)^2 + (N + 2)^2 + … + (2·N)^2
     */
    public double forTask(int n) {
        assert n > 0: "Argument should be more than zero";
        int sum = 0;
        int doubleN = 2*n;
        for (int i = n; i < doubleN; i++) {
            sum += n*n;
            n += 1;
        }
        return sum;
    }


    /**
     *
     * @param numN is integer number
     * @return minNumK, sum - the smallest of the integers K for which the sum 1 + 2 + ... + K will be greater than or equal to N, and this sum itself
     */
    public int[] whileTask(int numN) {
        assert (numN > 1): "Argument should be more than one";
        int minNumK = 0;
        int sum = 0;
        while (sum <= numN) {
            minNumK += 1;
            sum += minNumK;
        }
        int[] kAndSum = new int[2];
        kAndSum[0] = minNumK;
        kAndSum[1] = sum;

        return kAndSum;
    }

    /**
     *
     * @param arrayA is an array
     * @param paramK is an integer
     * @return array elements with ordinal numbers divisible by paramK
     */
    public double[] arrayTask(double[] arrayA, int paramK) {
        double[] newArray = new double[arrayA.length / paramK];
        int j = 0;
        for (int i = paramK; i < arrayA.length; i += paramK) {
            newArray[j] = arrayA[i];
            j++;
        }

        return newArray;
    }

    /**
     *
     * @param array is an array
     * @return transformed array where row every even row is written backwards
     */
    public int[][] matrixTask(int[][] array) {
        int rows = array.length;
        int columns = array[0].length;
        int k = 0;
        int[][] newArray = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            int order = (i%2 == 0) ? 1 : -1;
            int begin = (i%2 == 0) ? 0 : columns - 1;
            int finalStop = (i%2 == 0) ? columns : -1;
            for (int j = begin; j != finalStop; j += order) {
                newArray[i][k] = array[i][j];
                k++;
            }
            k = 0;
        }

        return newArray;
    }


    /**
     *
     * @param array is an array
     * @return number of a last min or max element in a list
     */
    public int minMaxTask(int[] array) {
        int min = MAX_VALUE;
        int max = MIN_VALUE;

        int maxpos = 0;
        int minpos = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                maxpos = i;
                max = array[i];
            }
            if (array[i] < min) {
                minpos = i;
                min = array[i];
            }
        }
        return Math.min(maxpos, minpos);
    }


    public static void main(String... strings) {
        System.out.println("Start of zero lab");
        System.out.println("Done!!!");
    }

}