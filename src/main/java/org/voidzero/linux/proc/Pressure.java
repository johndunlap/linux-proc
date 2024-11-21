package org.voidzero.linux.proc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pressure {
    // Available in Linux Kernel 4.20.0 and later
    // https://unixism.net/2019/08/linux-pressure-stall-information-psi-by-example/
    public static final String PROC_PRESSURE_CPU = "/proc/pressure/cpu";

    // Available in Linux Kernel 4.20.0 and later
    // https://unixism.net/2019/08/linux-pressure-stall-information-psi-by-example/
    public static final String PROC_PRESSURE_IO = "/proc/pressure/io";

    // Available in Linux Kernel 4.20.0 and later
    // https://unixism.net/2019/08/linux-pressure-stall-information-psi-by-example/
    public static final String PROC_PRESSURE_MEMORY = "/proc/pressure/memory";

    public static PSI getCpuPressure() throws IOException {
        return new PSI(Files.readAllLines(Paths.get(PROC_PRESSURE_CPU)));
    }

    public static PSI getIoPressure() throws IOException {
        return new PSI(Files.readAllLines(Paths.get(PROC_PRESSURE_MEMORY)));
    }

    public static PSI getMemoryPressure() throws IOException {
        return new PSI(Files.readAllLines(Paths.get(PROC_PRESSURE_IO)));
    }
}
