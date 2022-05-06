package it.bsuir.metrics;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//Gathering metrics using pseudo files
/*
0.MemTotal:        2030652 kB
1.MemFree:          925928 kB
2.MemAvailable:    1332720 kB
3.Buffers:           36296 kB
4.Cached:           485784 kB
5.SwapCached:            0 kB
Active:           746508 kB
Inactive:         239880 kB
Active(anon):     464900 kB
Inactive(anon):     5840 kB
Active(file):     281608 kB
Inactive(file):   234040 kB
Unevictable:           0 kB
Mlocked:               0 kB
14.SwapTotal:             0 kB
15.SwapFree:              0 kB
Dirty:                 0 kB
Writeback:             0 kB
AnonPages:        464440 kB
Mapped:           210196 kB
20.Shmem:              6436 kB
KReclaimable:      45336 kB
22.Slab:              90796 kB
23.SReclaimable:      45336 kB
SUnreclaim:        45460 kB
KernelStack:        3968 kB
PageTables:         4724 kB
NFS_Unstable:          0 kB
Bounce:                0 kB
WritebackTmp:          0 kB
CommitLimit:     1015324 kB
Committed_AS:    2160456 kB
VmallocTotal:   34359738367 kB
VmallocUsed:       12052 kB
VmallocChunk:          0 kB
Percpu:             1408 kB
HardwareCorrupted:     0 kB
AnonHugePages:         0 kB
ShmemHugePages:        0 kB
ShmemPmdMapped:        0 kB
FileHugePages:         0 kB
FilePmdMapped:         0 kB
CmaTotal:              0 kB
CmaFree:               0 kB
HugePages_Total:       0
HugePages_Free:        0
HugePages_Rsvd:        0
HugePages_Surp:        0
Hugepagesize:       2048 kB
Hugetlb:               0 kB
DirectMap4k:      114548 kB
DirectMap2M:     1982464 kB
DirectMap1G:           0 kB
 */
public class ProcMeminfo {

    private static RandomAccessFile randomAccessFile;
    private static ArrayList memList;
    private static final int CONST = 1048576;

    public static void load() throws Throwable{
        randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
        Pattern pattern = Pattern.compile("[0-9]+");
        for (int i = 0; i < 24; i++) {
            String line = randomAccessFile.readLine();
            Matcher matcher = pattern.matcher(line);
            memList.add(matcher);
        }
        for (int i = 0; i < memList.size(); i++) {
            System.out.println(memList.get(i));
        }
    }
}
