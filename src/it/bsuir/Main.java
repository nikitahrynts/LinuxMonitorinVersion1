package it.bsuir;

import it.bsuir.memory.MemFile;

import java.io.RandomAccessFile;

import static it.bsuir.memory.MemFile.mBuffer;
import static it.bsuir.memory.MemFile.parse;

public class Main {

    public static RandomAccessFile mFile;

    public static void main(String[] inArguments) throws Throwable {
        System.out.print("Running... ");
        mFile = new RandomAccessFile("/proc/meminfo", "r");
        int counter = 0;
        long end = System.currentTimeMillis() + MemFile.TIME;
        while (System.currentTimeMillis() < end) {
            load();
            ++counter;
        }
        mFile.close();
        double count = counter / ((double) MemFile.TIME / 1000);
        System.out.println(
                count + "/s (" + (1 / count) + ")");
    }

    private static void load() throws Throwable {
        mFile.read(mBuffer);
        mFile.seek(0);
        parse();
    }
}