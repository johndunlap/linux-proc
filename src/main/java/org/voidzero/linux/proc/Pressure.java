package org.voidzero.linux.proc;

/*-
 * #%L
 * linux-proc
 * %%
 * Copyright (C) 2023 - 2024 John Dunlap
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Handles information from /proc/pressure/.
 */
public class Pressure {
    /**
     * The location of the pressure CPU file. Available in Linux Kernel 4.20.0 and later.
     * <a href="https://unixism.net/2019/08/linux-pressure-stall-information-psi-by-example/">
     *     Linux Pressure Stall Information PSI by Example</a>
     */
    public static final String PROC_PRESSURE_CPU = "/proc/pressure/cpu";

    /**
     * The location of the pressure IO file. Available in Linux Kernel 4.20.0 and later.
     * <a href="https://unixism.net/2019/08/linux-pressure-stall-information-psi-by-example/">
     *     Linux Pressure Stall Information PSI by Example</a>
     */
    public static final String PROC_PRESSURE_IO = "/proc/pressure/io";

    /**
     * The location of the pressure memory file. Available in Linux Kernel 4.20.0 and later.
     * <a href="https://unixism.net/2019/08/linux-pressure-stall-information-psi-by-example/">
     *     Linux Pressure Stall Information PSI by Example</a>
     */
    public static final String PROC_PRESSURE_MEMORY = "/proc/pressure/memory";

    /**
     * No-arg constructor which is not intended to be used.
     */
    private Pressure() {
        throw new RuntimeException("DO NOT CALL THIS");
    }

    /**
     * Returns an instance of {@link Psi} which contains data loaded from /proc/pressure/cpu.
     *
     * @return an instance of {@link Psi} which contains data loaded from /proc/pressure/cpu
     * @throws IOException thrown when the file cannot be read
     */
    public static Psi getCpuPressure() throws IOException {
        return new Psi(Files.readAllLines(Paths.get(PROC_PRESSURE_CPU)));
    }

    /**
     * Returns an instance of {@link Psi} which contains data loaded from /proc/pressure/io.
     *
     * @return an instance of {@link Psi} which contains data loaded from /proc/pressure/io
     * @throws IOException thrown when the file cannot be read
     */
    public static Psi getIoPressure() throws IOException {
        return new Psi(Files.readAllLines(Paths.get(PROC_PRESSURE_MEMORY)));
    }

    /**
     * Returns an instance of {@link Psi} which contains data loaded from /proc/pressure/memory.
     *
     * @return an instance of {@link Psi} which contains data loaded from /proc/pressure/memory
     * @throws IOException thrown when the file cannot be read
     */
    public static Psi getMemoryPressure() throws IOException {
        return new Psi(Files.readAllLines(Paths.get(PROC_PRESSURE_IO)));
    }
}
