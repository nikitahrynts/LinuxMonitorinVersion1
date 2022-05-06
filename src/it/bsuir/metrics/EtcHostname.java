package it.bsuir.metrics;

import java.io.RandomAccessFile;

//Gathering metrics using pseudo files
/*
cat /etc/hostname
 */
public class EtcHostname {
    private static RandomAccessFile randomAccessFile;

    public static void load() throws Throwable {
        randomAccessFile = new RandomAccessFile("/proc/hostname", "r");
        String line = randomAccessFile.readLine();
        System.out.println("Hostname: " + line);
    }
}
