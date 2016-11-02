package businessObject;

import base.TestBase;
import dataProvider.DataProviderClass;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/**
 * Created by Tetiana_Romaniv on 11/1/2016.
 */
@Listeners (TestListener.class)
public class CalculatorTest extends TestBase {

    @Test (dataProvider = "testDataLong", dataProviderClass = DataProviderClass.class, groups = {"smoke", "regression","longType"})
    public void testSumLong(long a, long b, long expected) throws InterruptedException {
        Assert.assertEquals(calculator.sum(a, b), expected);
        Thread.sleep(2000);
    }

    @Test (dataProvider = "testDataDouble", dataProviderClass = DataProviderClass.class, groups = {"smoke","regression","doubleType"})
    public void testSumDouble(double a, double b, double expected, double delta) throws InterruptedException {
        Assert.assertEquals(calculator.sum(a, b), expected,delta);
        Thread.sleep(2000);
    }

    @Test (dataProvider = "testDataLong", dataProviderClass = DataProviderClass.class, groups = {"smoke", "regression","longType"})
    public void testSubLong(long a, long b, long expected) {
        Assert.assertEquals(calculator.sub(a, b), expected);

    }

    @Test (dataProvider = "testDataDouble", dataProviderClass = DataProviderClass.class, groups = {"smoke","regression","doubleType"} )
    public void testSubDouble(double a, double b, double expected, double delta) throws Exception {
        Assert.assertEquals(calculator.sub(a, b), expected, delta);
    }

    @Test (dataProvider = "testDataLong", dataProviderClass = DataProviderClass.class, groups = {"smoke", "regression","longType"})
    public void testMultLong(long a, long b, long expected) throws Exception {
        Assert.assertEquals(calculator.mult(a, b), expected);
    }

    @Test (dataProvider = "testDataDouble", dataProviderClass = DataProviderClass.class, groups = {"smoke","regression","doubleType"})
    public void testMultDouble(double a, double b, double expected, double delta) throws Exception {
        Assert.assertEquals(calculator.mult(a, b), expected, delta);
    }

    @Test (dataProvider = "testDataLong", dataProviderClass = DataProviderClass.class, groups = {"smoke", "regression","longType"})
    public void testDivLong(long a, long b, long expected){
        Assert.assertEquals(calculator.div(a, b), expected);
    }

    @Test (dataProvider = "testDataDouble", dataProviderClass = DataProviderClass.class, groups = {"regression","doubleType"})
    public void testDivDouble(double a, double b, double expected, double delta) {
        Assert.assertEquals(calculator.div(a, b), expected, delta);
    }

    @Test (dataProvider = "testDataDouble", dataProviderClass = DataProviderClass.class, groups = {"smoke","regression","doubleType"})
    public void testPow(double a, double b, double expected){
        Assert.assertEquals(calculator.pow(a, b), expected);
    }

    @Test (dataProvider = "testDataDouble", dataProviderClass = DataProviderClass.class, groups = {"smoke","regression","doubleType"})
    public void testSqrt(double a, double expected){
        Assert.assertEquals(calculator.sqrt(a), expected);
    }

    @Test (dataProvider = "testDataDouble", dataProviderClass = DataProviderClass.class, groups = {"regression","doubleType"})
    public void testTg(double a, double expected) {
        Assert.assertEquals(calculator.tg(a), expected);
    }

    @Test (dataProvider = "testDataDouble", dataProviderClass = DataProviderClass.class, groups = {"smoke", "regression","doubleType"})
    public void testCtg(double a, double expected){
        Assert.assertEquals(calculator.ctg(a), expected);
    }

    @Test (dataProvider = "testDataDouble", dataProviderClass = DataProviderClass.class, groups = {"smoke", "regression","doubleType"})
    public void testCos(double a, double expected) {
        Assert.assertEquals(calculator.cos(a), expected);
    }

    @Test (dataProvider = "testDataDouble", dataProviderClass = DataProviderClass.class, groups = {"smoke", "regression","doubleType"})
    public void testSin(double a, double expected) {
        Assert.assertEquals(calculator.sin(a), expected);
    }

    @Test (dataProvider = "testDataLong", dataProviderClass = DataProviderClass.class, groups = {"smoke", "regression","longType"})
    public void testIsPositive(long a) {
        Assert.assertTrue(calculator.isPositive(a));
    }

    @Test (dataProvider = "testDataLong", dataProviderClass = DataProviderClass.class, groups = {"smoke", "regression","longType"})
    public void testIsNegative(long a) {
        Assert.assertTrue(calculator.isNegative(a));
    }

    @Test (dataProvider = "testDataLong", groups = {"regression","longType"},dataProviderClass = DataProviderClass.class, expectedExceptions = ArithmeticException.class)
    public void testDivOnZeroLong(long a, long b) {
        calculator.div(a,b);
    }

    @Test (dataProvider = "testDataDouble", groups = {"regression","doubleType"},  dataProviderClass = DataProviderClass.class, expectedExceptions = ArithmeticException.class)
    public void testDivOnZeroDouble(double a, double b) {
        calculator.div(a,b);
    }

    @Test (dataProvider = "testDataDouble", groups = {"regression","doubleType"}, dataProviderClass = DataProviderClass.class, expectedExceptions = IllegalArgumentException.class)
    public void testPowNumZeroAndPowLessZero(double a, double b) {
        calculator.pow(a,b);
    }

    @Test (dataProvider = "testDataDouble", groups = {"regression","doubleType"}, dataProviderClass = DataProviderClass.class, expectedExceptions = IllegalArgumentException.class)
    public void testSqrtWhenNumLessZero(double a) {
        calculator.sqrt(a);
    }

    @Test (dataProvider = "testDataDouble", groups = {"regression","doubleType"}, dataProviderClass = DataProviderClass.class, expectedExceptions = IllegalArgumentException.class)
    public void testCtgFromZero(double a) {
        calculator.ctg(a);
    }

    @Test (dataProvider = "testDataLong", groups = {"regression","longType"}, dataProviderClass = DataProviderClass.class, expectedExceptions = StackOverflowError.class)
    public void testSumOverflowLong(long a, long b) {
        calculator.sum(a,b);
    }

    @Test (dataProvider = "testDataDouble", groups = {"regression","doubleType"}, dataProviderClass = DataProviderClass.class, expectedExceptions = StackOverflowError.class)
    public void testSumOverflowDouble(double a, double b) {
       calculator.sum(a,b);
    }

    @Test (dataProvider = "testDataLong", groups = {"regression","longType"}, dataProviderClass = DataProviderClass.class, expectedExceptions = StackOverflowError.class)
    public void testDivOverflowLong(long a, long b) {
        calculator.div(a,b);
    }

    @Test (dataProvider = "testDataDouble", groups = {"regression","doubleType"}, dataProviderClass = DataProviderClass.class, expectedExceptions = StackOverflowError.class)
    public void testDivOverflowDouble(double a, double b) {
        calculator.div(a,b);
    }

    @Test (dataProvider = "testDataLong", groups = {"regression","longType"}, dataProviderClass = DataProviderClass.class, expectedExceptions = StackOverflowError.class)
    public void testMultOverflowLong(long a, long b) {
        calculator.mult(a,b);
    }

    @Test (dataProvider = "testDataDouble", groups = {"regression","doubleType"}, dataProviderClass = DataProviderClass.class, expectedExceptions = StackOverflowError.class)
    public void testMultOverflowDouble(double a, double b) {
        calculator.mult(a,b);
    }

    @Test (dataProvider = "testDataLong", groups = {"regression","longType"}, dataProviderClass = DataProviderClass.class)
    public void testIsPosWithNegativeNumber(long a) {
        Assert.assertFalse(calculator.isPositive(a));
    }

    @Test (dataProvider = "testDataDouble", groups = {"regression","longType"}, dataProviderClass = DataProviderClass.class)
    public void testIsNegWithPositiveNumber(long a) {
        Assert.assertFalse(calculator.isNegative(a));
    }


}