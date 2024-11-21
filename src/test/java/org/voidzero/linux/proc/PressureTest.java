package org.voidzero.linux.proc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PressureTest {

    public static final String[] SAMPLE_PSI_OUTPUT = ("some avg10=1.81 avg60=2.08 avg300=1.97 total=1324009986\n" +
            "full avg10=0.00 avg60=0.00 avg300=0.00 total=0\n").split("\n");

    @Test
    public void testLoadWhenLoadLow() {
        PSI pressure = new PSI(Arrays.asList(SAMPLE_PSI_OUTPUT));
        assertEquals(Double.valueOf(1.81), (Double)pressure.getSomeAvg10());
        assertEquals(Double.valueOf(2.08), (Double)pressure.getSomeAvg60());
        assertEquals(Double.valueOf(1.97), (Double)pressure.getSomeAvg300());
        assertEquals(Long.valueOf(1324009986), (Long)pressure.getSomeTotal());
        assertEquals(Double.valueOf(0.00), (Double)pressure.getFullAvg10());
        assertEquals(Double.valueOf(0.00), (Double)pressure.getFullAvg60());
        assertEquals(Double.valueOf(0.00), (Double)pressure.getFullAvg300());
        assertEquals(Long.valueOf(0), (Long)pressure.getFullTotal());
    }
}
