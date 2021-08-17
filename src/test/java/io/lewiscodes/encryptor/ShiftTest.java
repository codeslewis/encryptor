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
        "Test failed for Shift encryption of standard chars: "
      );
    }
}