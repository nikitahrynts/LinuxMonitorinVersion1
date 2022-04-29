package it.bsuir;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class MemFile {
    public static final int TIME = 5000;
    public static RandomAccessFile mFile;
    public static ArrayList mList = new ArrayList();


    public static void load() throws Throwable {
        mFile = new RandomAccessFile("/proc/meminfo", "r");
        parse();
        mFile.close();
    }

    public static void parse() throws Throwable {
        mFile.readLine();
        mFile.readLine();
        mFile.readLine();
        mList.clear();
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

    public static void store() throws Throwable {
        String line = mFile.readLine();
        int i = 14;
        while (line.charAt(i) == ' ') {
            ++i;
        }
        int j = line.indexOf(' ', i);
        mList.add(line.substring(i, j));
    }

}
