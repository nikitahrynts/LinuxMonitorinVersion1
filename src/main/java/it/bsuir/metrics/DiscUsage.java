package it.bsuir.metrics;

import java.io.File;

//ManagementFactory
public class DiscUsage {

    private static final long CONST = 1073741824;

    public static void load() throws Throwable{
        File root = new File("/");
        double totalSpace = (double) root.getTotalSpace() / CONST;
        double freeSpace = (double) root.getFreeSpace() / CONST;
        double usableSpace = (double) root.getUsableSpace() / CONST;
        System.out.println("<Disk usage>");
        System.out.println(String.format("Total space: %.2f GB", totalSpace));
        System.out.println(String.format("Free space: %.2f GB", freeSpace));
        System.out.println(String.format("Usable space: %.2f GB", usableSpace));
    }
}
