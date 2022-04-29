package it.bsuir;

import it.bsuir.memory.MemFile;

public class Main {
    public static void main(String[] inArguments) throws Throwable {
        System.out.print("Running... ");
        int counter = 0;
        long end = System.currentTimeMillis() + MemFile.TIME;
        while (System.currentTimeMillis() < end) {
            MemFile.load();
            ++counter;
        }
        double count = counter / ((double) MemFile.TIME / 1000);
        System.out.println(
                count + "/s (" + (1 / count) + ")");
    }
}
