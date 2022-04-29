package it.bsuir;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Throwable {
        MemFile memFile = new MemFile();
        System.out.println("Running...");
        int counter = 0;
        long end = System.currentTimeMillis() + memFile.TIME;
        while (System.currentTimeMillis() < end) {
            memFile.load();
            ++counter;
        }
        double count = counter / ((double) memFile.TIME / 1000);
        System.out.println(count + "/s (" + (1 / count) + ")");
    }

    public static class MemFile {
        public static final int TIME = 5000;

        public static RandomAccessFile randomAccessFile;

        public static ArrayList arrayList = new ArrayList<>();

        public static void load() throws Throwable {
            randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
            parse();
            randomAccessFile.close();
        }

        private static void parse() throws Throwable {
            randomAccessFile.readLine();
            randomAccessFile.readLine();
            randomAccessFile.readLine();
            arrayList.clear();
            store();
            store();
            store();
            store();
            store();
            store();
            store();
            store();
            store();
            store();
            store();
            store();
            store();
            store();
        }

        private static void store() throws Throwable {
            String line = randomAccessFile.readLine();
            int i = 14;
            while (line.charAt(i) == ' ') {
                ++i;
            }
            int j = line.indexOf(' ', i);
            arrayList.add(line.substring(i, j));
        }


    }
}
