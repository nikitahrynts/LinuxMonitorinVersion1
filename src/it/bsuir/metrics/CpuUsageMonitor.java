package it.bsuir.metrics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CpuUsageMonitor {

    public static double printUsage() throws InterruptedException{
        try {

            long delay = 50;
            List<Double> listValues = new ArrayList<Double>();
            for (int i = 0; i < 100; i++) {
                long cput1 = getCpuT();
                Thread.sleep(delay);
                long cput2 = getCpuT();
                double cpuproc = (1000d * (cput2 - cput1)) / (double) delay;
                listValues.add(cpuproc);
            }
            listValues.remove(0);
            listValues.remove(listValues.size() - 1);
            double sum = 0.0;
            for (Double double1 : listValues) {
                sum += double1;
            }
            System.out.println(sum/listValues.size());
            return sum / listValues.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    private static long getCpuT() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("/proc/stat"));
        String line = reader.readLine();
        Pattern pattern = Pattern.compile("\\D+(\\d+)\\D+(\\d+)\\D+(\\d+)\\D+(\\d+)");
        Matcher m = pattern.matcher(line);

        long cpuUser = 0;
        long cpuSystem = 0;
        if (m.find()) {
            cpuUser = Long.parseLong(m.group(1));
            cpuSystem = Long.parseLong(m.group(3));
        }
        return cpuUser + cpuSystem;
    }
}
