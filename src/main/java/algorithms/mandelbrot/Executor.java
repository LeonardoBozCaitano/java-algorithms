package algorithms.mandelbrot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Executor {

    // image Attributes
    private static final int WIDTH = 1980;
    private static final int HEIGHT = 1020;
    private static final double RADIUS = 3.14;
    private static final double DIVERGENCE = RADIUS * RADIUS;
    private static final int X_OFFSET = -(WIDTH - 1)/2;
    private static final int Y_OFFSET = (HEIGHT - 1)/2;
    private static final int BLACK = 0;

    public static void run(ExecutorInput input) {
        int[] colorPallet = creatingColorPallet(input);

        BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        File out = new File(input.getFilename());

        Thread[] threads = new Thread[input.getThreadsNumber()];
        for (int thread = 0; thread < input.getThreadsNumber(); thread++) {
            int threadNumber = thread + 1;
            threads[thread] = new Thread(() -> calculate(input, colorPallet, img, threadNumber));
            threads[thread].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (Exception e) {
                System.out.println("Error.");
            }
        }

        try {
            ImageIO.write(img, "png", out);
            System.out.println("File written.");
        } catch (Exception e) {
            System.out.println("Error.");
        }
    }

    private static int[] creatingColorPallet(ExecutorInput input) {
        int[] colorPalette = new int[input.getMaxIterations()];
        for (int i = 0; i < input.getMaxIterations(); i++) {
            colorPalette[i] = input.getColor();
        }
        return colorPalette;
    }

    private static void calculate(ExecutorInput input, int[] colorPallet, BufferedImage img, int thread) {
        int iteration, point;
        double a, b, aOld, x, y;

        var batchSize = HEIGHT / input.getThreadsNumber();
        var batchEnd = (batchSize * thread);
        var batchStart = batchEnd - batchSize;

        System.out.println("CalculationThread " + thread + " - start index: " + batchStart + " and final index: " + batchEnd + " -- batch size: " + batchSize);
        for (int r = batchStart; r < batchEnd; r++) {
            for (int c = 0; c < WIDTH; c++)
            {
                x = input.getXCenter() + (X_OFFSET + c)
                        / input.getResolution();
                y = input.getYCenter() + (Y_OFFSET - r)
                        / input.getResolution();

                iteration = 0;
                a = x;
                b = y;

                while (a*a + b*b <= DIVERGENCE && iteration < input.getMaxIterations())
                {
                    aOld = a;
                    a = a*a - b*b + x;

                    b = 2*aOld*b + y;
                    iteration ++;
                }

                if (iteration == input.getMaxIterations())
                    point = BLACK;
                else {
                    point = colorPallet[iteration];
                }

                img.setRGB(c, r, point);
            }
        }
    }
}
