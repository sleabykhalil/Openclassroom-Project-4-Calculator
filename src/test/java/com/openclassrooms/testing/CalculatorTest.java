package com.openclassrooms.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void testAddTowPositiveNumber() {
        //Arrange
        int a = 1;
        int b = 2;
        Calculator calculator = new Calculator();
        // Act
        int somme = calculator.add(a, b);
        // Assert
        assertEquals(somme, 3);
    }

    @Test
    void testMultiplyTowPositiveNumber() {
        //Arrange
        int a = 2;
        int b = 5;
        Calculator calculator = new Calculator();

        //Act
        Double result = calculator.multiply(a, b);

        //Assert
        assertEquals(result, 10);
    }
}
