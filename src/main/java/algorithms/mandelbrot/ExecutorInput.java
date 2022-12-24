package algorithms.mandelbrot;

import lombok.Data;

@Data
public class ExecutorInput {

    private final String filename;
    private final double resolution;
    private final double xCenter;
    private final double yCenter;
    private final int threadsNumber;
    private final int maxIterations;
    private int color;

    public ExecutorInput(String filename, double resolution, double xCenter, double yCenter, int threadsNumber, int maxIterations) {
        this.filename = filename;
        this.resolution = resolution;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.threadsNumber = threadsNumber;
        this.maxIterations = maxIterations;
        this.color = calculateColor(maxIterations);
    }

    private int calculateColor(int i) {
        int a = (int) (255 * ((double) i) / (maxIterations / 4));
        return ((0) | (2*a<<2) | (a<<8) | ((a*2)<<0));
    }
}
