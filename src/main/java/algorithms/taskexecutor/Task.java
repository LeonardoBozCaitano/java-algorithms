package algorithms.taskexecutor;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class Task extends Thread {

    private int taskNumber;
    private int output;
    private List<Task> taskDependencies;

    public Task(int number) {
        taskNumber = number;
        taskDependencies = new ArrayList<>();
    }

    public Task(int number, List<Task> dependencies) {
        taskNumber = number;
        taskDependencies = dependencies;
    }

    public void run() {
        try {
            output = taskNumber;
            if (!taskDependencies.isEmpty()) {
                for (var dependency : taskDependencies) {
                    dependency.join();
                    output = output + dependency.getOutput();
                }
            }

            Thread.sleep(1000);
            System.out.println("Task = " + taskNumber + " - With value = " + output);
        } catch (Exception e) {
            System.out.println("Error on Task = " + taskNumber);
            System.out.println(e.getLocalizedMessage());
        }
    }
}