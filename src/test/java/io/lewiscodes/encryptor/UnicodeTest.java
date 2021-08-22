package io.lewiscodes.encryptor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UnicodeTest {
  // Encryption Tests
    @Test
    public void standardCharEncryptionTest() {
      int key = 5;
      String testData = "abcd";
      Cipher shift = new ShiftCipher(testData);
      String result = String.valueOf(shift.encrypt(key));
      String expected = "fghi";
      assertEquals(expected, result, 
        "Test failed for Unicode encryption of standard chars"
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
        "Test failed for Unicode encryption of standard chars"
      );
    }
}