package com.qulix.demoqa.test;

import com.qulix.demoqa.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lesson2Test {

    // TODO: Лекция 2 у нас про testNG и формально мы еще не знаем кто и что такое Selenium.
//   Потому для этого урока логичнее сделать пример, в котором нет Selenium
//   Можно, например, написать свой класс com.qulix.demoqa.Calculator
//       .plus(x,y)
//       .multiply(x,y)
//       .divide(x,y)
//       .minus(x,y)
// DONE: сделала класс калькулятора, начала реализацию теста для него (Lesson2Test)

//
// TODO:  И далее на примерах показать и dataDriven подход и группы
//  (например, negativeValues, decimalValues, negativeTests, positiveTests)
//  и через разные варианты testng.xml показать как можно управлять ходом выполнения через XML
//
// TODO: По-хорошему тут показать максимально работу разных аннотаций
// DONE: сделано для аннотаций @data-provider, @parameters

    static final Logger log = LoggerFactory.getLogger(Lesson2Test.class);
    Calculator calculator = new Calculator();

/*    @Parameters({"firstNumber", "secondNumber", "expResult"})
    @Test (description = "Testing sum calculations")
    public void testPositiveAddition(double firstNumber, double secondNumber, double expResult) {
        double actResult = calculator.plus(firstNumber, secondNumber);
        Assert.assertEquals(actResult, expResult);
        log.info("Actual result matches expected result");
    }*/

    @Test (description = "Testing sum calculations", dataProvider = "data-provider-positive-values", groups="positiveTests")
    public void testPositiveAdditionDP(double firstNumber, double secondNumber, double expResult) {
        double actResult = calculator.plus(firstNumber, secondNumber);
        Assert.assertEquals(actResult, expResult);
        log.info("Actual result matches expected result");
    }

    @Test (description = "Testing sum calculations", dataProvider = "data-provider-negative-values", groups="positiveTests")
    public void testNegativeValuesAdditionDP(double firstNumber, double secondNumber, double expResult) {
        double actResult = calculator.plus(firstNumber, secondNumber);
        Assert.assertEquals(actResult, expResult);
        log.info("Actual result matches expected result");
    }

    @Test (description = "Testing sum calculations", dataProvider = "data-provider-negative-test", groups="negativeTests")
    public void testNegativeTestAdditionDP(double firstNumber, double secondNumber, double expResult) {
        double actResult = calculator.plus(firstNumber, secondNumber);
        Assert.assertNotEquals(actResult, expResult);
        log.info("Actual result matches expected result");
    }

    @DataProvider(name = "data-provider-positive-values")
    public Object[][] dataProviderPositiveValuesMethod(){
        return new Object[][] {
                {2.0, 3.0, 5.0},
                {5.0, 7.0, 12.0},
                {13.0, 4.0, 17.0},
                {213.0, 132.0, 345.0}
        };
    }

    @DataProvider(name = "data-provider-negative-values")
    public Object[][] dataProviderNegativeValuesMethod(){
        return new Object[][] {
                {-2.0, -3.0, -5.0},
                {-5.0, 7.0, 2.0},
                {13.0, -4.0, 9.0},
                {-213.0, -132.0, -345.0}
        };
    }

    @DataProvider(name = "data-provider-negative-test")
    public Object[][] dataProviderNegativeTestMethod(){
        return new Object[][] {
                {-2.0, 3.0, -5.0},
                {5.0, -9.0, 2.0},
                {13.0, 4.0, -9.0},
                {-213.0, -132.0, 345.0}
        };
    }
}
