import java.util.function.Supplier;

public class Stopwatch {

    public long measureFunctionExecutionTime(Supplier<Integer> supplier) {
        long t1 = System.nanoTime();
        supplier.get();
        long t2 = System.nanoTime();
        return t2 - t1;
    }

}
