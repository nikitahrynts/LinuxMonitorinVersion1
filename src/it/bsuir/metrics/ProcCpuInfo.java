package it.bsuir.metrics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class ProcCpuInfo {
    public static RandomAccessFile randomAccessFile;
    public static ArrayList arrayList;

    public static void load() throws Throwable {
        randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
        for (int i = 0; i < 13; i++) {
            randomAccessFile.readLine();
        }
        String cpuCoresLine = randomAccessFile.readLine();
        System.out.println(cpuCoresLine);
    }
}
