package com.qulix.demoqa.test;

import com.qulix.demoqa.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lesson2Test {

    static final Logger log = LoggerFactory.getLogger(Lesson2Test.class);
    Calculator calculator = new Calculator();

    /*@Parameters({"firstNumber", "secondNumber", "expResult"})
    @Test (description = "Testing sum calculations")*/
    @Test (description = "Testing sum calculations", dataProvider = "data-provider")
    public void testCalculation(int firstNumber, int secondNumber, int expResult) {
        int actResult = calculator.plus(firstNumber, secondNumber);
        Assert.assertEquals(actResult, expResult);
        log.info("Actual result matches expected result");
    }

    Object[][] data={
            {2, 3, 5},
            {5, 7, 9},
            {13, 4, 17},
            {213, 132, 345}
    };

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod(){
        return data;
    }
}
