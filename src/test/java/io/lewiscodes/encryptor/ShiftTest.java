package io.lewiscodes.encryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShiftTest {
    @Test
    public void standardCharEncryptionTest() {
      int key = 5;
      String testData = "abcd";
      Cipher shift = new ShiftCipher(testData);
      String result = String.valueOf(shift.encrypt(key));
      String expected = "fghi";
      assertEquals(expected, result, 
        "Test failed for Shift encryption of standard chars"
      );
    }
    
    @Test
    public void endOfCircleTest() {
      int key = 5;
      String testData = "uvwxy";
      Cipher shift = new ShiftCipher(testData);
      String result = String.valueOf(shift.encrypt(key));
      String expected = "zabcd";
      assertEquals(expected, result, 
        "Test failed for Shift encryption of chars at end of circle"
      );
    }
    
    @Test
    public void ignoresNonLetterCharsTest() {
      int key = 5;
      String testData = "uv w$ xy!";
      Cipher shift = new ShiftCipher(testData);
      String result = String.valueOf(shift.encrypt(key));
      String expected = "za b$ cd!";
      assertEquals(expected, result, 
        "Test failed for Shift encryption ignoring non letter chars: " + result
      );
    }
}