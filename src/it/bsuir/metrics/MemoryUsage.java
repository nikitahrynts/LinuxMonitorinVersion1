package it.bsuir.metrics;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;


/*
Initial: Initial memory the JVM requests from the OS during startup
Used: The current amount of memory used by the JVM
Max: The maximum memory available to the JVM. If this limit is reached an OutOfMemoryException may be thrown
Committed: The amount of memory guaranteed to be available to the JVM
 */
public class MemoryUsage {
    public static void load() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        double initMemory = memoryMXBean.getHeapMemoryUsage().getInit();
        double usedMemory = memoryMXBean.getHeapMemoryUsage().getUsed();
        double maxMemory = memoryMXBean.getHeapMemoryUsage().getMax();
        double committedMemory = memoryMXBean.getHeapMemoryUsage().getCommitted();
        System.out.println("<Memory usage>");
        System.out.println(String.format("Initial memory: %.2f GB", initMemory));
        System.out.println(String.format("Used memory: %.2f GB", usedMemory));
        System.out.println(String.format("Max memory: %.2f GB", maxMemory));
        System.out.println(String.format("Committed memory: %.2f GB", committedMemory));
    }
}
