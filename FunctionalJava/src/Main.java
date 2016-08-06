import immutability.MultipleThreadExamples;
import immutability.MutabilityExamples;
import immutability.model.ImmutableDog;
import immutability.model.MutableDog;
import numbers.J8NumberExamples;
import numbers.NumberExamples;
import strings.StringExamples;

import java.util.Collection;
import java.util.function.Supplier;

public class Main {

    private static final String SEPARATOR = "==============================================";
    private static final String DELIMITER = " ";
    private static final int STRING_LENGTH_FILTER = 5;
    private static final int NUMBERS_COUNT = 30_000_000;

    private static void printResults(Collection<?> results) {
        results.forEach(s -> System.out.print(s + DELIMITER));
        System.out.println();
    }

    private static void executeNumberExamples() {
        System.out.println("Number examples:");
        Stopwatch stopwatch = new Stopwatch();
        NumberExamples numberExamples = new NumberExamples(NUMBERS_COUNT);
        J8NumberExamples j8NumberExamples = new J8NumberExamples(NUMBERS_COUNT);
        Supplier<Integer> sumWithFor = numberExamples::sumWithFor;
        Supplier<Integer> sumWithJ8 = j8NumberExamples::sumWithJ8;
        Supplier<Integer> maxWithFor = numberExamples::maxWithFor;
        Supplier<Integer> maxWithJ8 = j8NumberExamples::maxWithJ8;
        System.out.println(stopwatch.measureFunctionExecutionTime(sumWithJ8));
        System.out.println(stopwatch.measureFunctionExecutionTime(sumWithFor));
        System.out.println(stopwatch.measureFunctionExecutionTime(maxWithJ8));
        System.out.println(stopwatch.measureFunctionExecutionTime(maxWithFor));
        System.out.println(SEPARATOR);
    }

    private static void executeStringExamples() {
        System.out.println("String examples:");
        StringExamples stringExamples = new StringExamples();
        System.out.println(stringExamples.concatenateStringsWithDelimiter(DELIMITER));
        System.out.println(stringExamples.J8concatenateStringsWithDelimiter(DELIMITER));
        for (String string : stringExamples.upCaseStrings()) {
            System.out.print(string + DELIMITER);
        }
        System.out.println();
        printResults(stringExamples.J8UpCaseStrings());
        printResults(stringExamples.filterStringsLongerThan(STRING_LENGTH_FILTER));
        printResults(stringExamples.J8FilterStringsLongerThan(STRING_LENGTH_FILTER));
        System.out.println(SEPARATOR);
    }

    private static void executeMutabilityExamples() {
        System.out.println("Mutability examples:");
        MutabilityExamples mutabilityExamples = new MutabilityExamples();
        MutableDog mutableDog = mutabilityExamples.getMutableDog();
        MutableDog mutableDog1 = mutabilityExamples.renameDog("mutable");
        System.out.println(mutableDog.getName() + " != " + mutableDog1.getName());
        ImmutableDog immutableDog = mutabilityExamples.getImmutableDog();
        ImmutableDog immutableDog1 = mutabilityExamples.pureRenameDog("immutable");
        System.out.println(immutableDog.getName() + " != " + immutableDog1.getName());
        System.out.println(SEPARATOR);
    }

    private static void executeThreadExamples() throws InterruptedException {
        System.out.println("Thread examples:");
        new MultipleThreadExamples().executeThreadExamples();
        System.out.println(SEPARATOR);
    }

    public static void main(String[] args) throws InterruptedException {
//        executeNumberExamples();
//        executeStringExamples();
//        executeMutabilityExamples();
        executeThreadExamples();
    }


}
