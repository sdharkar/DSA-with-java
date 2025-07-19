# Stream API Interview Questions

This directory contains comprehensive Stream API interview questions and solutions for Java developers preparing for technical interviews.

## Files Overview

### 1. StreamInterviewQuestions.java
Contains 30 basic to intermediate Stream API interview questions covering:
- Basic stream operations (filter, map, reduce)
- String manipulation with streams
- Number processing and calculations
- Collection operations
- Custom collectors and infinite streams

### 2. AdvancedStreamQuestions.java
Contains 25 advanced Stream API interview questions covering:
- Complex grouping and partitioning
- Custom collectors and statistics
- Stream concatenation and infinite streams
- Multi-level data processing
- Performance optimization techniques

### 3. StreamAPIGuide.java
Contains theoretical concepts and practical examples covering:
- Stream API fundamentals
- Intermediate and terminal operations
- Common use cases and patterns
- Employee and product data processing examples

## Key Stream API Concepts

### Stream Operations Categories

#### 1. Intermediate Operations (Lazy Evaluation)
- `filter()` - Filters elements based on a predicate
- `map()` - Transforms elements using given function
- `flatMap()` - Transforms and flattens elements
- `sorted()` - Sorts elements
- `distinct()` - Removes duplicates
- `limit()` - Limits stream to n elements
- `skip()` - Skips n elements

#### 2. Terminal Operations (Eager Evaluation)
- `collect()` - Collects stream elements into a collection
- `forEach()` - Iterates through each element
- `reduce()` - Reduces stream to single value
- `count()` - Returns count of elements
- `min()/max()` - Returns min/max element
- `anyMatch()/allMatch()/noneMatch()` - Returns boolean based on conditions

## Common Interview Questions Covered

### Basic Level
1. **Find duplicate elements** - Using frequency and filter
2. **Find first non-repeated character** - Using chars() and filter
3. **Check if array contains only odd numbers** - Using allMatch
4. **Find second highest number** - Using distinct, sorted, and skip
5. **String frequency count** - Using groupingBy and counting

### Intermediate Level
6. **Find longest string** - Using max with Comparator
7. **Check if all strings start with same letter** - Using allMatch
8. **Sum of squares of even numbers** - Using filter, mapToInt, and sum
9. **Group numbers by even/odd** - Using partitioningBy
10. **Find first element greater than threshold** - Using filter and findFirst

### Advanced Level
11. **Custom collectors** - Implementing custom Collector interface
12. **Infinite streams** - Using Stream.iterate and Stream.generate
13. **Complex grouping** - Multi-level grouping with downstream collectors
14. **Stream concatenation** - Using Stream.concat
15. **Custom statistics** - Using collectingAndThen with custom logic

## Important Stream API Patterns

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

## Performance Considerations

### 1. Lazy Evaluation
- Intermediate operations are lazy and only executed when terminal operation is called
- Use this to optimize performance by chaining operations

### 2. Parallel Streams
- Use `parallelStream()` for large datasets
- Be careful with stateful operations and ordering

### 3. Short-circuit Operations
- `findFirst()`, `findAny()`, `anyMatch()`, `allMatch()`, `noneMatch()`
- Stop processing as soon as result is determined

### 4. Collector Optimization
- Use appropriate collectors for your use case
- Consider custom collectors for complex operations

## Common Pitfalls to Avoid

1. **Multiple terminal operations** - Stream can only be consumed once
2. **Stateful operations in parallel streams** - Can cause unpredictable results
3. **Infinite streams without limit** - Can cause infinite loops
4. **Modifying source collection** - Can cause ConcurrentModificationException
5. **Not handling Optional properly** - Always check if Optional is present

## Interview Tips

### 1. Understand the Problem
- Read the question carefully
- Identify input and expected output
- Consider edge cases

### 2. Choose the Right Operations
- Use `filter()` for conditional filtering
- Use `map()` for transformations
- Use `reduce()` for aggregations
- Use `collect()` for collecting results

### 3. Consider Performance
- Use appropriate stream operations
- Consider parallel streams for large datasets
- Avoid unnecessary operations

### 4. Test Your Solution
- Test with different inputs
- Consider edge cases (empty lists, null values)
- Verify the output

## Running the Examples

To run the examples:

```bash
# Compile
javac -d bin src/stream/*.java

# Run basic questions
java -cp bin stream.StreamInterviewQuestions

# Run advanced questions
java -cp bin stream.AdvancedStreamQuestions

# Run guide
java -cp bin stream.StreamAPIGuide
```

## Additional Resources

1. **Official Documentation**: Java Stream API documentation
2. **Practice Platforms**: LeetCode, HackerRank, CodeSignal
3. **Books**: "Effective Java" by Joshua Bloch
4. **Online Courses**: Java 8 Streams on various platforms

## Common Interview Questions by Topic

### String Processing
- Find first non-repeated character
- Count vowels/consonants
- Check if string is palindrome
- Find longest word in sentence
- Convert case and filter

### Number Processing
- Find sum/average/max/min
- Filter even/odd numbers
- Find prime numbers
- Calculate squares/cubes
- Find second highest/lowest

### Collection Operations
- Find duplicates
- Remove duplicates
- Group by criteria
- Partition by condition
- Sort and limit

### Custom Objects
- Group by multiple fields
- Sort by multiple criteria
- Calculate statistics
- Filter by complex conditions
- Transform object properties

This comprehensive guide should help you prepare for Stream API related interview questions effectively! 