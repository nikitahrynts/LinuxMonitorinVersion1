package it.bsuir;

import it.bsuir.memory.MemFile;

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
}
