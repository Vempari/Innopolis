package part.lesson;

import org.junit.Test;

import java.io.IOException;

public class GameOfLifeMonoTest {
    @Test
    public void generationStep_() throws IOException, ClassNotFoundException {
        Buffer buffer = new Buffer();
        IOFile file = buffer.getFile();
        GameOfLifeMono life =
                new GameOfLifeMono(file.getLength(), file.getWidth(), file.getSteps(), file.getField());
        life.generationStep();
    }
}
