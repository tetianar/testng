package dataProvider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

/**
 * Created by Tetiana_Romaniv on 11/1/2016.
 */
public class DataProviderClass {
    @DataProvider(name = "testDataLong")
    public static Object[][] getDataLong(Method method) {
        String nameSheet = method.getName().toString();
        ReaderXls readerXLS = new ReaderXls();

        return readerXLS.parse(nameSheet, true);
    }

    @DataProvider(name = "testDataDouble")
    public static Object[][] getDataDouble(Method method) {
        String nameSheet = method.getName().toString();
        ReaderXls readerXLS = new ReaderXls();

        return readerXLS.parse(nameSheet, false);
    }
}
