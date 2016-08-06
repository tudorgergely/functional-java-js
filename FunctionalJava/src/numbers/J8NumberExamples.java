package numbers;

import java.util.stream.IntStream;

public class J8NumberExamples {

    private int count;

    public J8NumberExamples(int count) {
        this.count = count;
    }

    public int sumWithJ8() {
        return IntStream.range(1, count).sum();
    }

    public int maxWithJ8() {
        return IntStream.range(1, count).max().getAsInt();
    }

}
