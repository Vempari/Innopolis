package part.lesson;

public class GameOfLifeThreads {
    private int length;
    private int width;
    private int steps;
    volatile boolean[][] field;
    Object lock = new Object();

    public GameOfLifeThreads(int length, int width, int steps, boolean[][] field) {
        this.length = length;
        this.width = width;
        this.steps = steps;
        this.field = field;
    }

    Thread thread = new Thread(() -> generationStep());
    Thread thread1 = new Thread(() -> generationStep());


    public void main() {
        thread.start();
        thread1.start();
        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void generationStep() {
        for (int l = 0; l < steps; l++) {
            boolean[][] safeField = field;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (field[i][j] && (findNeighbor(i, j) > 2 || findNeighbor(i, j) < 2)) {
                        safeField[i][j] = false;
                    } else if (!field[i][j] && findNeighbor(i, j) > 2) {
                        safeField[i][j] = true;
                    }
                }
            }
            field = safeField;
        }
    }

    public int findNeighbor(int i, int j) {
        int result = 0;
        int plusI = (i + 1) % length;
        int plusJ = (j + 1) % width;
        int minusI = (i - 1<= 0 ? length - 1 : i - 1);
        int minusJ = (j - 1<= 0 ? width - 1 : j - 1);

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
