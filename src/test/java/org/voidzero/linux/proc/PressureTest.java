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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

/**
 * Unit tests for {@link Pressure}.
 */
public class PressureTest {

    public static final String[] SAMPLE_PSI_OUTPUT = ("some avg10=1.81 avg60=2.08 avg300=1.97 total=1324009986\n"
            + "full avg10=0.00 avg60=0.00 avg300=0.00 total=0\n").split("\n");

    @Test
    public void testLoadWhenLoadLow() {
        Psi pressure = new Psi(Arrays.asList(SAMPLE_PSI_OUTPUT));
        assertEquals(Double.valueOf(1.81), (Double) pressure.getSomeAvg10());
        assertEquals(Double.valueOf(2.08), (Double) pressure.getSomeAvg60());
        assertEquals(Double.valueOf(1.97), (Double) pressure.getSomeAvg300());
        assertEquals(Long.valueOf(1324009986), (Long) pressure.getSomeTotal());
        assertEquals(Double.valueOf(0.00), (Double) pressure.getFullAvg10());
        assertEquals(Double.valueOf(0.00), (Double) pressure.getFullAvg60());
        assertEquals(Double.valueOf(0.00), (Double) pressure.getFullAvg300());
        assertEquals(Long.valueOf(0), (Long) pressure.getFullTotal());
    }
}
