package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdvancedStreamQuestions {

    public static void main(String[] args) {
        
        // Problem 1: Custom Collector - Group by multiple criteria
        List<Student> students = Arrays.asList(
            new Student("Alice", "CS", 85, "A"),
            new Student("Bob", "CS", 90, "A"),
            new Student("Charlie", "Math", 75, "B"),
            new Student("David", "Math", 80, "B"),
            new Student("Eve", "CS", 95, "A")
        );

        // Group by department and grade
        Map<String, Map<String, List<Student>>> groupedByDeptAndGrade = students.stream()
            .collect(Collectors.groupingBy(
                Student::getDepartment,
                Collectors.groupingBy(Student::getGrade)
            ));
        System.out.println("Grouped by department and grade: " + groupedByDeptAndGrade);

        // Problem 2: Complex filtering with multiple conditions
        List<Student> topStudents = students.stream()
            .filter(s -> s.getScore() >= 85)
            .filter(s -> "A".equals(s.getGrade()))
            .filter(s -> "CS".equals(s.getDepartment()))
            .collect(Collectors.toList());
        System.out.println("Top CS students with A grade: " + topStudents);

        // Problem 3: Custom sorting with multiple comparators
        List<Student> sortedStudents = students.stream()
            .sorted(Comparator.comparing(Student::getDepartment)
                .thenComparing(Student::getScore).reversed()
                .thenComparing(Student::getName))
            .collect(Collectors.toList());
        System.out.println("Sorted students: " + sortedStudents);

        // Problem 4: Stream concatenation
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> combined = Stream.concat(list1.stream(), list2.stream())
            .collect(Collectors.toList());
        System.out.println("Combined lists: " + combined);

        // Problem 5: Infinite stream with custom logic
        List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
            .limit(10)
            .map(f -> f[0])
            .collect(Collectors.toList());
        System.out.println("Fibonacci sequence: " + fibonacci);

        // Problem 6: Complex reduction with custom accumulator
        String concatenatedNames = students.stream()
            .map(Student::getName)
            .reduce("", (acc, name) -> acc.isEmpty() ? name : acc + ", " + name);
        System.out.println("Concatenated names: " + concatenatedNames);

        // Problem 7: Partitioning with complex predicate
        Map<Boolean, List<Student>> partitioned = students.stream()
            .collect(Collectors.partitioningBy(s -> s.getScore() >= 80));
        System.out.println("Partitioned by score >= 80: " + partitioned);

        // Problem 8: Custom collector for statistics
        StudentStats stats = students.stream()
            .collect(Collectors.collectingAndThen(
                Collectors.groupingBy(Student::getDepartment),
                map -> {
                    Map<String, DoubleSummaryStatistics> deptStats = new HashMap<>();
                    map.forEach((dept, studentList) -> {
                        DoubleSummaryStatistics summary = studentList.stream()
                            .mapToDouble(Student::getScore)
                            .summaryStatistics();
                        deptStats.put(dept, summary);
                    });
                    return new StudentStats(deptStats);
                }
            ));
        System.out.println("Department statistics: " + stats);

        // Problem 9: Stream with custom supplier and accumulator
        List<Integer> customStream = Stream.generate(() -> new Random().nextInt(100))
            .limit(5)
            .collect(Collectors.toList());
        System.out.println("Random numbers: " + customStream);

        // Problem 10: Complex mapping with flatMap
        List<String> allCharacters = students.stream()
            .map(Student::getName)
            .flatMap(name -> name.chars().mapToObj(ch -> String.valueOf((char) ch)))
            .distinct()
            .collect(Collectors.toList());
        System.out.println("All unique characters in names: " + allCharacters);

        // Problem 11: Stream with custom comparator and max
        Optional<Student> highestScorer = students.stream()
            .max(Comparator.comparing(Student::getScore)
                .thenComparing(Student::getName));
        System.out.println("Highest scorer: " + highestScorer);

        // Problem 12: Complex grouping with downstream collector
        Map<String, Long> deptCounts = students.stream()
            .collect(Collectors.groupingBy(
                Student::getDepartment,
                Collectors.counting()
            ));
        System.out.println("Department counts: " + deptCounts);

        // Problem 13: Stream with custom predicate and anyMatch
        boolean hasPerfectScore = students.stream()
            .anyMatch(s -> s.getScore() == 100);
        System.out.println("Has perfect score: " + hasPerfectScore);

        // Problem 14: Complex filtering with noneMatch
        boolean allPassed = students.stream()
            .noneMatch(s -> s.getScore() < 60);
        System.out.println("All students passed: " + allPassed);

        // Problem 15: Stream with custom function composition
        List<String> formattedNames = students.stream()
            .map(Student::getName)
            .map(String::toUpperCase)
            .map(name -> "Student: " + name)
            .collect(Collectors.toList());
        System.out.println("Formatted names: " + formattedNames);

        // Problem 16: Stream with custom collector for joining
        String joinedNames = students.stream()
            .map(Student::getName)
            .collect(Collectors.joining(" | ", "[", "]"));
        System.out.println("Joined names: " + joinedNames);

        // Problem 17: Stream with custom toMap collector
        Map<String, Integer> nameToScore = students.stream()
            .collect(Collectors.toMap(
                Student::getName,
                Student::getScore,
                (existing, replacement) -> Math.max(existing, replacement)
            ));
        System.out.println("Name to score mapping: " + nameToScore);

        // Problem 18: Stream with custom reducing
        Optional<Student> bestStudent = students.stream()
            .reduce((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2);
        System.out.println("Best student: " + bestStudent);

        // Problem 19: Stream with custom filtering and mapping
        List<String> highScorerNames = students.stream()
            .filter(s -> s.getScore() >= 85)
            .map(Student::getName)
            .sorted()
            .collect(Collectors.toList());
        System.out.println("High scorer names: " + highScorerNames);

        // Problem 20: Stream with custom collector for statistics
        DoubleSummaryStatistics scoreStats = students.stream()
            .mapToDouble(Student::getScore)
            .summaryStatistics();
        System.out.println("Score statistics: " + scoreStats);

        // Problem 21: Stream with custom partitioning and counting
        Map<Boolean, Long> passFailCount = students.stream()
            .collect(Collectors.partitioningBy(
                s -> s.getScore() >= 70,
                Collectors.counting()
            ));
        System.out.println("Pass/Fail count: " + passFailCount);

        // Problem 22: Stream with custom grouping and averaging
        Map<String, Double> deptAverages = students.stream()
            .collect(Collectors.groupingBy(
                Student::getDepartment,
                Collectors.averagingDouble(Student::getScore)
            ));
        System.out.println("Department averages: " + deptAverages);

        // Problem 23: Stream with custom filtering and collecting
        List<Student> topPerformers = students.stream()
            .filter(s -> s.getScore() >= 90)
            .sorted(Comparator.comparing(Student::getScore).reversed())
            .limit(3)
            .collect(Collectors.toList());
        System.out.println("Top 3 performers: " + topPerformers);

        // Problem 24: Stream with custom mapping and filtering
        List<String> longNames = students.stream()
            .map(Student::getName)
            .filter(name -> name.length() > 4)
            .collect(Collectors.toList());
        System.out.println("Long names: " + longNames);

        // Problem 25: Stream with custom collector for multiple statistics
        Map<String, Object> comprehensiveStats = students.stream()
            .collect(Collectors.groupingBy(
                Student::getDepartment,
                Collectors.collectingAndThen(
                    Collectors.mapping(Student::getScore, Collectors.toList()),
                    scores -> {
                        Map<String, Object> deptStats = new HashMap<>();
                        deptStats.put("count", scores.size());
                        deptStats.put("average", scores.stream().mapToDouble(Integer::doubleValue).average().orElse(0));
                        deptStats.put("max", scores.stream().mapToInt(Integer::intValue).max().orElse(0));
                        deptStats.put("min", scores.stream().mapToInt(Integer::intValue).min().orElse(0));
                        return deptStats;
                    }
                )
            ));
        System.out.println("Comprehensive department stats: " + comprehensiveStats);
    }

    // Custom classes for examples
    static class Student {
        private String name;
        private String department;
        private int score;
        private String grade;

        public Student(String name, String department, int score, String grade) {
            this.name = name;
            this.department = department;
            this.score = score;
            this.grade = grade;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public int getScore() { return score; }
        public String getGrade() { return grade; }

        @Override
        public String toString() {
            return name + "(" + score + ")";
        }
    }

    static class StudentStats {
        private Map<String, DoubleSummaryStatistics> departmentStats;

        public StudentStats(Map<String, DoubleSummaryStatistics> departmentStats) {
            this.departmentStats = departmentStats;
        }

        @Override
        public String toString() {
            return departmentStats.toString();
        }
    }
} 