package it.bsuir.metrics;

import java.io.RandomAccessFile;

public class ProcCpuInfo {
    private static RandomAccessFile randomAccessFile;
    private static String[] cores;

    public static void load() throws Throwable {
        randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
        for (int i = 0; i < 12; i++) {
            randomAccessFile.readLine();
        }
        String cpuCoresLine = randomAccessFile.readLine();
        cores = cpuCoresLine.split(" ");
        int numCores = Integer.parseInt(cores[9]) * 2;
        System.out.println("Number of processors: " + numCores);
    }
}
