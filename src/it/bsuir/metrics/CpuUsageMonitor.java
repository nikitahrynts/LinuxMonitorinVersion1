package it.bsuir.metrics;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class CpuUsageMonitor {

    public static void printUsage() {
        OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();

        while (true) {
            System.out.println(bean.getProcessCpuLoad());
            System.out.println(bean.getSystemCpuLoad());
        }
    }
}