package com.qa.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamChallenges {

// ToDo A
//        1. Create a list of doubles called nums with the values 2.5, 9.0, 4.3, 7.5, 2.4
//        2. Print the list
//        3. Using the Streams API calculate the average of the list, otherwise return 0.0
//        4. Print the average value

    public static void challenge_1() {
        System.out.println("\n########## Challenge 1");

        // Create a list of doubles
        List<Double> nums = Arrays.asList(2.5, 9.0, 4.3, 7.5, 2.4);
        // Print the list elements
        System.out.println("Original values: " + nums);

        // Calculate the average of the list using a stream
        double average = nums.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        // Print the average
        System.out.println("\nAverage of the original values: " + average);
    }

// ToDo B
//        1. Create a list of ints called nums with the values 64, 33, 82, 95, 70, 12, 17, 41, 96
//        2. Print the list
//        3. Using the Streams API extract only even numbers from the list into a new list
//        4. Print the even numbers
//        5. Using the Streams API extract only odd numbers from the list into a new list
//        6. Print the odd numbers

    public static void challenge_2() {
        System.out.println("\n########## Challenge 2");

        // Create a list of integers
        List<Integer> nums = Arrays.asList(64, 33, 82, 95, 70, 12, 17, 41, 96);

        // Print the original numbers
        System.out.println("Original numbers:");
        nums.forEach(n -> System.out.print(n + " "));

        // Extract even numbers into a new list
        List<Integer> evenNumbers = nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // Print the even numbers
        System.out.println("\n\nEven numbers:");
        evenNumbers.forEach(n -> System.out.print(n + " "));

        // Extract odd numbers into a new list
        List<Integer> oddNumbers = nums.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());

        // Print the odd numbers
        System.out.println("\n\nOdd numbers:");
        oddNumbers.forEach(n -> System.out.print(n + " "));
    }

// ToDo C
//        1. Create a list of ints called nums with the values 64, 33, 82, 95, 70, 82, 70, 41, 33
//        2. Print the list
//        3. Using the Streams API remove duplicates and add the unique values to a new list
//        4. Print the new unique list

    public static void challenge_3() {
        System.out.println("\n########## Challenge 3");

        // Create a list of integers with duplicates
        List<Integer> nums = Arrays.asList(64, 33, 82, 95, 70, 82, 70, 41, 33);
        // Print the list
        System.out.println("Original elements " + nums);

        // Remove duplicates using streams and distinct
        List<Integer> unique_nums = new ArrayList<>();

        nums.stream()
                .distinct()
                .forEach(unique_nums::add);

        // Print the list without duplicates
        System.out.println("\nUnique elements: " + unique_nums);
    }

// ToDo D
//        1. Create a list of ints called nums with the values 10, 15, 0, 6, 11, -3
//        2. Print the list
//        3. Using the Streams API find the highest value in the list
//        4. Using the Streams API find the lowest value in the list
//        5. Print the two values

    public static void challenge_4() {
        System.out.println("\n########## Challenge 4");
        List<Integer> nums = List.of(10, 15, 0, 6, 11, -3);

        System.out.println("Original values: " + nums);

        // Find the highest value
        Optional<Integer> max = nums.stream()
                .max((x, y) -> x.compareTo(y));

        // Find the lowest value
        Optional<Integer> min = nums.stream()
                .min((x, y) -> x.compareTo(y));

        // Print the two values
        System.out.println("Maximum value: " + max.orElse(null));
        System.out.println("Minimum value: " + min.orElse(null));
    }

// ToDo E
//        1. Create a list of Employees called employeeList
//        2. Populate with appropriate sample data for name, age, salary and totalDaysLeave
//        3. Using the Streams API summarize the age statistics
//        4. Using the Streams API summarize the salary statistics
//        5. Using the Streams API summarize the totalDaysLeave statistics
//        6. Experiment with filtering the list by name, age, salary and daysLeave

    public static void challenge_5() {
        System.out.println("\n########## Challenge 5");
        List<Employee> employeeList = List.of(new Employee("Julie Dooley", 50, 49000.00, 245L),
                new Employee("Sally Smith", 31, 35000.00, 82L),
                new Employee("Kamran Khan", 24, 20000.00, 20L),
                new Employee("Jing Zhang", 25, 21500.00, 28L),
                new Employee("Sam Smith", 44, 40000.00, 63L));

        IntSummaryStatistics intSummaryStatistics = employeeList
                .stream()
                .collect(Collectors.summarizingInt(Employee::getAge));
        System.out.println("Age: " + intSummaryStatistics);

        DoubleSummaryStatistics doubleSummaryStatistics = employeeList
                .stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Salary: " + doubleSummaryStatistics);

        LongSummaryStatistics longSummaryStatistics = employeeList
                .stream()
                .collect(Collectors.summarizingLong(Employee::getDaysLeave));
        System.out.println("Leave days: " + longSummaryStatistics);

        List<Employee> namesContainS = employeeList.stream()
                .filter(e -> e.getName().toLowerCase().contains("s"))
                .collect(Collectors.toList());
        System.out.println("Name contains 's': ");
        namesContainS.forEach(e -> System.out.println(e.getName()));

        List<Employee> daysLeaveGreaterThan50 = employeeList.stream()
                .filter(e -> e.getDaysLeave() > 50)
                .collect(Collectors.toList());
        System.out.println("Days Leave Greater Than 50: ");
        daysLeaveGreaterThan50.forEach(e -> System.out.println(e.getName() + " " + e.getDaysLeave()));
    }

// ToDo F
//        1. Do further research on the Streams API
//        2. Create examples to consolidate and demonstrate your understanding
//        3. Suggestions: peek, limit, count, takeWhile, skip, findAny, findFirst, reduce
}
