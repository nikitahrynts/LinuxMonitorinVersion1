package it.bsuir.memory;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class MemFile {
    public static final int TIME = 5000;
    public static ArrayList mList = new ArrayList();
    public static byte[] mBuffer = new byte[4096];
    private static int mOffSet;

    private static int[] mOffsets = new int[200];
    private static int[] mLengths = new int[200];
    private static int mField;

    public static void parse() throws Throwable {
        mOffSet = 0;
        mField = 0;

        while (mBuffer[mOffSet++] != '\n') ;
        while (mBuffer[mOffSet++] != '\n') ;
        while (mBuffer[mOffSet++] != '\n') ;
        mOffSet += 14;
        mList.clear();
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

    public static void store() throws Throwable {
        while (mBuffer[mOffSet] == ' ') {
            ++mOffSet;
        }
        int offSet = mOffSet;
        while (mBuffer[mOffSet] != ' ') {
            ++mOffSet;
        }
        mOffsets[mField] = offSet;
        mLengths[mField++] = mOffSet - offSet;
        mList.add(new String(mBuffer, offSet, mOffSet - offSet));
        mOffSet += 18;
    }

}