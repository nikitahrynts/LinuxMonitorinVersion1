package it.bsuir;

import it.bsuir.metrics.CpuUsageMonitor;
import it.bsuir.metrics.ProcCpuInfo;
import it.bsuir.rates.MeminfoFile;

import static java.sql.Types.TIME;

public class Main {

    public static void main(String[] inArguments) throws Throwable {
        System.out.println("Running... ");
        int counter = 0;
        long end = System.currentTimeMillis() + TIME;
        while (System.currentTimeMillis() < end) {
            MeminfoFile.load();
            ++counter;
        }
        double count = counter / ((double) TIME / 1000);
        System.out.println(count + "s/(" + (1 / count) + ")");
        System.out.println("/////////////////////////////////////////////");
        ProcCpuInfo.load();
        System.out.println("/////////////////////////////////////////////");
        double cpuUsage = CpuUsageMonitor.printUsage();
        System.out.println("CPU usage:" + cpuUsage + "%");
        System.out.println("/////////////////////////////////////////////");
    }
}