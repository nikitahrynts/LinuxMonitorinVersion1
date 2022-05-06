package it.bsuir.metrics;

import java.io.RandomAccessFile;
import java.sql.Time;

//Gathering metrics using pseudo files
/*
	$cat /proc/uptime
	>>34903.79  224873.38
	[0] uptime is the duration in seconds that system has run
	[1] idletime is the duraiton in seconds when processor was not being used by any program
	[return] uptime
*/
public class ProcUptime {
    private static RandomAccessFile randomAccessFile;

    public static void load() throws Throwable {
        randomAccessFile = new RandomAccessFile("/proc/uptime", "r");
        String line = randomAccessFile.readLine();
        String[] times = line.split(" ");
        double time = Double.parseDouble(times[0]);
        double idleTime = Double.parseDouble(times[1]);
        System.out.println("Time: " + time + " seconds"
                + "\n" + "IdleTime: " + idleTime + " seconds");
    }
}
