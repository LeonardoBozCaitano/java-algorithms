package algorithms.taskexecutor;

import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder
public class Chain {
    @Singular
    public List<Task> chains;

    void run() {
        for (var task : chains) {
            task.start();
        }
    }
}