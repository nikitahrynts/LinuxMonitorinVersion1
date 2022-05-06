package it.bsuir.rates;

import java.io.RandomAccessFile;
import java.util.ArrayList;

//Gathering total memory rates using pseudo files
public class MeminfoFile {

    public static final int TIME = 5000;
    private static RandomAccessFile mFile;
    private static ArrayList mList = new ArrayList();

    public static void load() throws Throwable {
        mFile = new RandomAccessFile("/proc/meminfo", "r");
        parse();
        mFile.close();
    }

    public static void parse() throws Throwable {
        //Skip the old header
        mFile.readLine();
        mFile.readLine();
        mFile.readLine();
        mList.clear();
        //Types of memory storage
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