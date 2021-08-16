package io.lewiscodes.encryptor;

public class Message {
    protected char[] data;

    public Message(String data) {
        this.data = data.toCharArray();
    }
}
