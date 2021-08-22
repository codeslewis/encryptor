package io.lewiscodes.encryptor;

public class Arguments {
    private Mode operation;
    private Alg encryptionAlgorithm;
    private int key;
    private String message;
    private boolean data;
    private boolean out;
    private String fileNameIn;
    private String filenameOut;

    {
        operation = Mode.ENCRYPT;
        encryptionAlgorithm = Alg.SHIFT;
    }

    public static Arguments parse(String[] args) {
        Arguments argObj = new Arguments();
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    argObj.operation = args[i + 1].equals("dec") ?
                            Mode.DECRYPT : Mode.ENCRYPT;
                    break;
                case "-key":
                    argObj.key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    argObj.data = true;
                    argObj.message = args[i + 1];
                    break;
                case "-in":
                    if (!argObj.data) {
                        argObj.fileNameIn = args[i + 1];
                    }
                    break;
                case "-out":
                    argObj.out = true;
                    argObj.filenameOut = args[i + 1];
                    break;
                case "-alg":
                    argObj.encryptionAlgorithm = args[i + 1].equals("unicode") ?
                        Alg.UNICODE : Alg.SHIFT;
                    break;
            }
        }
        return argObj;
    }

    public Mode getOperation() {
        return operation;
    }

    public int getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }

    public boolean isData() {
        return data;
    }

    public boolean isOut() {
        return out;
    }

    public String getFileNameIn() {
        return fileNameIn;
    }

    public String getFilenameOut() {
        return filenameOut;
    }

    public Alg getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }
}
