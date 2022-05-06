package it.bsuir.metrics;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

//ManagementFactory
/*
Initial: Initial memory the JVM requests from the OS during startup
Used: The current amount of memory used by the JVM
Max: The maximum memory available to the JVM. If this limit is reached an OutOfMemoryException may be thrown
Committed: The amount of memory guaranteed to be available to the JVM
 */
public class MemoryUsage {

    private static final long CONST = 1073741824;

    public static void load() throws Throwable{
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        double initMemory = (double) memoryMXBean.getHeapMemoryUsage().getInit() / CONST;
        double usedMemory = (double) memoryMXBean.getHeapMemoryUsage().getUsed() / CONST;
        double maxMemory = (double) memoryMXBean.getHeapMemoryUsage().getMax() / CONST;
        double committedMemory = (double) memoryMXBean.getHeapMemoryUsage().getCommitted() / CONST;
        System.out.println("<JVM Memory usage>");
        System.out.println(String.format("Initial memory: %.2f GB", initMemory));
        System.out.println(String.format("Used memory: %.2f GB", usedMemory));
        System.out.println(String.format("Max memory: %.2f GB", maxMemory));
        System.out.println(String.format("Committed memory: %.2f GB", committedMemory));
    }
}
