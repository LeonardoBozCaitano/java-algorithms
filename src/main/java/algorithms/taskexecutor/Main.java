package algorithms.taskexecutor;

import java.util.Arrays;

/**
 * Task Executor
 *
 * Say we have a set of tasks which may have dependency on output from other tasks. Each task accepts some input, does some execution and returns some output.
 *
 * For example
 * Task 1
 * Task 2 depends on Task 1
 * Task 3
 * Task 4 depends on Task 2 and Task 3
 *
 * 1 -Define data structures to represent Task and the Dependencies.
 * 2 - Implement a task executor function which takes a set of tasks as input and executes based on the dependencies.
 *      Each task should be executed only once and would start execution in a separate thread.
 */
public class Main {

    public static void main(String[] args) {
        var task1 = new Task(1);
        var task2 = new Task(2);
        var task3 = new Task(3, Arrays.asList(task2));
        var task4 = new Task(4, Arrays.asList(task2, task3));
        var task5 = new Task(5);
        var task6 = new Task(6, Arrays.asList(task5));
        var task7 = new Task(7, Arrays.asList(task5, task4));

        Chain chain = Chain.builder()
                .chain(task1)
                .chain(task2)
                .chain(task3)
                .chain(task4)
                .chain(task5)
                .chain(task6)
                .chain(task7)
                .build();

        chain.run();
    }
}
