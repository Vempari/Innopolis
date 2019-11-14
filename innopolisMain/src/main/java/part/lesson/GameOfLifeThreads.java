package part.lesson;

public class GameOfLifeThreads {
    final private int LENGTH;
    final private int WIDTH;
    final private int STEPS;
    boolean[][] field;
    boolean[][] safeField;


    public GameOfLifeThreads(int LENGTH, int WIDTH, int STEPS, boolean[][] field) {
        this.LENGTH = LENGTH;
        this.WIDTH = WIDTH;
        this.STEPS = STEPS;
        this.field = field;
    }

    public void generationStep() {
        for (int l = 0; l < STEPS; l++) {
            safeField = field;
            for (int i = 0; i < LENGTH; i++) {
                for (int j = 0; j < WIDTH; j++) {
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
