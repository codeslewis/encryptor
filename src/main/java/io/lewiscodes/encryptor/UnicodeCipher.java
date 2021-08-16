package io.lewiscodes.encryptor;

public class UnicodeCipher extends Message implements Cipher{
    public UnicodeCipher(String data) {
        super(data);
    }

    @Override
    public char[] encrypt(int key) {
        char[] encArray = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            encArray[i] = (char)(data[i] + key);
        }
        return encArray;
    }

    @Override
    public char[] decrypt(int key) {
        char[] decArray = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            decArray[i] = (char)(data[i] - key);
        }
        return decArray;
    }
}
