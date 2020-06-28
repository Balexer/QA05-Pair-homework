package tests;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class IvanFactory {

    @Factory
    @Test
    public Object[] factoryMethod() {
        Object[] test = new Object[2];
        test[0] = new IvanRegressionTests();
        test[1] = new IvanSmokeTests();
        return test;
    }
}
