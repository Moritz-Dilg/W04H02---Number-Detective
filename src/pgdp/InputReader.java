package pgdp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    public static String readString() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int readInt() {
        while (true) {
            String input = readString();
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("This was not a valid number, please try again.");
            }
        }
    }
}
