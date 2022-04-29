package it.bsuir.memory;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class MemFile {
    public static final int TIME = 5000;

    public static RandomAccessFile randomAccessFile;

    public static ArrayList arrayList = new ArrayList<>();

    public static void load() throws Throwable {
        randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
        parse();
        randomAccessFile.close();
    }

    private static void parse() throws Throwable {
        randomAccessFile.readLine();
        randomAccessFile.readLine();
        randomAccessFile.readLine();
        arrayList.clear();
        store();
        store();
        store();
        store();
        store();
        store();
        store();
        store();
        store();
        store();
        store();
        store();
        store();
        store();
    }

    private static void store() throws Throwable {
        String line = randomAccessFile.readLine();
        int i = 14;
        while (line.charAt(i) == ' ') {
            ++i;
        }
        int j = line.indexOf(' ', i);
        arrayList.add(line.substring(i, j));
    }


}