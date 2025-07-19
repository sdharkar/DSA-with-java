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
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import java.util.stream.Stream;

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

        // Problem 6: Find longest string in list
        List<String> stringList = Arrays.asList("java", "python", "javascript", "c++");
        Optional<String> longestString = stringList.stream()
                .max(Comparator.comparing(String::length));
        System.out.println("Find longest string: " + longestString);

        // Problem 7: Check if all strings start with same letter
        List<String> names = Arrays.asList("Alice", "Anna", "Amy", "Andrew");
        boolean allStartWithA = names.stream()
                .allMatch(name -> name.startsWith("A"));
        System.out.println("All strings start with 'A': " + allStartWithA);

        // Problem 8: Find sum of squares of even numbers
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sumOfSquares = numbers2.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                .sum();
        System.out.println("Sum of squares of even numbers: " + sumOfSquares);

        // Problem 9: Group numbers by even/odd
        Map<Boolean, List<Integer>> evenOddGroups = numbers2.stream()
                .collect(partitioningBy(n -> n % 2 == 0));
        System.out.println("Group numbers by even/odd: " + evenOddGroups);

        // Problem 10: Find first element greater than 3
        Optional<Integer> firstGreaterThan3 = numbers2.stream()
                .filter(n -> n > 3)
                .findFirst();
        System.out.println("First element greater than 3: " + firstGreaterThan3);

        // Problem 11: Check if any element is divisible by 5
        boolean hasDivisibleBy5 = numbers2.stream()
                .anyMatch(n -> n % 5 == 0);
        System.out.println("Has element divisible by 5: " + hasDivisibleBy5);

        // Problem 12: Convert list of integers to list of strings
        List<String> stringNumbers = numbers2.stream()
                .map(String::valueOf)
                .collect(toList());
        System.out.println("Convert integers to strings: " + stringNumbers);

        // Problem 13: Find average of numbers
        double average = numbers2.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Average of numbers: " + average);

        // Problem 14: Find distinct characters in a string
        String input = "hello world";
        Set<Character> distinctChars = input.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> ch != ' ')
                .collect(toSet());
        System.out.println("Distinct characters: " + distinctChars);

        // Problem 15: Count vowels in a string
        String text2 = "hello world";
        long vowelCount = text2.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> "aeiouAEIOU".indexOf(ch) != -1)
                .count();
        System.out.println("Vowel count: " + vowelCount);

        // Problem 16: Find all palindromes in a list
        List<String> words2 = Arrays.asList("radar", "hello", "level", "world");
        List<String> palindromes = words2.stream()
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .collect(toList());
        System.out.println("Palindromes: " + palindromes);

        // Problem 17: Find the most frequent element
        List<Integer> numbers3 = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        Optional<Map.Entry<Integer, Long>> mostFrequent = numbers3.stream()
                .collect(groupingBy(n -> n, counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());
        System.out.println("Most frequent element: " + mostFrequent);

        // Problem 18: Check if two lists have common elements
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7);
        boolean hasCommonElements = list1.stream()
                .anyMatch(list2::contains);
        System.out.println("Lists have common elements: " + hasCommonElements);

        // Problem 19: Find all prime numbers in a range
        List<Integer> range = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> primes = range.stream()
                .filter(n -> n > 1 && range.stream()
                        .filter(i -> i > 1 && i < n)
                        .noneMatch(i -> n % i == 0))
                .collect(toList());
        System.out.println("Prime numbers: " + primes);

        // Problem 20: Find the longest word in a sentence
        String sentence = "The quick brown fox jumps over the lazy dog";
        Optional<String> longestWord = Arrays.stream(sentence.split("\\s+"))
                .max(Comparator.comparing(String::length));
        System.out.println("Longest word: " + longestWord);

        // Problem 21: Check if string contains only digits
        String numericString = "12345";
        boolean isNumeric = numericString.chars()
                .allMatch(Character::isDigit);
        System.out.println("String contains only digits: " + isNumeric);

        // Problem 22: Find the first element that starts with a specific letter
        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie", "David");
        Optional<String> firstStartingWithC = names2.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();
        System.out.println("First name starting with 'C': " + firstStartingWithC);

        // Problem 23: Convert list of strings to uppercase and filter by length
        List<String> shortNames = names2.stream()
                .map(String::toUpperCase)
                .filter(name -> name.length() <= 4)
                .collect(toList());
        System.out.println("Short names in uppercase: " + shortNames);

        // Problem 24: Find the sum of all positive numbers
        List<Integer> mixedNumbers = Arrays.asList(-1, 2, -3, 4, -5, 6);
        int sumOfPositives = mixedNumbers.stream()
                .filter(n -> n > 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of positive numbers: " + sumOfPositives);

        // Problem 25: Check if all elements are unique
        boolean allUnique = numbers.stream()
                .distinct()
                .count() == numbers.size();
        System.out.println("All elements are unique: " + allUnique);

        // Problem 26: Find the element with maximum frequency
        List<Integer> freqNumbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        Optional<Integer> maxFreqElement = freqNumbers.stream()
                .collect(groupingBy(n -> n, counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        System.out.println("Element with maximum frequency: " + maxFreqElement);

        // Problem 27: Convert list of integers to their squares and filter even squares
        List<Integer> evenSquares = numbers2.stream()
                .map(n -> n * n)
                .filter(square -> square % 2 == 0)
                .collect(toList());
        System.out.println("Even squares: " + evenSquares);

        // Problem 28: Find the first element that is greater than its index
        List<Integer> indexedNumbers = Arrays.asList(0, 1, 2, 3, 4, 5);
        Optional<Integer> greaterThanIndex = indexedNumbers.stream()
                .filter(n -> n > indexedNumbers.indexOf(n))
                .findFirst();
        System.out.println("First element greater than its index: " + greaterThanIndex);

        // Problem 29: Check if a list is sorted
        List<Integer> sortedList = Arrays.asList(1, 2, 3, 4, 5);
        boolean isSorted = sortedList.stream()
                .sorted()
                .collect(toList())
                .equals(sortedList);
        System.out.println("List is sorted: " + isSorted);

        // Problem 30: Find the difference between max and min values
        List<Integer> rangeNumbers = Arrays.asList(1, 5, 3, 9, 2, 7);
        int rangeValue = rangeNumbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0) - rangeNumbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
        System.out.println("Range (max - min): " + rangeValue);
    }

    // Custom Collector Example
    public static <T> java.util.stream.Collector<T, ?, java.util.List<T>> toSortedList(Comparator<? super T> comparator) {
        return java.util.stream.Collector.of(
                java.util.ArrayList::new,
                java.util.List::add,
                (left, right) -> {
                    left.addAll(right);
                    return left;
                },
                (list) -> {
                    ((java.util.ArrayList<T>) list).sort(comparator);
                    return (java.util.List<T>) list;
                }
        );
    }

    // Infinite Stream with limit
    public static Stream<Integer> fibonacci() {
        return Stream.iterate(
                new int[]{0, 1},
                f -> new int[]{f[1], f[0] + f[1]}
        ).map(f -> f[0]);
    }

    // Partitioning with custom predicate
    public static Map<Boolean, List<Employee>> partitionByExperience(
            List<Employee> employees, int ageThreshold) {
        return employees.stream()
                .collect(partitioningBy(
                        e -> e.age() >= ageThreshold
                ));
    }

    // Employee record for examples
    record Employee(String name, int age, String department, double salary) {}
}
