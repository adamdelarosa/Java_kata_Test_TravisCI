package main.java.com.progkata;

import java.io.BufferedReader;
import java.io.FileReader;


public class MiscUtils {

    public static String readFile(String filename, int initialLinesSkipped) throws Exception {

        String line;
        StringBuilder builder = new StringBuilder();
        int counter = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            while ((line = br.readLine()) != null) {
                if (++counter > initialLinesSkipped && !line.startsWith("   ----")) {
                    builder.append(line).append("\n");
                }
            }
        }
        catch (Exception ex) {
            System.out.println("BufferedReader fail");
            throw ex;
        }

        return builder.toString();
    }
}