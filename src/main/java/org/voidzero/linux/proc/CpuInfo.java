package org.voidzero.linux.proc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CpuInfo {
    public static final String PROC_CPUINFO = "/proc/cpuinfo";

    public static int getCpuCount(List<String> lines) {
        int count = 0;

        if (lines != null && lines.size() > 0) {
            for (String line : lines) {
                if (line.startsWith("processor")) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int getCpuCount() throws IOException {
        return getCpuCount(Files.readAllLines(Paths.get(PROC_CPUINFO)));
    }
}
