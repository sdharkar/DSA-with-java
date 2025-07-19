# Stream API Interview Questions - Quick Reference

## Basic Level Questions (StreamInterviewQuestions.java)

### String Processing
1. **Find first non-repeated character** - `chars().mapToObj().filter().findFirst()`
2. **Count vowels in a string** - `chars().mapToObj().filter().count()`
3. **Find distinct characters** - `chars().mapToObj().filter().collect(toSet())`
4. **Check if string contains only digits** - `chars().allMatch(Character::isDigit)`
5. **Find longest word in sentence** - `split().stream().max(Comparator.comparing(String::length))`
6. **Find all palindromes** - `filter(word -> word.equals(new StringBuilder(word).reverse().toString()))`

### Number Processing
7. **Check if array contains only odd numbers** - `allMatch(n -> n % 2 != 0)`
8. **Find second highest number** - `distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst()`
9. **Sum of squares of even numbers** - `filter(n -> n % 2 == 0).mapToInt(n -> n * n).sum()`
10. **Find average of numbers** - `mapToInt(Integer::intValue).average().orElse(0.0)`
11. **Find sum of all positive numbers** - `filter(n -> n > 0).mapToInt(Integer::intValue).sum()`
12. **Find the difference between max and min values** - `mapToInt().max().orElse(0) - mapToInt().min().orElse(0)`

### Collection Operations
13. **Find duplicate elements** - `filter(n -> Collections.frequency(numbers, n) > 1).collect(toSet())`
14. **Group numbers by even/odd** - `collect(partitioningBy(n -> n % 2 == 0))`
15. **Convert list of integers to strings** - `map(String::valueOf).collect(toList())`
16. **Check if all elements are unique** - `distinct().count() == numbers.size()`
17. **Check if a list is sorted** - `sorted().collect(toList()).equals(sortedList)`

### Finding and Filtering
18. **Find first element greater than threshold** - `filter(n -> n > 3).findFirst()`
19. **Check if any element is divisible by 5** - `anyMatch(n -> n % 5 == 0)`
20. **Find longest string in list** - `max(Comparator.comparing(String::length))`
21. **Check if all strings start with same letter** - `allMatch(name -> name.startsWith("A"))`
22. **Find the first element that starts with specific letter** - `filter(name -> name.startsWith("C")).findFirst()`

### Frequency and Statistics
23. **String frequency count** - `collect(groupingBy(String::toString, counting()))`
24. **Find the most frequent element** - `collect(groupingBy(n -> n, counting())).entrySet().stream().max(Map.Entry.comparingByValue())`
25. **Find the element with maximum frequency** - `collect(groupingBy(n -> n, counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)`

### Advanced Basic Operations
26. **Convert list of strings to uppercase and filter by length** - `map(String::toUpperCase).filter(name -> name.length() <= 4).collect(toList())`
27. **Convert list of integers to squares and filter even squares** - `map(n -> n * n).filter(square -> square % 2 == 0).collect(toList())`
28. **Find the first element that is greater than its index** - `filter(n -> n > indexedNumbers.indexOf(n)).findFirst()`
29. **Check if two lists have common elements** - `anyMatch(list2::contains)`
30. **Find all prime numbers in a range** - `filter(n -> n > 1 && range.stream().filter(i -> i > 1 && i < n).noneMatch(i -> n % i == 0))`

## Advanced Level Questions (AdvancedStreamQuestions.java)

### Complex Grouping and Partitioning
1. **Group by multiple criteria** - `collect(groupingBy(Student::getDepartment, Collectors.groupingBy(Student::getGrade)))`
2. **Complex filtering with multiple conditions** - Multiple `filter()` operations chained
3. **Custom sorting with multiple comparators** - `sorted(Comparator.comparing().thenComparing().reversed())`
4. **Partitioning with complex predicate** - `collect(partitioningBy(s -> s.getScore() >= 80))`

### Stream Operations
5. **Stream concatenation** - `Stream.concat(list1.stream(), list2.stream())`
6. **Infinite stream with custom logic** - `Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})`
7. **Complex reduction with custom accumulator** - `reduce("", (acc, name) -> acc.isEmpty() ? name : acc + ", " + name)`
8. **Stream with custom supplier and accumulator** - `Stream.generate(() -> new Random().nextInt(100))`

### Custom Collectors and Statistics
9. **Custom collector for statistics** - `collect(collectingAndThen(groupingBy(), map -> customLogic))`
10. **Complex mapping with flatMap** - `flatMap(name -> name.chars().mapToObj(ch -> String.valueOf((char) ch)))`
11. **Stream with custom comparator and max** - `max(Comparator.comparing(Student::getScore).thenComparing(Student::getName))`
12. **Complex grouping with downstream collector** - `collect(groupingBy(Student::getDepartment, Collectors.counting()))`

### Advanced Matching and Filtering
13. **Stream with custom predicate and anyMatch** - `anyMatch(s -> s.getScore() == 100)`
14. **Complex filtering with noneMatch** - `noneMatch(s -> s.getScore() < 60)`
15. **Stream with custom function composition** - Multiple `map()` operations chained

### Advanced Collectors
16. **Stream with custom collector for joining** - `collect(joining(" | ", "[", "]"))`
17. **Stream with custom toMap collector** - `collect(toMap(Student::getName, Student::getScore, (existing, replacement) -> Math.max(existing, replacement)))`
18. **Stream with custom reducing** - `reduce((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2)`

### Performance and Optimization
19. **Stream with custom filtering and mapping** - `filter(s -> s.getScore() >= 85).map(Student::getName).sorted().collect(toList())`
20. **Stream with custom collector for statistics** - `mapToDouble(Student::getScore).summaryStatistics()`
21. **Stream with custom partitioning and counting** - `collect(partitioningBy(s -> s.getScore() >= 70, Collectors.counting()))`
22. **Stream with custom grouping and averaging** - `collect(groupingBy(Student::getDepartment, Collectors.averagingDouble(Student::getScore)))`

### Complex Data Processing
23. **Stream with custom filtering and collecting** - `filter(s -> s.getScore() >= 90).sorted(Comparator.comparing(Student::getScore).reversed()).limit(3)`
24. **Stream with custom mapping and filtering** - `map(Student::getName).filter(name -> name.length() > 4).collect(toList())`
25. **Stream with custom collector for multiple statistics** - Complex `collectingAndThen` with custom statistics calculation

## Key Patterns to Remember

### 1. Filter-Map-Collect Pattern
```java
List<String> result = list.stream()
    .filter(condition)
    .map(transformation)
    .collect(Collectors.toList());
```

### 2. Grouping Pattern
```java
Map<K, List<T>> grouped = list.stream()
    .collect(Collectors.groupingBy(classifier));
```

### 3. Partitioning Pattern
```java
Map<Boolean, List<T>> partitioned = list.stream()
    .collect(Collectors.partitioningBy(predicate));
```

### 4. Reduction Pattern
```java
Optional<T> result = list.stream()
    .reduce((a, b) -> operation(a, b));
```

### 5. Statistics Pattern
```java
DoubleSummaryStatistics stats = list.stream()
    .mapToDouble(mapper)
    .summaryStatistics();
```

## Common Interview Topics

### String Operations
- Character counting and filtering
- Palindrome detection
- Case conversion
- Word processing

### Number Operations
- Sum, average, min, max calculations
- Even/odd filtering
- Prime number detection
- Mathematical transformations

### Collection Operations
- Duplicate detection and removal
- Grouping and partitioning
- Sorting and limiting
- Type conversions

### Custom Objects
- Multi-field grouping
- Complex sorting
- Statistics calculation
- Property transformations

### Performance Considerations
- Lazy evaluation
- Short-circuit operations
- Parallel streams
- Custom collectors

This summary provides a quick reference for all Stream API interview questions covered in the codebase! 