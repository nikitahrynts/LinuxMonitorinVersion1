package it.bsuir.processor;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class ProcFile {

    private final static String pathFile = "/proc/cpuinfo";
    public static RandomAccessFile randomAccessFile;
    public static void load() throws FileNotFoundException {
        randomAccessFile = new RandomAccessFile(pathFile, "r");
        parse();

    }

    private static void parse() {
    }

}
