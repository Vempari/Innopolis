package part.lesson;

public class GameOfLifeMono {
    private int length;
    private int width;
    private int steps;
    boolean[][] field;

    public GameOfLifeMono(int length, int width, int steps, boolean[][] field) {
        this.length = length;
        this.width = width;
        this.steps = steps;
        this.field = field;
    }

    public void generationStep() {
        for (int l = 0; l < steps; l++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (field[i][j] && (findNeighbor(i, j) > 3 || findNeighbor(i, j) < 2)) {
                        field[i][j] = false;
                    } else if (!field[i][j] && findNeighbor(i, j) > 2) {
                        field[i][j] = true;
                    }
                }
            }
        }
    }

    public int findNeighbor(int i, int j) {
        int result = 0;
        int plusI = (i + 1) % length;
        int plusJ = (j + 1) % width;
        int minusI = (i <= 0 ? length - 1 : i - 1);
        int minusJ = (i <= 0 ? width - 1 : i - 1);

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