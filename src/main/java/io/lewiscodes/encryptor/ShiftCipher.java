package io.lewiscodes.encryptor;

public class ShiftCipher extends Message implements Cipher {
    public static final String lowerCircle =
            "abcdefghijklmnopqrstuvwxyz";
    public static final String upperCircle =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public ShiftCipher(String data) {
        super(data);
    }

    @Override
    public char[] encrypt(int key) {
        char[] encArray = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            // take data[i]
            char current = data[i];
            // ignore if not a-zA-Z
            if (lowerCircle.indexOf(current) == -1 && upperCircle.indexOf(current) == -1) {
                encArray[i] = current;
                continue;
            }
            // detect case
            if (Character.isUpperCase(current)) {
                int circleIndex = upperCircle.indexOf(current);
                circleIndex += key;
                circleIndex = circleIndex % 26;
                encArray[i] = upperCircle.charAt(circleIndex);
            } else {
                int circleIndex = lowerCircle.indexOf(current);
                circleIndex += key;
                circleIndex = circleIndex % 26;
                encArray[i] = lowerCircle.charAt(circleIndex);
            }
        }
        return encArray;
    }

    @Override
    public char[] decrypt(int key) {
        char[] decArray = new char[data.length];
        for (int i = 0; i < data.length; i++) {
            // take data[i]
            char current = data[i];
            // ignore if not a-zA-Z
            if (lowerCircle.indexOf(current) == -1 && upperCircle.indexOf(current) == -1) {
                decArray[i] = current;
                continue;
            }
            // detect case
            if (Character.isUpperCase(current)) {
                int circleIndex = upperCircle.indexOf(current);
                circleIndex -= key;
                if (circleIndex < 0) {
                    circleIndex = 26 + circleIndex;
                }
                decArray[i] = upperCircle.charAt(circleIndex);
            } else {
                int circleIndex = lowerCircle.indexOf(current);
                circleIndex -= key;
                if (circleIndex < 0) {
                    circleIndex = 26 + circleIndex;
                }
                decArray[i] = lowerCircle.charAt(circleIndex);
            }
        }
        return decArray;
    }
}
