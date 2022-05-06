package it.bsuir.metrics;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;

public class CpuUsage {

    //ManagementFactory
    public static void load() throws Throwable {
        List threadList = new ArrayList();
        List threadState = new ArrayList();
        List threadCpuTime = new ArrayList();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        for (Long threadID : threadMXBean.getAllThreadIds()) {
            ThreadInfo info = threadMXBean.getThreadInfo(threadID);
            threadList.add(info.getThreadName());
            threadState.add(info.getThreadState());
            threadCpuTime.add(threadMXBean.getThreadCpuTime(threadID));
        }
        System.out.println("<Threads>");
        for (int i = 0; i < threadList.size(); i++) {
            System.out.println("Thread name: " + threadList.get(i));
            System.out.println("Thread state: " + threadState.get(i));
            System.out.println(String.format("CPU time: %s ns", threadCpuTime.get(i)));
            System.out.println("----------------------------------------------------");
        }
    }
}
