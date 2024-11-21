package org.voidzero.linux.proc;

import java.util.Arrays;
import java.util.List;

public class PSI {
    private double someAvg10 = -1;
    private double someAvg60 = -1;
    private double someAvg300 = -1;
    private long someTotal = -1;
    private double fullAvg10 = -1;
    private double fullAvg60 = -1;
    private double fullAvg300 = -1;
    private long fullTotal = -1;

    public PSI(String raw) {
        this(raw == null ? null : Arrays.asList(raw.split("\n")));
    }

    public PSI(String[] lines) {
        this(Arrays.asList(lines));
    }

    public PSI(List<String> lines) {
        if (lines != null && lines.size() > 0) {
            String[] parts;
            for (String line : lines) {
                if (line.startsWith("some")) {
                    parts = line.split(" ");
                    setSomeAvg10(Double.parseDouble(parts[1].split("=")[1]));
                    setSomeAvg60(Double.parseDouble(parts[2].split("=")[1]));
                    setSomeAvg300(Double.parseDouble(parts[3].split("=")[1]));
                    setSomeTotal(Long.parseLong(parts[4].split("=")[1]));
                }

                if (line.startsWith("full")) {
                    parts = line.split(" ");
                    setFullAvg10(Double.parseDouble(parts[1].split("=")[1]));
                    setFullAvg60(Double.parseDouble(parts[2].split("=")[1]));
                    setFullAvg300(Double.parseDouble(parts[3].split("=")[1]));
                    setFullTotal(Long.parseLong(parts[4].split("=")[1]));
                }
            }
        }
    }
    
    public double getSomeAvg10() {
        return someAvg10;
    }

    public PSI setSomeAvg10(double someAvg10) {
        this.someAvg10 = someAvg10;
        return this;
    }

    public double getSomeAvg60() {
        return someAvg60;
    }

    public PSI setSomeAvg60(double someAvg60) {
        this.someAvg60 = someAvg60;
        return this;
    }

    public double getSomeAvg300() {
        return someAvg300;
    }

    public PSI setSomeAvg300(double someAvg300) {
        this.someAvg300 = someAvg300;
        return this;
    }

    public double getFullAvg10() {
        return fullAvg10;
    }

    public PSI setFullAvg10(double fullAvg10) {
        this.fullAvg10 = fullAvg10;
        return this;
    }

    public double getFullAvg60() {
        return fullAvg60;
    }

    public PSI setFullAvg60(double fullAvg60) {
        this.fullAvg60 = fullAvg60;
        return this;
    }

    public double getFullAvg300() {
        return fullAvg300;
    }

    public PSI setFullAvg300(double fullAvg300) {
        this.fullAvg300 = fullAvg300;
        return this;
    }

    public long getSomeTotal() {
        return someTotal;
    }

    public PSI setSomeTotal(long someTotal) {
        this.someTotal = someTotal;
        return this;
    }

    public long getFullTotal() {
        return fullTotal;
    }

    public PSI setFullTotal(long fullTotal) {
        this.fullTotal = fullTotal;
        return this;
    }

    @Override
    public String toString() {
        return "CpuPressure{" +
                "someAvg10=" + someAvg10 +
                ", someAvg60=" + someAvg60 +
                ", someAvg300=" + someAvg300 +
                ", someTotal=" + someTotal +
                ", fullAvg10=" + fullAvg10 +
                ", fullAvg60=" + fullAvg60 +
                ", fullAvg300=" + fullAvg300 +
                ", fullTotal=" + fullTotal +
                '}';
    }
}