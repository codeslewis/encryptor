package io.lewiscodes.encryptor;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Arguments argObj = Arguments.parse(args);
        Optional<String> input = Optional.empty();

        if (!argObj.isData()) {
            // read data from file
            try {
                input = Optional.of(readFileAsString(argObj.getFileNameIn()));
            } catch (IOException e) {
                System.out.println("Message could not be parsed from File");
            }
        } else {
            input = Optional.of(argObj.getMessage());
        }
        input.ifPresent(s -> writeOutput(argObj, s, argObj.getEncryptionAlgorithm()));
    }

    private static void writeOutput(Arguments arguments, String message, Alg algorithm) {
        Cipher cipher = algorithm == Alg.SHIFT ?
                new ShiftCipher(message) : new UnicodeCipher(message);
        char[] data = arguments.getOperation() == Mode.ENCRYPT ?
                cipher.encrypt(arguments.getKey()) : cipher.decrypt(arguments.getKey());
        if (!arguments.isOut()) {
            for (char character : data) {
                System.out.print(character);
            }
        } else {
            // write data to file
            File outputFile = new File(arguments.getFilenameOut());
            try (PrintWriter writer = new PrintWriter(outputFile)) {
                for (char character : data) {
                    writer.print(character);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }    
    
    private static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
