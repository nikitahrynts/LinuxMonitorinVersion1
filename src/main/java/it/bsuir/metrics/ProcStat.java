package it.bsuir.metrics;

import java.io.*;
import java.text.NumberFormat;
import java.util.TimerTask;

//Gathering metrics using pseudo files
/*
cat /proc/stat contains following data:
        user    nice   system  idle      iowait irq   softirq  steal  guest  guest_nice
1.	read the first line of   /proc/stat
2.	discard the first word of that first line   (it's always cpu)
3.	sum all of the times found on that first line to get the total time
4.	divide the fourth column ("idle") by the total time, to get the fraction of time spent being idle
5.	subtract the previous fraction from 1.0 to get the time spent being   not   idle
6	multiple by   100   to get a percentage
 */
public class ProcStat {

    public static class CpuUtilizationTask extends TimerTask {

        private final String STAT_FILE_HEADER = "cpu  ";
        private final NumberFormat percentFormatter;
        private final RandomAccessFile statPointer;
        long previousIdleTime = 0, previousTotalTime = 0;

        public CpuUtilizationTask() throws FileNotFoundException {
            this.percentFormatter = NumberFormat.getPercentInstance();
            percentFormatter.setMaximumFractionDigits(4);
            var statFile = new File("/proc/stat");
            this.statPointer = new RandomAccessFile(statFile, "r");
        }

        @Override
        public void run() {

            try {
                var values = statPointer.readLine()
                        .substring(STAT_FILE_HEADER.length())
                        .split(" ");
                var idleTime = Long.parseUnsignedLong(values[3]);
                var totalTime = 0L;
                for (String value : values) {
                    totalTime += Long.parseUnsignedLong(value);
                }

                var idleTimeDelta = idleTime - previousIdleTime;
                var totalTimeDelta = totalTime - previousTotalTime;
                var utilization = 1 - ((double) idleTimeDelta) / (double) totalTimeDelta;
                System.out.println("CPU usage: "
                        + percentFormatter.format(utilization));

                previousIdleTime = idleTime;
                previousTotalTime = totalTime;
                statPointer.seek(0);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
