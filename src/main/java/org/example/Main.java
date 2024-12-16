package org.example;

import org.testng.Assert;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //Lesson1
        testSum(1, 2, 3);
    }

    //Lesson1
    public static void testSum(int firstNumber, int secondNumber, int expectedResult) {
        int actualResult = firstNumber + secondNumber;
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println("Result is correct");
    }
}