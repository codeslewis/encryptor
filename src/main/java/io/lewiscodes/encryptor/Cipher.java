package io.lewiscodes.encryptor;

public interface Cipher {
    char[] encrypt(int key);
    char[] decrypt(int key);
}
