package it.bsuir.metrics;

import java.io.RandomAccessFile;

/*public class ProcStat {
    private static RandomAccessFile randomAccessFile;
    private static String[] times;

    public static void load() throws Throwable {
        randomAccessFile = new RandomAccessFile("/proc/stat", "r");
        String line = randomAccessFile.readLine();
        times = line.split(" ");
        calculateCpu();
        randomAccessFile.close();
    }

    private static void calculateCpu( ) {
        int timeSummary = 0;
        for (int i = 1; i < times.length; i++) {
            timeSummary += Integer.parseInt(times[i]);
        }
        int idleTime = Integer.parseInt(times[5]);

    }
}
*/