package part.lesson;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class GameOfLifeThreads {
    final private int LENGTH;
    final private int WIDTH;
    final private int STEPS;
    boolean[][] field;
    boolean[][] safeFieldThread1;
    boolean[][] safeFieldThread2;

    private static final CyclicBarrier BARRIER = new CyclicBarrier(2);
    Thread thread1 = new Thread(() -> generationStepThread1());
    Thread thread2 = new Thread(() -> generationStepThread2());


    public GameOfLifeThreads(int LENGTH, int WIDTH, int STEPS, boolean[][] field) {
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
        this.STEPS = STEPS;
        this.field = field;
    }

    public void main() {
        thread1.start();
        thread2.start();

    }


    public void generationStepThread1() {
        for (int l = 0; l < STEPS; l++) {
            safeFieldThread1 = field;
            for (int i = 0; i < LENGTH; i += 2) {
                for (int j = 0; j < WIDTH; j++) {
                    if (field[i][j] && (findNeighbor(i, j) > 3 || findNeighbor(i, j) < 2)) {
                        safeFieldThread1[i][j] = false;
                    } else if (!field[i][j] && findNeighbor(i, j) > 2) {
                        safeFieldThread1[i][j] = true;
                    }
                }
            }
            try {
                BARRIER.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < LENGTH; j += 2) {
                for (int k = 0; k < WIDTH; k++) {
                    field[j][k] = safeFieldThread1[j][k];
                }
            }
            try {
                BARRIER.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }


    public void generationStepThread2() {
        for (int l = 0; l < STEPS; l++) {
            safeFieldThread2 = field;
            for (int i = 1; i < LENGTH; i += 2) {
                for (int j = 0; j < WIDTH; j++) {
                    if (field[i][j] && (findNeighbor(i, j) > 3 || findNeighbor(i, j) < 2)) {
                        safeFieldThread2[i][j] = false;
                    } else if (!field[i][j] && findNeighbor(i, j) > 2) {
                        safeFieldThread2[i][j] = true;
                    }
                }
            }
            try {
                BARRIER.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            for (int j = 1; j < LENGTH; j += 2) {
                for (int k = 0; k < WIDTH; k++) {
                    field[j][k] = safeFieldThread2[j][k];
                }
            }
            try {
                BARRIER.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public int findNeighbor(int i, int j) {
        int result = 0;
        int plusI = (i + 1) % LENGTH;
        int plusJ = (j + 1) % WIDTH;
        int minusI = (i - 1 <= 0 ? LENGTH - 1 : i - 1);
        int minusJ = (j - 1 <= 0 ? WIDTH - 1 : j - 1);

        if (field[plusI][minusJ]) result++;
        if (field[plusI][j]) result++;
        if (field[plusI][plusJ]) result++;
        if (field[i][plusJ]) result++;
        if (field[minusI][plusJ]) result++;
        if (field[minusI][j]) result++;
        if (field[minusI][minusJ]) result++;
        if (field[i][minusJ]) result++;
        return result;
    }


}
