package it.bsuir;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {
    private static final int TIME = 5000;
    private static RandomAccessFile mFile;
    private static ArrayList mList = new ArrayList();

    public static void main(String[] inArguments)
            throws Throwable {
        System.out.print("Running... ");
        int counter = 0;
        long end = System.currentTimeMillis() + TIME;
        while (System.currentTimeMillis() < end) {
            load();
            ++counter;
        }
        double count = counter / ((double) TIME / 1000);
        System.out.println(
                count + "/s (" + (1 / count) + ")");
    }

    private static void load()
            throws Throwable {
        mFile = new RandomAccessFile("/proc/meminfo", "r");
        parse();
        mFile.close();
    }

    private static void parse()
            throws Throwable {
        // Skip the old header.
        mFile.readLine();
        mFile.readLine();
        mFile.readLine();
        // Store the values.
        mList.clear();
        store(); // total
        store(); // free

        store(); // shared

        store(); // buffers

        store(); // cached

        store(); // swap cached

        store(); // active

        store(); // inactive

        store(); // high

        store(); // high free

        store(); // low

        store(); // low free

        store(); // swap

        store(); // swap free

    }

    private static void store()
            throws Throwable {
        // Get the next value.
        String line = mFile.readLine();
        // Skip fixed name length.
        int i = 14;
        // Skip column padding.
        while (line.charAt(i) == ' ') {
            ++i;
        }
        // Find the end of the value.
        int j = line.indexOf(' ', i);
        // Store the value as a String.
        mList.add(line.substring(i, j));
    }

}
