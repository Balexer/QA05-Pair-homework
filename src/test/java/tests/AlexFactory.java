package tests;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class AlexFactory {

    @Factory
    @Test
    public Object[] factoryMethod() {
        Object[] test = new Object[2];
        test[0] = new AlexRegressionTests();
        test[1] = new AlexSmokeTests();
        return test;
    }
}
