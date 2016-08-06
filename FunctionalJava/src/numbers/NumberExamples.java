package numbers;

import java.util.ArrayList;
import java.util.List;


public class NumberExamples {

    private List<Integer> numbers = new ArrayList<>();

    public NumberExamples(int count) {
        for (int i = 1; i <= count; i++) {
            numbers.add(i);
        }
    }

    public int sumWithFor() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }



    public int maxWithFor() {
        int max = Integer.MIN_VALUE;
        for (Integer number : numbers) {
            if(number > max) {
                max = number;
            }
        }
        return max;
    }



}
