package it.bsuir.metrics;

import java.io.RandomAccessFile;

//Gathering metrics using pseudo files
public class ProcCpuInfo {
    private static RandomAccessFile randomAccessFile;

    public static void load() throws Throwable {
        randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
        for (int i = 0; i < 12; i++) {
            randomAccessFile.readLine();
        }
        String cpuCoresLine = randomAccessFile.readLine();
        String[] cores = cpuCoresLine.split(" ");
        int numCores = Integer.parseInt(cores[2]) * 2;
        System.out.println("Number of processors: " + numCores);
    }
}
