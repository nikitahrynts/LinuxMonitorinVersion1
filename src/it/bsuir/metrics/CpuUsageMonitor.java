package it.bsuir.metrics;

import com.sun.management.OperatingSystemMXBean;

import javax.management.MBeanServerConnection;
import java.io.IOException;
import java.lang.management.ManagementFactory;

public class CpuUsageMonitor {

    public static void load() throws IOException {
        MBeanServerConnection mBeanServerConnection = ManagementFactory.getPlatformMBeanServer();

        OperatingSystemMXBean osMBean = ManagementFactory.newPlatformMXBeanProxy(
                mBeanServerConnection, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);

        long nanoBefore = System.nanoTime();
        long cpuBefore = osMBean.getProcessCpuTime();

        long cpuAfter = osMBean.getProcessCpuTime();
        long nanoAfter = System.nanoTime();

        long percent;


        if (nanoAfter > nanoBefore)
            percent = ((cpuAfter - cpuBefore) * 100L) /
                    (nanoAfter - nanoBefore);
        else percent = 0;

        System.out.println("Cpu usage: " + percent + "%");
    }
}