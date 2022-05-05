package it.bsuir;

import it.bsuir.metrics.PerformanceMonitor;
import it.bsuir.metrics.ProcCpuInfo;
//import it.bsuir.metrics.ProcStat;
import it.bsuir.rates.MeminfoFile;

import java.io.RandomAccessFile;

import static it.bsuir.rates.MeminfoFile.mBuffer;
import static it.bsuir.rates.MeminfoFile.parse;

public class Main {

    public static PerformanceMonitor monitor = null;

    public static RandomAccessFile mFile;

    public static void main(String[] inArguments) throws Throwable {
        System.out.println("Running... ");
        mFile = new RandomAccessFile("/proc/meminfo", "r");
        int counter = 0;
        long end = System.currentTimeMillis() + MeminfoFile.TIME;
        while (System.currentTimeMillis() < end) {
            load();
            ++counter;
        }
        mFile.close();
        double count = counter / ((double) MeminfoFile.TIME / 1000);
        System.out.println(
                count + "/s (" + (1 / count) + ")");

        //ProcStat.load();
        ProcCpuInfo.load();
    }

    private static void load() throws Throwable {
        mFile.read(mBuffer);
        mFile.seek(0);
        parse();
    }
}