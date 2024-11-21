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

import java.util.Arrays;
import java.util.List;

/**
 * Contains data fields parsed from /proc/pressure/cpu, /proc/pressure/io, /proc/pressure/memory. The same class can be
 * used for all three files because their output format is the same.
 */
public class Psi {
    private double someAvg10 = -1;
    private double someAvg60 = -1;
    private double someAvg300 = -1;
    private long someTotal = -1;
    private double fullAvg10 = -1;
    private double fullAvg60 = -1;
    private double fullAvg300 = -1;
    private long fullTotal = -1;

    /**
     * No-arg constructor.
     */
    public Psi() {
    }

    /**
     * Constructs an instance of this class from the string contents of the pressure file.
     *
     * @param raw raw contents of the pressure file
     */
    public Psi(String raw) {
        this(raw == null ? null : Arrays.asList(raw.split("\n")));
    }

    /**
     * Constructs an instance of this class from an array of lines.
     *
     * @param lines lines which should be parsed
     */
    public Psi(String[] lines) {
        this(Arrays.asList(lines));
    }

    /**
     * Constructs an instance of this class from a list of lines.
     *
     * @param lines lines which should be parsed
     */
    public Psi(List<String> lines) {
        if (lines != null && lines.size() > 0) {
            String[] parts;
            for (String line : lines) {
                if (line.startsWith("some")) {
                    parts = line.split(" ");
                    someAvg10 = Double.parseDouble(parts[1].split("=")[1]);
                    someAvg60 = Double.parseDouble(parts[2].split("=")[1]);
                    someAvg300 = Double.parseDouble(parts[3].split("=")[1]);
                    someTotal = Long.parseLong(parts[4].split("=")[1]);
                }

                if (line.startsWith("full")) {
                    parts = line.split(" ");
                    fullAvg10 = Double.parseDouble(parts[1].split("=")[1]);
                    fullAvg60 = Double.parseDouble(parts[2].split("=")[1]);
                    fullAvg300 = Double.parseDouble(parts[3].split("=")[1]);
                    fullTotal = Long.parseLong(parts[4].split("=")[1]);
                }
            }
        }
    }

    /**
     * Returns the 10-second average percentage of time that some processes were stalled
     * due to resource contention.
     *
     * @return the 10-second average percentage of time that some processes were stalled
     *         due to resource contention
     */
    public double getSomeAvg10() {
        return someAvg10;
    }

    /**
     * Returns the 60-second average percentage of time that some processes were stalled
     * due to resource contention.
     *
     * @return the 60-second average percentage of time that some processes were stalled
     *         due to resource contention
     */
    public double getSomeAvg60() {
        return someAvg60;
    }

    /**
     * Returns the 300-second average percentage of time that some processes were stalled
     * due to resource contention.
     *
     * @return the 300-second average percentage of time that some processes were stalled
     *         due to resource contention
     */
    public double getSomeAvg300() {
        return someAvg300;
    }

    /**
     * Returns the 10-second average percentage of time that all processes were stalled
     * due to resource contention.
     *
     * @return the 10-second average percentage of time that all processes were stalled
     *         due to resource contention
     */
    public double getFullAvg10() {
        return fullAvg10;
    }

    /**
     * Returns the 60-second average percentage of time that all processes were stalled
     * due to resource contention.
     *
     * @return the 60-second average percentage of time that all processes were stalled
     *         due to resource contention
     */
    public double getFullAvg60() {
        return fullAvg60;
    }

    /**
     * Returns the 300-second average percentage of time that all processes were stalled
     * due to resource contention.
     *
     * @return the 300-second average percentage of time that all processes were stalled
     *         due to resource contention
     */
    public double getFullAvg300() {
        return fullAvg300;
    }

    /**
     * Returns the total accumulated time in microseconds that some processes were stalled
     * due to resource contention since monitoring began.
     *
     * @return the total accumulated time in microseconds that some processes were stalled
     */
    public long getSomeTotal() {
        return someTotal;
    }

    /**
     * Returns the total accumulated time in microseconds that all processes were stalled
     * due to resource contention since monitoring began.
     *
     * @return the total accumulated time in microseconds that all processes were stalled
     */
    public long getFullTotal() {
        return fullTotal;
    }

    /**
     * To string method.
     *
     * @return A string representation of this object.
     */
    @Override
    public String toString() {
        return "PSI{"
                + "someAvg10=" + someAvg10
                + ", someAvg60=" + someAvg60
                + ", someAvg300=" + someAvg300
                + ", someTotal=" + someTotal
                + ", fullAvg10=" + fullAvg10
                + ", fullAvg60=" + fullAvg60
                + ", fullAvg300=" + fullAvg300
                + ", fullTotal=" + fullTotal
                + '}';
    }
}
