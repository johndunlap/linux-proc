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
import java.util.List;

/**
 * Handles information from /proc/cpuinfo.
 */
public class CpuInfo {
    /**
     * The fully qualified file path of the cpuino file on Linux systems.
     */
    public static final String PROC_CPUINFO = "/proc/cpuinfo";

    /**
     * No-arg constructor which is not intended to be used.
     */
    private CpuInfo() {
        throw new RuntimeException("DO NOT CALL THIS");
    }

    /**
     * Returns the number of CPU cores.
     *
     * @param lines A list of lines loaded from the file
     * @return number of CPU cores
     */
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

    /**
     * Returns the number of CPU cores.
     *
     * @return number of CPU cores
     * @throws IOException thrown if the file cannot be read
     */
    public static int getCpuCount() throws IOException {
        return getCpuCount(Files.readAllLines(Paths.get(PROC_CPUINFO)));
    }
}
