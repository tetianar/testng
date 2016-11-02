package base;
import businessObject.Calculator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * Created by Tetiana_Romaniv on 11/1/2016.
 */
public class TestBase {
    public Calculator calculator;
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        calculator = new Calculator();
    }
}
