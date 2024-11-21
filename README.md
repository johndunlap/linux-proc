# linux-proc
Java library for interacting with the Linux /proc file system

# Maven
```xml
<dependency>
    <groupId>org.voidzero</groupId>
    <artifactId>linux-proc</artifactId>
    <version>0.1.0</version>
</dependency>
```

# Example
```java
import org.voidzero.linux.proc.CpuInfo;
import org.voidzero.linux.proc.Pressure;
import org.voidzero.linux.proc.Psi;
import java.io.IOException;

public class Main {
    public static final Double RESOURCE_BOUND_THRESHOLD = 0.8;

    public static void main(String[] args) throws IOException {
        Psi pressure = Pressure.getCpuPressure();
        double cpuCount = CpuInfo.getCpuCount();

        if (pressure.getSomeAvg10() > cpuCount * RESOURCE_BOUND_THRESHOLD) {
            System.out.println("Above CPU bound threshold");
        } else {
            System.out.println("Everything is okay");
        }
    }
}
```
