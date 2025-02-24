package stream;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

//Stream theory:
/*
Stream API was introduced in Java 8 to process collections of objects.
A stream is a sequence of objects that supports various methods which can 
be pipelined to produce the desired result.

Key Characteristics:
1. Not a data structure - Streams don't store data, they operate on the source
2. Functional in nature - Operations on stream don't modify source
3. Lazy evaluation - Computation on source data is only performed when necessary
4. Possibly unbounded - While collections have finite size, streams can be infinite
5. Consumable - Elements of a stream are only visited once during the life of a stream

Stream Operations Categories:
1. Intermediate Operations:
   - filter(): Filters elements based on a predicate
   - map(): Transforms elements using given function
   - flatMap(): Transforms and flattens elements
   - sorted(): Sorts elements
   - distinct(): Removes duplicates
   - limit(): Limits stream to n elements
   - skip(): Skips n elements

2. Terminal Operations:
   - collect(): Collects stream elements into a collection
   - forEach(): Iterates through each element
   - reduce(): Reduces stream to single value
   - count(): Returns count of elements
   - min()/max(): Returns min/max element
   - anyMatch()/allMatch()/noneMatch(): Returns boolean based on conditions

Common Use Cases:
- Filtering collections
- Transforming collections
- Calculating aggregations
- Grouping data
- Finding elements
*/

public class StreamAPIGuide {

    record Employee(String name, int age, String department, double salary){} 
    record Product(String name, double price, String category){}

    public static void main(String[] args) {

        List<Employee> employees = List.of(
            new Employee("John", 30, "IT", 75000),
            new Employee("Alice", 25, "HR", 60000),
            new Employee("Bob", 35, "IT", 85000),
            new Employee("Carol", 28, "Finance", 70000)
        );

        List<Product> products = List.of(
            new Product("Laptop", 1200, "Electronics"),
            new Product("Phone", 800, "Electronics"),
            new Product("Desk", 300, "Furniture")
        );

        //1. Basic Stream Operations
        //Problem: Find all employees in IT department with salary > 80000
        List<Employee> highPaidIT = employees.stream()
        .filter(e -> e.department().equals("IT"))
        .filter(e -> e.salary() > 80000)
        .collect(toList());
        System.out.println("Find all employees in IT department with salary > 80000: "+ highPaidIT);

        //2.Map operation
        //Problem: Get list of employee name in uppercase
        List<String> upperNames = employees.stream()
            .map(Employee::name)
            .map(String::toUpperCase)
            .collect(toList());
        System.out.println("Get list of employee name in uppercase: "+ upperNames);

        //3.FlatMap Operation
        //Problem: Get all unique characters from employee names
        Set<Character> uniqueChars = employees.stream()
            .map(Employee::name)
            .flatMap(name -> name.chars().mapToObj(c -> (char)c))
            .collect(Collectors.toSet());
        System.out.println("Get all unique characters from employee names: " + uniqueChars);

        //4.Reduce Operation
        //Problem: Calculate total salary
        double totalSalary = employees.stream()
            .map(Employee::salary)
            .reduce(0.0, Double::sum);
        System.out.println("Calculate total salary: "+ totalSalary);

        //5.Collect operation
        //Problem: Group employees by department
        Map<String, List<Employee>> byDepartment = employees.stream()
            .collect(groupingBy(Employee::department)); 
        System.out.println("Group employees by department: "+ byDepartment);

        //6.Numeric Stream
        //Problem: Get statictics of employee ages
        IntSummaryStatistics ageStats = employees.stream()
            .mapToInt(Employee::age)
            .summaryStatistics();
        System.out.println("Get statictics of employee ages: "+ ageStats);

        //7.Parallel Stream
        // Problem: Process large dataset in parallel
        double totalSalaryParallel = employees.parallelStream()
            .mapToDouble(Employee::salary)
            .sum();
        System.out.println("Process large dataset in parallel: "+ totalSalaryParallel);

        //8.Optional with Streams
        // Problem: Find youngest employee in IT
        Optional<Employee> youngestIT = employees.stream()
            .filter(e -> e.department().equals("IT"))
            .min(Comparator.comparing(Employee::age));
        System.out.println("Find youngest employee in IT: " + youngestIT);

        // 9. Complex Operations
        // Problem: Get department with highest average salary
        Map.Entry<String, Double> highestPaidDept = employees.stream()
            .collect(groupingBy(
                Employee::department,
                averagingDouble(Employee::salary)
            ))  // Added closing parenthesis for groupingBy
            .entrySet().stream()
            .max(Map.Entry.comparingByValue())
            .orElse(null);
            System.out.println("Get department with highest average salary: "+ highestPaidDept);

        //10. Multiple collector
        //Problem: Get count and average salary by department
        Map<String, Map<String, Double>> deptStats = employees.stream()
            .collect(groupingBy(
                Employee::department,
                Collectors.mapping(Employee::salary,
                    Collectors.collectingAndThen(
                        Collectors.teeing(
                            Collectors.counting(),
                            Collectors.averagingDouble(Double::doubleValue),
                            (Long count, Double avg) -> Map.of(
                                "count", (double) count,
                                "average", avg
                            )
                        ),
                        stats -> stats
                    )
                )
            ));

        System.out.println("Get count and average salary by department: "+ deptStats);



    }

}

