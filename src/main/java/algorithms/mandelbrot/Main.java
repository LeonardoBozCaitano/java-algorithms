package algorithms.mandelbrot;

import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {
        String fileName = "mandelbrot-render.png";
        int resolution = 2000;
        double xCenter = -0.38;
        double yCenter = -0.665;
        int maxIterations = 1000;

        Instant start = Instant.now();
        int threadsNumber = 1;
        System.out.println("Executing mandelbrot with " + threadsNumber + " threads");
        Executor.run(new ExecutorInput(fileName, resolution, xCenter, yCenter, threadsNumber, maxIterations));
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Execution duration: " + timeElapsed.toSeconds() + " seconds");

        start = Instant.now();
        threadsNumber = 4;
        System.out.println("Executing mandelbrot with " + threadsNumber + " threads");
        Executor.run(new ExecutorInput(fileName, resolution, xCenter, yCenter, threadsNumber, maxIterations));
        end = Instant.now();
        timeElapsed = Duration.between(start, end);
        System.out.println("Execution duration: " + timeElapsed.toSeconds() + " seconds");
    }
}
