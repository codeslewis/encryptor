package io.lewiscodes.encryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShiftTest {
  // Encryption Tests
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
    public void endOfCircleEncryptionTest() {
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
    public void ignoresNonLetterCharsEncryptionTest() {
      int key = 5;
      String testData = "uv w$ xy!";
      Cipher shift = new ShiftCipher(testData);
      String result = String.valueOf(shift.encrypt(key));
      String expected = "za b$ cd!";
      assertEquals(expected, result, 
        "Test failed for Shift encryption ignoring non letter chars: " + result
      );
    }
    
    // Decryption Tests
    @Test
    public void standardCharDecryptionTest() {
      int key = 5;
      String testData = "fghi";
      Cipher shift = new ShiftCipher(testData);
      String result = String.valueOf(shift.decrypt(key));
      String expected = "abcd";
      assertEquals(expected, result, 
        "Test failed for Shift encryption of standard chars"
      );
    }
    
    @Test
    public void endOfCircleDecryptionTest() {
      int key = 5;
      String testData = "zabcd";
      Cipher shift = new ShiftCipher(testData);
      String result = String.valueOf(shift.decrypt(key));
      String expected = "uvwxy";
      assertEquals(expected, result, 
        "Test failed for Shift encryption of chars at end of circle"
      );
    }
    
    @Test
    public void ignoresNonLetterCharsDecryptionTest() {
      int key = 5;
      String testData = "za b$ cd!";
      Cipher shift = new ShiftCipher(testData);
      String result = String.valueOf(shift.decrypt(key));
      String expected = "uv w$ xy!";
      assertEquals(expected, result, 
        "Test failed for Shift encryption ignoring non letter chars: " + result
      );
    }
}
