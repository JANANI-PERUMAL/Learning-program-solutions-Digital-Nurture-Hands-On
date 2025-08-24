package com.example.Assertions_Digital;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssertionExamplesTest {

  private Sample mathOperations = new Sample();

  // assertEquals
  @Test
  void testAssertEquals() {
      int expected = 5;
      int actual = mathOperations.add(2, 3);
      assertEquals(expected, actual);
  }

  // assertNotEquals
  @Test
  void testAssertNotEquals() {
      int expected = 5;
      int actual = mathOperations.add(2, 2);
      assertNotEquals(expected, actual);
  }

  // assertTrue
  @Test
  void testAssertTrue() {
      int number = 10;
      assertTrue(mathOperations.isPositive(number));
  }

  // assertFalse
  @Test
  void testAssertFalse() {
      int number = -5;
      assertFalse(mathOperations.isPositive(number));
  }

  // assertNull
  @Test
  void testAssertNull() {
      String str = null;
      assertNull(str);
  }

  // assertNotNull
  @Test
  void testAssertNotNull() {
      String str = mathOperations.getHello();
      assertNotNull(str);
  }

  // assertArrayEquals
  @Test
  void testAssertArrayEquals() {
      int[] expectedArray = {1, 2, 3};
      int[] actualArray = mathOperations.getArray();
      assertArrayEquals(expectedArray, actualArray);
  }

  // assertSame
  @Test
  void testAssertSame() {
      String text = mathOperations.getHello();
      String reference = text;
      assertSame(text, reference);
  }

  // assertNotSame
  @Test
  void testAssertNotSame() {
      String text1 = mathOperations.getHello();
      String text2 = mathOperations.getHelloString();
      assertNotSame(text1, text2);
  }

  // assertThrows
  @Test
  void testAssertThrows() {
      assertThrows(ArithmeticException.class, mathOperations::throwArithmeticException);
  }

}