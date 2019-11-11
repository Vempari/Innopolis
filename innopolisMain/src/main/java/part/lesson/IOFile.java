package part.lesson;

import java.io.Serializable;
import java.util.Arrays;

public class IOFile implements Serializable {
    private int length;
    private int width;
    private int steps;
    boolean[][] field;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public boolean[][] getField() {
        return field;
    }

    public void setField(boolean[][] field) {
        this.field = field;
    }

    @Override
    public String toString() {
        String result = "";
        for (boolean counter[] : field) {
            for (boolean count : counter) {
                result = result +  " " + count;
            }
            result = result + System.lineSeparator();
        }
        return result;
    }
}
