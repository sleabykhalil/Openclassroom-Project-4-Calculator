package com.openclassrooms.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private static Instant startedAt;
    private Calculator calculatorUnderTest;


    @BeforeAll
    static public void initStartTime() {
        System.out.println("Appel avant tous les tests");
        startedAt = Instant.now();
    }


    @AfterAll
    static public void showTestDuration() {
        System.out.println("Appel apres tous les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Duree des tests : {0} ms", duration));
    }


    @BeforeEach
    void initCalculator() {
        System.out.println("Appel avant chaque test");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    void endOfCalculator() {
        System.out.println("Appel apres chaque test");
        calculatorUnderTest = null;
    }

    @Test
    void testAddTowPositiveNumber() {
        //Arrange
        int a = 1;
        int b = 2;
        // Act
        int somme = calculatorUnderTest.add(a, b);
        // Assert
        assertEquals(somme, 3);
    }

    @Test
    void testMultiplyTowPositiveNumber() {
        //Arrange
        int a = 2;
        int b = 5;

        //Act
        Double result = calculatorUnderTest.produit(a, b);

        //Assert
        assertEquals(result, 10);
    }

    @CsvSource({"1,2,3", "10,20,30", "47,53,100"})
    @ParameterizedTest(name = "{0} + {1} dois egal {2} ")
    void testAddWithParametars(int arg1, int arg2, int expectedResult) {
        //Arrange

        //Act
        int result = calculatorUnderTest.add(arg1, arg2);

        //Assert
        assertEquals(result, expectedResult);
    }

    @Timeout(value = 2000, unit = TimeUnit.MILLISECONDS)
    @ValueSource(ints = {1, 2, 45, 1001, 22256})
    @ParameterizedTest(name = "0 * {0} doit etre egal a 0")
    void testMultiplyAvecZero_shouldReturnZero(int arg) {
        //Arrange

        //Act
        Double actualResult = calculatorUnderTest.produit(0, arg);

        //Assert
        assertEquals(0, actualResult);
    }
}
