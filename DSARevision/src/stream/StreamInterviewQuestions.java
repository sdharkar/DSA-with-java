package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class StreamInterviewQuestions {

    public static void main(String[] args) {

        //Problem 1: Find duplicate elements
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 6);
        Set<Integer> duplicates = numbers.stream()
                .filter(n -> Collections.frequency(numbers, n) > 1)
                .collect(toSet());
        System.out.println("Find duplicate elements: " + duplicates);

        //Problem 2: Find first non-repeated character
        String text = "streaming";
        Optional<Character> firstNonRepeated = text.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> text.chars().filter(c -> c == ch).count() == 1)
                .findFirst();
        System.out.println("Find first non-repeated character: " + firstNonRepeated);

        //Problem 3: Check if array contains only odd numbers
        int[] nums = {1, 3, 5, 7};
        boolean allOdd = Arrays.stream(nums)
                .allMatch(n -> n % 2 != 0);
        System.out.println("Check if array contains only odd numbers: " + allOdd);

        //Problem 4: Find second highest number
        Optional<Integer> secondHignest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println("Find second highest number: " + secondHignest);

        //Problem 5: String frequency count
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry");
        Map<String, Long> frequency = words.stream()
                .collect(groupingBy(
                        String::toString,
                        counting()
                ));
        System.out.println("String frequency count: " + frequency);
    //     //Problem 6: Custom Collector
    // public static <T> Collector<T, ?, List<T>> toSortedList(Comparator<? super T> comparator) {
    //     return Collector.of(
    //             ArrayList::new,
    //             List::add,
    //             (left, right) -> {
    //                 left.addAll(right);
    //                 return left;
    //             },
    //             (list) -> {
    //                 ((ArrayList<T>) list).sort(comparator);
    //                 return (List<T>) list;
    //             }
    //     );
    // }

    // // Problem 7: Infinite Stream with limit
    // public static Stream<Integer> fibonacci() {
    //     return Stream.iterate(
    //             new int[]{0, 1},
    //             f -> new int[]{f[1], f[0] + f[1]}
    //     ).map(f -> f[0]);
    // }

    // // Problem 8: Partitioning with custom predicate
    // public static Map<Boolean, List<Employee>> partitionByExperience(
    //         List<Employee> employees, int ageThreshold) {
    //     return employees.stream()
    //             .collect(partitioningBy(
    //                     e -> e.age() >= ageThreshold
    //             ));
    // }
    }
}
