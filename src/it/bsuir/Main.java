package it.bsuir;

import it.bsuir.metrics.*;
import it.bsuir.rates.MeminfoFile;

import java.time.Duration;
import java.util.Timer;

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

        EtcHostname.load();
        System.out.println("TotalMemory parses: "
                + count + "s/(" + (1 / count) + ")");
        System.out.println("/////////////////////////////////////////////");
        ProcUptime.load();
        ProcCpuInfo.load();
        DiscUsage.load();
        MemoryUsage.load();
        CpuUsage.load();
        System.out.println("/////////////////////////////////////////////");
        final var period = Duration.ofSeconds(5);
        new Timer().schedule(new ProcStat.CpuUtilizationTask(), 0, period.toMillis());
    }
}