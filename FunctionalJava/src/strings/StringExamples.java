package strings;

import java.util.*;
import java.util.stream.Collectors;

public class StringExamples {

    private List<String> strings = Arrays.asList("hello", "functional", "world", "!", "hello");

    public String concatenateStringsWithDelimiter(String delimiter) {
        String concatenatedString = strings.get(0);
        for (int i = 1; i < strings.size(); i++) {
            concatenatedString += delimiter + strings.get(i);
        }
        return concatenatedString;
    }

    public String J8concatenateStringsWithDelimiter(String delimiter) {
        return strings.stream()
                .reduce((s1, s2) -> s1 + delimiter + s2)
                .get();
    }

    public Set<String> upCaseStrings() {
        Set<String> upCasedStrings = new HashSet<>();
        for (String string : strings) {
            upCasedStrings.add(string.toUpperCase());
        }
        return upCasedStrings;
    }

    public Set<String> J8UpCaseStrings() {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }

    public List<String> filterStringsLongerThan(int length) {
        List<String> filteredStrings = new ArrayList<>();
        for (String string : strings) {
            if(string.length() > length) {
                filteredStrings.add(string);
            }
        }
        return filteredStrings;
    }

    public List<String> J8FilterStringsLongerThan(int length) {
        return strings.stream()
                .filter(s -> s.length() > length)
                .collect(Collectors.toList());
    }

}
