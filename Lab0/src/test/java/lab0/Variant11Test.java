package lab0;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lab0.Variant11.CARDINAL_DIRECTIONS;

public class Variant11Test {
    ////////////////////////////////////////////////

    @Test(dataProvider = "integerProvider")
    public void integerTest(int p1, int[] p3) {
        assertEquals(new Variant11().integerNumbersTask(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 100, new int[] {1, 0} }, { 123, new int[] {6, 6} }, { 139, new int[] {13, 27} } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeIntegerTest() {
        new Variant11().integerNumbersTask(-2);
    }

    ////////////////////////////////////////////////

    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int[] p3) {
        assertEquals(new Variant11().ifTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][] { { 2, 2, new int[] {0, 0} }, { 0, 4, new int[] {4, 4} }, { -3, -11, new int[] {-3, -3} } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "booleanProvider")
    public void booleanTest(int p1, int p2, boolean p3) {
        assertEquals(new Variant11().booleanTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 5, 3, true }, { 0, 1, false }, { -3, 24, false } };
    }

    //////////////////////////////////////////////////

    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, int p2, CARDINAL_DIRECTIONS p3) {
        assertEquals(new Variant11().switchTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { -1, 1, CARDINAL_DIRECTIONS.NORTH }, { -1, 2, CARDINAL_DIRECTIONS.EAST } };
    }

    @Test(expectedExceptions = AssertionError.class)
    public void switchNegativeTest() {
        new Variant11().switchTask(-3, 3);
    }

    ///////////////////////////////////////////////////

    @Test(dataProvider = "forProvider")
    public void forTest(int n, int p2) {
        assertEquals(new Variant11().forTask(n), p2);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][] { { 3, 50 }, { 7, 728 }, { 12, 3818 } };
    }

    ///////////////////////////////////////////////////

    //////////////////////////////////////////

    @Test(dataProvider = "whileProvider")
    public void whileTest(int a, int[] p1) {
        assertEquals(new Variant11().whileTask(a), p1);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 10, new int[] {5, 15} }, { 12, new int[] {5, 15} }, { 22, new int[] {7, 28} }, { 125, new int[] {16, 136} } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(int a) {
        new Variant11().whileTask(a);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { 0 }, { -2 }, { -1 } };
    }

    //////////////////////////////////////////
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(double[] array, int k, double[] value) {
        assertEquals(new Variant11().arrayTask(array, k), value);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { new double[] { 10, 2, 3 }, 2, new double[] {3} }, { new double[] { 10, 2, 13, 151, -14, 0, -355, 245 }, 3, new double[] {151, -355} },
                { new double[] { 4, 3, 5, -4, 9, 2, 194, -14, 0, -135, -12, 145, 0 }, 2, new double[] {5, 9, 194, 0, -12, 0} } };
    }



    //////////////////////////////////////////

    @Test(dataProvider = "matrixProvider")
    public void matrixTest(int[][] input, int[][] output) {
        assertEquals(new Variant11().matrixTask(input), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] input = {{2, 3, 6, 9, -9},
                {34, 98, -9, 2, 1},
                {-4, 2, 1, 6, 1},
                {-98, 8, 1, 5, 3}};

        int[][] input2 = {{2, 3, 6, 9, -9},
                {1, 2, -9, 98, 34},
                {-4, 2, 1, 6, 1},
                {3, 5, 1, 8, -98}};

        int[][] input3 = {{45, 2, 0, -5, -15},
                {-4, 2, 1, 6, 1},
                {34, 98, -9, 2, 1},
                {2, 3, 6, 9, -9}};

        int[][] input4 = {{45, 2, 0, -5, -15},
                {1, 6, 1, 2, -4},
                {34, 98, -9, 2, 1},
                {-9, 9, 6, 3, 2}};

        return new Object[][] { {input, input2}, { input3, input4 } };

    }


    //////////////////////////////////////////

    @Test(dataProvider = "minMaxProvider")
    public void minMaxTest(int[] array, int number) {
        assertEquals(new Variant11().minMaxTask(array), number);
    }

    @DataProvider
    public Object[][] minMaxProvider() {
        return new Object[][] { {new int[] {-1, 0 ,134, -23}, 2}, { new int[] {124, 0, 34, 13490}, 1 }, {new int[] {0, 133, -1435, 143, -12, 1000}, 2} };
    }

}
