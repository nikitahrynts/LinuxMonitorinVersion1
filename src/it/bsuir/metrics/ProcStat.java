package it.bsuir.metrics;

import java.io.*;
import java.text.NumberFormat;
import java.util.TimerTask;

public class ProcStat {

    public static class CpuUtilizationTask extends TimerTask {

        private final String STAT_FILE_HEADER = "cpu  ";
        private final NumberFormat percentFormatter;
        private final RandomAccessFile statPointer;
        long previousIdleTime = 0, previousTotalTime = 0;

        public CpuUtilizationTask() throws FileNotFoundException {
            this.percentFormatter = NumberFormat.getPercentInstance();
            percentFormatter.setMaximumFractionDigits(2);
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
                System.out.println(percentFormatter.format(utilization));

                previousIdleTime = idleTime;
                previousTotalTime = totalTime;
                statPointer.seek(0);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
