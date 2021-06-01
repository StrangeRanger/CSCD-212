package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Facilitates keyboard input by abstracting details about input parsing, conversions,
 * and exception handling.
 */
public class Keyboard {
    /// Output text color.
    public static final String RED = (char) 27 + "[31m";
    public static final String NC  = (char) 27 + "[0m";

    /// Tokenized Input Stream Variables.
    private static String               currentToken = null;
    private static StringTokenizer      reader;
    private static final BufferedReader in
            = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Prints out a specified error message.
     *
     * @param errorString Error text to be printed.
     */
    private static void error(String errorString) {
        System.out.println(RED + errorString + NC);
    }

    /** Gets the next input token, assuming it may be on subsequent input lines. */
    private static String getNextToken() { return getNextToken(true); }

    /**
     * Gets the next input token, which may already have been read.
     *
     * TODO: Add more to method comments.
     *
     * @param skip ...
     * @return 	   ...
     */
    private static String getNextToken(boolean skip) {
        String token;

        if (currentToken == null)
            token = getNextInputToken(skip);
        else {
            token        = currentToken;
            currentToken = null;
        }
        return token;
    }

    /**
     * Gets the next token from the input, which may come from the current input line or
     * a subsequent one. The parameter determines if subsequent lines are used.
     *
     * TODO: Add more to method comments.
     *
     * @param skip ...
     * @return     ...
     */
    private static String getNextInputToken(boolean skip) {
        final var delimiters = " \t\n\r\f";
        String    token      = null;

        try {
            if (reader == null) {
                reader = new StringTokenizer(in.readLine(), delimiters, true);
            }

            while (token == null || ((delimiters.contains(token)) && skip)) {
                while (! reader.hasMoreTokens()) {
                    reader = new StringTokenizer(in.readLine(), delimiters, true);
                }

                token = reader.nextToken();
            }
        } catch (Exception exception) {
            token = null;
        }

        return token;
    }

    /** Returns true if there are no more tokens to read on the current input line. */
    public static boolean endOfLine() { return ! reader.hasMoreTokens(); }


    /** Returns a string read from standard input. */
    public static String readString() {
        StringBuilder str;

        try {
            str = new StringBuilder(getNextToken(false));
            while (! endOfLine()) {
                str.append(getNextToken(false));
            }
        } catch (Exception exception) {
            error("Error reading String data, null value returned.");
            str = null;
        }
        assert str != null;
        return str.toString();
    }

    /** Returns an integer read from standard input. */
    public static int readInt() {
        String token = getNextToken();
        int    value;

        try {
            value = Integer.parseInt(token);
        } catch (Exception exception) {
            error("Error reading int data, MIN_VALUE value returned.");
            value = Integer.MIN_VALUE;
        }
        return value;
    }
}
